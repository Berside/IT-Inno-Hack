package org.innohack.pms.controllers;

import jakarta.validation.Valid;
import org.innohack.pms.config.auth.TokenProvider;
import org.innohack.pms.models.UserModel;
import org.innohack.pms.schemas.user.AuthUserSchema;
import org.innohack.pms.schemas.user.CreateUserSchema;
import org.innohack.pms.schemas.user.JWTSchema;
import org.innohack.pms.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody CreateUserSchema data) {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTSchema> signIn(@RequestBody AuthUserSchema data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login, data.password);
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenService.generateAccessToken((UserModel) authUser.getPrincipal());
        JWTSchema response = new JWTSchema();
        response.accessToken = accessToken;
        return ResponseEntity.ok(response);
    }
}
