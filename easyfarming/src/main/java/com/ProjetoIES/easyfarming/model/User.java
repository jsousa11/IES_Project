package com.ProjetoIES.easyfarming.model;   

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User{
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(){        
    }

    public User(String first_name, String last_name, String email, String password){
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "firstName", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "lastName", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String emailId) {
        this.email = emailId;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Client [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", email=" + email
                +", password=" + password + "]";
    }
}