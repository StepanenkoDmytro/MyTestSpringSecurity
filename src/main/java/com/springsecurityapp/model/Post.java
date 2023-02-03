package com.springsecurityapp.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column(name = "post_title")
    private String title;
    @Column(name = "post_anons")
    private String anons;

    @Column(name = "post_full_text")
    private String fullText;
    @Column(name = "post_tag")
    private String tag;
    public Post() {
    }

    public Post(String title, String anons, String fullText, String tag) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.tag = tag;
    }

    public Post(long id, String title, String anons, String fullText, String tag) {
        this.id = id;
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.tag = tag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", anons='" + anons + '\'' +
                ", fullText='" + fullText + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}