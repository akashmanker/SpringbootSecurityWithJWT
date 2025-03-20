package com.akashcodez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;
    String discription;
    String status;
    int assigned;


    public Task(int assigned, String status, String discription, String title) {
        this.assigned = assigned;
        this.status = status;
        this.discription = discription;
        this.title = title;
    }

    public Task() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getassigned() {
        return assigned;
    }

    public void setassigned(int assigned) {
        this.assigned = assigned;
    }
}
