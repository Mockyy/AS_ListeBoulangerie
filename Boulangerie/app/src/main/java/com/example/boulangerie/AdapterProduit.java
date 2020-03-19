package com.example.boulangerie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class AdapterProduit extends RecyclerView.Adapter<AdapterProduit.ViewHolder> implements Filterable {

    private Context mContext;
    private int nResource;
    private ArrayList<Produit> produit;
    private ArrayList<Produit> produitFull;
    private OnItemListener mItemListener;

    @Override
    public Filter getFilter() {
        return pFilter;
    }

    private Filter pFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Produit> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(produitFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Produit p : produitFull) {
                    if (p.getNom().toLowerCase().contains(filterPattern)) {
                        filteredList.add(p);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            produit.clear();
            produit.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView image;
        public TextView nom;
        public TextView description;
        OnItemListener itemListener;

        public ViewHolder(View v, OnItemListener itemListener) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            nom = (TextView) v.findViewById(R.id.nom);
            description = (TextView) v.findViewById(R.id.description);
            this.itemListener = itemListener;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.onItemClick(getAdapterPosition());
        }
    }

    public AdapterProduit(@NonNull ArrayList<Produit> objects, OnItemListener onItemListener) {
        this.produit = new ArrayList<Produit>();
        for(Produit p : objects)
        {
            this.produit.add(new Produit(p));
        }
        produitFull = new ArrayList<>(this.produit);
        this.mItemListener = onItemListener;
    }

    @NonNull
    @Override
    public AdapterProduit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_produit, parent, false);
        ViewHolder vh = new ViewHolder(v, mItemListener);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(produit.get(position).getImage());
        holder.nom.setText(produit.get(position).getNom());
        holder.description.setText(produit.get(position).getDescription());
        holder.itemListener = mItemListener;
    }

    @Override
    public int getItemCount() {
        return produit.size();
    }

    public interface  OnItemListener {
        void onItemClick(int position);
    }
}
