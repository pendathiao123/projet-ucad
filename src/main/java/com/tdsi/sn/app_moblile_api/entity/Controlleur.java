package com.tdsi.sn.app_moblile_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "controlleur")
public class Controlleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idControle;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int telephone;

    @Column(name = "code",nullable = false)
    private String code;

    @Column(nullable = false)
    private String password;
    private String roles;
    private String permissions;
    public List<String> getRolesList(){
        if (this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    public List<String> getPermissionsList(){
        if (this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "idResto")
    private Restaurant restaurant;

    public int getIdControle() {
        return idControle;
    }

    public void setIdControle(int idControle) {
        this.idControle = idControle;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    /*
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "bilan",
            joinColumns = @JoinColumn(name = "idControle"),
            inverseJoinColumns = @JoinColumn(name = "idResto")
    )
    private List<Restaurant> restaurants = new ArrayList<>();

     */

}
