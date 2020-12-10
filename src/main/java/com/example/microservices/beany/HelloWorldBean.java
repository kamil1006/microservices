package com.example.microservices.beany;


import lombok.Data;

@Data
public class HelloWorldBean {

    private final String message;

    public HelloWorldBean(String messaga) {
        this.message=messaga;
    }

    @Override
    public String toString(){

        return String.format("HellowordBean [message=%s]", message);
    }

    public String getMessage() {
        return message;
    }
}
