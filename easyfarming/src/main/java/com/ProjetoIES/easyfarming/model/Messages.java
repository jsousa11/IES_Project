package com.ProjetoIES.easyfarming.model;


import javax.persistence.*;

@Entity
@Table(name = "weatherAlert")
public class Messages {
    private long id;
    private String weatherAlert;

    public Messages() {
    }
    public Messages(String weatherAlert) {
        this.weatherAlert = weatherAlert;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "weatherAlert", nullable = false)
    public String getMessage() {
        return weatherAlert;
    }
    public void setMessage(String message) {
        this.weatherAlert = message;
    }

    @Override
    public String toString() {
        return "Messages [id=" + id + ", message=" + weatherAlert + "]";
    }

}
