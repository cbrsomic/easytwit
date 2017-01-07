package com.lecture.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = "posts")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String login;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

}
