package com.sidneyspe.domain;

import javax.persistence.*;


@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String hash;
    private Long userID;

    public Token(String hash) {
        this.hash = hash;

    }

    public Token() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return hash;
    }

    public void setName(String hash) {
        this.hash = hash;
    }

    public Long getUserId() {
        return userID;
    }

    public void setUserId(Long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
