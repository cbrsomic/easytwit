package com.lecture.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    private String text;

    private ZonedDateTime date = ZonedDateTime.now();

    @ManyToMany(mappedBy = "posts", fetch = FetchType.EAGER)
    private Set<Hashtag> hashtags = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "likes",
            joinColumns = {@JoinColumn(name = "postId")},
            inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> likes = new HashSet<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();

}
