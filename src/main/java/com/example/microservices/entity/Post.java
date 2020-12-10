package com.example.microservices.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //default value
    @Column(name="id_post")
    private Integer id;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User uzytkownik;

    public Post() {
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Post(Integer id, String description, User uzytkownik) {
        this.id = id;
        this.description = description;
        this.uzytkownik = uzytkownik;
    }

    @Override
    public String toString() {
        return
                " description ="+ description ;

    }
}
