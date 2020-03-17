package com.example.boulangerie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterProduit extends RecyclerView.Adapter<AdapterProduit.ViewHolder> {

    private Context mContext;
    private int nResource;
    private ArrayList<Produit> produit;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView nom;
        public TextView description;

        public ViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            nom = (TextView) v.findViewById(R.id.nom);
            description = (TextView) v.findViewById(R.id.description);
        }
    }

    public AdapterProduit(@NonNull ArrayList<Produit> objects) {
        this.produit = new ArrayList<Produit>();
        for(Produit p : objects)
        {
            this.produit.add(new Produit(p));
        }
    }

    @NonNull
    @Override
    public AdapterProduit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_produit, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(produit.get(position).getImage());
        holder.nom.setText(produit.get(position).getNom());
        holder.description.setText(produit.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return produit.size();
    }
}
