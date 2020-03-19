package com.example.boulangerie;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Produit implements Parcelable {

    private int image;
    private String nom;
    private String description;

    protected Produit(Parcel in) {
        image = in.readInt();
        nom = in.readString();
        description = in.readString();
    }

    public static final Creator<Produit> CREATOR = new Creator<Produit>() {
        @Override
        public Produit createFromParcel(Parcel in) {
            return new Produit(in);
        }

        @Override
        public Produit[] newArray(int size) {
            return new Produit[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(nom);
        dest.writeString(description);
    }
}
