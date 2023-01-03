package com.ProjetoIES.easyfarming.model;   

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plants")
public class Plant{
    private long id;
    private String username;
    private String name;
    private String image;
    private String description;
    private String classs;
    private String family;
    private String genus;
    private String kingdom;
    private String orderr;
    private String phylum;
    private String harmless;

    public Plant(){        
    }

    public Plant(String name,String username, String image, String description, String classs, String family, String genus, String kingdom, String orderr, String phylum, String harmless){
        this.name = name;
        this.username = username;
        this.image = image;
        this.description = description;
        this.classs = classs;
        this.family = family;
        this.genus = genus;
        this.kingdom = kingdom;
        this.orderr = orderr;
        this.phylum = phylum;
        this.harmless = harmless;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
 
    @Column(name = "image", nullable = false)
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
 
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "classs", nullable = false)
    public String getClasss() {
        return classs;
    }
    public void setClasss(String classs) {
        this.classs = classs;
    }

    @Column(name = "family", nullable = false)
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }

    @Column(name = "genus", nullable = false)
    public String getGenus() {
        return genus;
    }
    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Column(name = "kingdom", nullable = false)
    public String getKingdom() {
        return kingdom;
    }
    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    @Column(name = "orderr", nullable = false)
    public String getOrderr() {
        return orderr;
    }
    public void setOrderr(String orderr) {
        this.orderr = orderr;
    }

    @Column(name = "phylum", nullable = false)
    public String getPhylum() {
        return phylum;
    }
    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    @Column(name = "harmless", nullable = false)
    public String getHarmless() {
        return harmless;
    }
    public void setHarmless(String harmless) {
        this.harmless = harmless;
    }



    @Override
    public String toString() {
        return "Client [Name=" + name +", Username=" + username + ", Image=" + image + ", Id=" + id + ", Description=" + description
                +", Classs=" + classs + ", Family=" + family +", Genus=" + genus + ", Kingdom=" + kingdom + ", Orderr=" + orderr + ", Phylum=" + phylum +"]";
    }
}