package com.darkross.adminsecurityservice.controller;
import com.darkross.adminsecurityservice.dto.request.CreateUserRequest;
import com.darkross.adminsecurityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController  {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CreateUserRequest request) {
        userService.createUser(request);
        log.info("Controller: creating user {}", request.getNombre());
        return ResponseEntity.ok("User created");
    }
}
