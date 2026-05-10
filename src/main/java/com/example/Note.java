package com.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Note {
    @Id
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    public Note(String title, String content){
        generateId();
        this.content = content;
        this.title = title;
    }

    public void titleUpdate(String title) {
        this.title = title;
    }

    public void contentUpdate(String content) {
        this.content = content;
    }

    public void generateId() {
        this.id = new Random().nextLong();
    }

    @Override
    public String toString() {
        return "ID: " + id + "; Title: " + title + "; Content: " + content;
    }
}
