package com.example.springbootej3.Controllers;

import com.example.springbootej3.Models.DTOs.UserDTO;
import com.example.springbootej3.Models.User;
import com.example.springbootej3.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;


    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String id){
        User usuarioEncontrado = usersService.encontrarUsuario(id);
        if (usuarioEncontrado!=null) {
            return new ResponseEntity<>(new UserDTO(usuarioEncontrado), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/user")
    public ResponseEntity<UserDTO> registerUser(@RequestBody Map<String, Object> requestBody) {
        String name;
        String surname;
        String email;
        String age;
        String birthDate;
        String password;
        try {
            name = requestBody.get("name").toString();
            surname = requestBody.get("surname").toString();
            email = requestBody.get("email").toString();
            age = requestBody.get("age").toString();
            birthDate = requestBody.get("birthDate").toString();
            password = requestBody.get("password").toString();
        }catch (Exception e){
            return new ResponseEntity<>(new UserDTO(), HttpStatus.BAD_REQUEST);
            //return "No han sido recibido los datos en su totalidad";
        }
        User usuarioCreado = usersService.registrarUsuario(name, surname,email, age,birthDate, password);
        if (usuarioCreado!=null) {
            return new ResponseEntity<>(new UserDTO(usuarioCreado), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }





















}
