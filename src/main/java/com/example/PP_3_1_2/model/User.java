package com.example.PP_3_1_2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
//    @NotBlank(message = "Surname is required field")
    private String name;
    @Column(name = "surname")
//    @NotBlank(message = "Surname is required field")
    private String surname;
    @Column(name = "age")
//    @Min(value = 0, message = "must be greater then 0")
//    @Max(value = 150, message = "must be less then 150")
    private int age;
    @Column(name = "profession")
//    @NotBlank(message = "Surname is required field, if you are unemployed write this")
    private String profession;

    public User() {
    }

    public User(String name, String surname, int age, String profession) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.profession = profession;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
