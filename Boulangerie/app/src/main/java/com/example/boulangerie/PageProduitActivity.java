package com.example.boulangerie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.ImageView;
import android.widget.TextView;

public class PageProduitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_produit);

        Intent intent = getIntent();
        Produit p = intent.getParcelableExtra("Pat");

        int image = p.getImage();
        String nom = p.getNom();
        String description = p.getDescription();

        ImageView ivImage = findViewById(R.id.image);
        ivImage.setImageResource(image);

        TextView tvNom = findViewById(R.id.nom);
        tvNom.setText(nom);

        TextView tvDescription = findViewById(R.id.description);
        tvDescription.setText(description);

    }
}
