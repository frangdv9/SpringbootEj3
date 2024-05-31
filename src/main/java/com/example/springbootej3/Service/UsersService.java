package com.example.springbootej3.Service;

import com.example.springbootej3.Models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private List<User> users = new ArrayList<>();

    public User registrarUsuario(String name, String surname, String email, String age, String birthDate, String password ){
        String validationResponseMessage = validateUserRegistration(name, surname, email, age, birthDate, password);
        if(validationResponseMessage.isBlank()){
            User usuarioNuevo = new User(users.size()+1 ,name, surname, email, Integer.parseInt(age),birthDate, password);
            users.add(usuarioNuevo);
            return usuarioNuevo;
        }
        return null;
    }
    public User encontrarUsuario(String id){
        if (users.isEmpty()){
            return null;
        }
        Optional<User> usuarioEncontrado = users.stream().filter(usuario ->
                usuario.getId().equals(Integer.parseInt(id))).findFirst();
        if(usuarioEncontrado.isPresent()){
            return usuarioEncontrado.get();
        }
        else{
            return null;
        }
    }
    private String validateUserRegistration(String name, String surname, String email, String age, String birthDate, String password) {
        if (name.isBlank() || surname.isBlank() || email.isBlank() || age.isBlank() || birthDate.isBlank() || password.isBlank()) {
            return "Por favor verifique que no esté enviando ningún valor vacío";
        }

        Integer parsedAge = 0;
        try {
            parsedAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return "La edad debe ser un valor numérico";
        }

        // Validación de la contraseña
        if (password.length() < 8 || password.length() > 16) {
            return "La contraseña debe contener entre 8 y 16 caracteres";
        }

        // Validación de la edad mínima
        if (parsedAge < 18) {
            return "El usuario debe tener como mínimo 18 años de edad";
        }

        // Validación de email único
        if (!users.isEmpty()) {
            if (users.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email))) {
                return "Ya existe un usuario registrado con este email";
            }
        }

        return ""; // Todos los campos son válidos
    }

}
