package com.ivankrn.springbootcourse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_gen")
    @SequenceGenerator(name = "global_seq_gen", sequenceName = "global_seq")
    private long id;
    private String username;
    private String password;
    private String role;
}
