package com.example.springbootej3.Models;

public class User {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String birthDate;
    private String password;

    public User() {}

    public User(Integer id,String name, String surname, String email, Integer age, String birthDate, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
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

    public String getPassword() {
        return password;
    }
}
