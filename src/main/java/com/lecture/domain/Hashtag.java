package com.lecture.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(exclude = "posts")
public class Hashtag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hashtagId;

    private String text;

    @ManyToMany(mappedBy = "hashtags")
    private Set<Post> posts = new HashSet<>();

}
