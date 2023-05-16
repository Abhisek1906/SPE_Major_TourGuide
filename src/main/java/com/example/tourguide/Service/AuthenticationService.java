package com.example.tourguide.Service;

import com.example.tourguide.Entity.*;
import com.example.tourguide.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println(request.getRole());
        if(request.getRole().equals("ROLE_ADMIN")){
            var user= User.builder()
                    .firstname((request.getFirstname()))
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.ROLE_ADMIN)
                    .build();
            repo.save(user);
            var jwtToken= jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();


        }else{
            var user= User.builder()
                    .firstname((request.getFirstname()))
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.ROLE_USER)
                    .build();
            repo.save(user);
            var jwtToken= jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        // If the user is a valid user then only give the token.
        System.out.println(request);
       Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

       if(authentication.isAuthenticated()){
           var user=repo.findByEmail(request.getEmail())
                   .orElseThrow();

           System.out.println("user"+user);
           var jwtToken= jwtService.generateToken(user);
           return AuthenticationResponse.builder()
                   .id(user.getId())
                   .token(jwtToken)
                   .build();
       }else{
           System.out.println("invalid user");
           throw new UsernameNotFoundException("invalid user request!");
       }

    }
}
