package com.example.microservices.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.List;

//@Data
@Entity
@Table//(name="user")
public class User {




    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //default value
    //@Column(name="id")
    private Integer id;

    @Size(min=2, message = "nazwa powinna miec przynajmniej dwa znaki " )
    @Column(name="name")
    private String name;

   // @Past
    @Column(name="birth_date")
    private String birthDate;

    @OneToMany(mappedBy = "uzytkownik")
    private List<Post> posts;



    public User(Integer id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", posts=" + posts +
                '}';
    }
}
