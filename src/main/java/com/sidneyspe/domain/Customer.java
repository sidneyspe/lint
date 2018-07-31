package com.sidneyspe.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Integer cpf;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "accounts")
    @Column(name = "Value")
    private List<Account> accounts = new ArrayList<>();

    public Customer(String name, Integer cpf, List<Account> accounts) {
        this.name = name;
        this.cpf = cpf;
        this.accounts = accounts;
    }

    public Customer() {
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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
