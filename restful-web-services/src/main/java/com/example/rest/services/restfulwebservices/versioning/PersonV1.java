package com.example.rest.services.restfulwebservices.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
