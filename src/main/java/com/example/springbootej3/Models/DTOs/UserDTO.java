package com.example.springbootej3.Models.DTOs;

import com.example.springbootej3.Models.User;

public class UserDTO {
    private String name, surname, email;
    private Integer age;
    public UserDTO(){

    };
    public UserDTO(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.surname = user.getSurname();
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }
}
