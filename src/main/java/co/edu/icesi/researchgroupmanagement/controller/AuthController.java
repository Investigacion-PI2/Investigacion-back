package co.edu.icesi.researchgroupmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.researchgroupmanagement.config.util.JWTUtil;
import co.edu.icesi.researchgroupmanagement.dto.AuthRequest;
import co.edu.icesi.researchgroupmanagement.dto.AuthResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping(value = "authenticate", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        try {
            final Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String token = jwtUtil.generateToken(userDetails);
            return ResponseEntity.status(HttpStatus.OK).body(new AuthResponse(token));
        } catch (BadCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping(value = "success")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping(value = "logout")
    public String logout() {
        return "Bye!";
    }
}
