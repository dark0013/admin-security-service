package com.darkross.adminsecurityservice.controller;

import com.darkross.adminsecurityservice.domain.User;
import com.darkross.adminsecurityservice.dto.request.CreateUserRequest;
import com.darkross.adminsecurityservice.service.UserServiceImpl;
import com.darkross.adminsecurityservice.service.interfaces.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getListOfUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userResponse = userService.save(user);
        return new ResponseEntity<>(userResponse, CREATED);
    }

//    @PostMapping
//    public ResponseEntity<String> create(@Valid @RequestBody CreateUserRequest request) {
//        userService.createUser(request);
//        log.info("Controller: creating user {}", request.getNombre());
//        return ResponseEntity.ok("User created");
//    }

    /*
    @PostMapping("/patients")
    public ResponseEntity<Void> createPatient(@RequestBody PatientDto dto) {
    Patient obj = patientService.create(dto);
    return ResponseUtil.created(obj.getIdPatient());
}

    * */
}
