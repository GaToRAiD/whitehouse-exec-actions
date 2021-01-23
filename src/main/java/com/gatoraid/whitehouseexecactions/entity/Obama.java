package com.gatoraid.whitehouseexecactions.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="obama")
public class Obama implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="text")
    private String text;

    @Column(name="link")
    private String link;

    public Obama() {

    }

    public Obama(String text, String link) {
        this.text = text;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Obama{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}