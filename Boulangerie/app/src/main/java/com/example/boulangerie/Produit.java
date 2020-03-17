package com.example.boulangerie;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Produit {

    private int image;
    private String nom;
    private String description;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit(int image, String nom, String description) {
        this.image = image;
        this.nom = nom;
        this.description = description;
    }

    public Produit(Produit p)
    {
        this.image = p.getImage();
        this.nom = p.getNom();
        this.description = p.getDescription();
    }
}
