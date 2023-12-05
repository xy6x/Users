package com.example.users.Controller;

import com.example.users.ApiException.ApiException;
import com.example.users.Model.MyUser;
import com.example.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid MyUser myUser, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addUser(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("added user");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@RequestBody @Valid MyUser myUser,Errors errors ){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, myUser));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
    @GetMapping("/get/{email}")
    public ResponseEntity getEmail(@PathVariable String email){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getEmail(email));

    }
    @GetMapping("/check/{userName}/{password}")
    public ResponseEntity CheckUser(@PathVariable String userName,@PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(userService.checkUser(userName,password));
    }
    @GetMapping("/search/{role}")
    public  ResponseEntity searchRole(@PathVariable String role){
        List<MyUser> myUsers =userService.searchUserRole(role);
        return ResponseEntity.status(HttpStatus.OK).body(myUsers);

    }
    @GetMapping("/sea/{age}")
    public ResponseEntity searchAge(@PathVariable Integer age){
        List<MyUser> myUsers =userService.searchAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(myUsers);

    }
}
