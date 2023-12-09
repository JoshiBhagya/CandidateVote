package com.ecommerce.api.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Candidate {
    private String name;
    private int voteCount;

    public Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }
}