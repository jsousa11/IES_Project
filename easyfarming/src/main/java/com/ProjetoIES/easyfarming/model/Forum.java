package com.ProjetoIES.easyfarming.model;

import javax.persistence.*;

@Entity
@Table(name="forum")
public class Forum {
    private long id;
    private String username;
    private String question;

    private String username1;
    private String answer1;

    private String username2;
    private String answer2;

    private String username3;
    private String answer3;

    private String username4;
    private String answer4;

    private String username5;
    private String answer5;

    public Forum(){}


    public Forum(long id, String username, String question, String username1, String answer1, String username2, String answer2, String username3, String answer3, String username4, String answer4, String username5, String answer5) {
        this.id = id;
        this.username = username;
        this.question = question;
        this.username1 = username1;
        this.answer1 = answer1;
        this.username2 = username2;
        this.answer2 = answer2;
        this.username3 = username3;
        this.answer3 = answer3;
        this.username4 = username4;
        this.answer4 = answer4;
        this.username5 = username5;
        this.answer5 = answer5;
    }

    public Forum(String username, String question, String username1, String answer1, String username2, String answer2, String username3, String answer3, String username4, String answer4, String username5, String answer5) {
        this.username = username;
        this.question = question;
        this.username1 = username1;
        this.answer1 = answer1;
        this.username2 = username2;
        this.answer2 = answer2;
        this.username3 = username3;
        this.answer3 = answer3;
        this.username4 = username4;
        this.answer4 = answer4;
        this.username5 = username5;
        this.answer5 = answer5;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "question", nullable = false)
    public String getQuestion(){
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "username1", nullable = false)
    public String getUsername1(){
        return username1;
    }
    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    @Column(name = "answer1", nullable = false)
    public String getAnswer1(){
        return answer1;
    }
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    @Column(name = "username2", nullable = false)
    public String getUsername2(){
        return username2;
    }
    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    @Column(name = "answer2", nullable = false)
    public String getAnswer2(){
        return answer2;
    }
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Column(name = "username3", nullable = false)
    public String getUsername3(){
        return username3;
    }
    public void setUsername3(String username3) {
        this.username3 = username3;
    }

    @Column(name = "answer3", nullable = false)
    public String getAnswer3(){
        return answer3;
    }
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @Column(name = "username4", nullable = false)
    public String getUsername4(){
        return username4;
    }
    public void setUsername4(String username4) {
        this.username4 = username4;
    }

    @Column(name = "answer4", nullable = false)
    public String getAnswer4(){
        return answer4;
    }
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    @Column(name = "username5", nullable = false)
    public String getUsername5(){
        return username5;
    }
    public void setUsername5(String username5) {
        this.username5 = username5;
    }

    @Column(name = "answer5", nullable = false)
    public String getAnswer5(){
        return answer5;
    }
    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }
}
