package com.sb.formation.controller;

import com.sb.formation.entities.ERole;
import com.sb.formation.entities.Role;
import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.JwtResponse;
import com.sb.formation.repository.RoleRepository;
import com.sb.formation.repository.UtilisateurRepository;
import com.sb.formation.request.LoginRequest;
import com.sb.formation.request.SignupRequest;
import com.sb.formation.security.jwt.JwtUtils;
import com.sb.formation.service.UtilisateurDetailsImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sb.formation.reponses.MessageResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Api
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    
    @PostMapping("/signin")
    @ApiOperation(value="Authentifier un utilisateur", notes="login user")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="utilisateur authentifié")
    })
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UtilisateurDetailsImpl userDetails = (UtilisateurDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getCode(),
                userDetails.getUsername(),
                roles));
    }


    @PostMapping("/signup")
    @ApiOperation(value="enregistrer un utilisateur", notes="register user")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message="utilisateur enregistré")
    })
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (utilisateurRepository.existsByLogin(signUpRequest.getLogin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(false,"Failed","Error: Login is already taken!"));
        }

        // Create new user's account
        Utilisateur user = new Utilisateur(signUpRequest.getLogin(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByNom(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleRepository.findByNom(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByNom(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        utilisateurRepository.save(user);
        return ResponseEntity.ok(new MessageResponse(true,"Succés","User registered successfully!"));
    }
}