package com.example.boulangerie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.liste);

        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Produit painAuChocolat = new Produit(R.drawable.painauchocolat, "Pain au chocolat", "Ou chocolatine, c'est vous qui voyez");
        Produit eclair = new Produit(R.drawable.eclair, "Eclair au chocolat", "Celui qu'on mange, pas celui quand il y a de l'orage");
        Produit tarteAuxFraises = new Produit(R.drawable.tarteauxfraises, "Tarte aux fraises", "D'habitude dans les tartes, je mange les fruits puis je laisse la pâte");
        Produit foretNoire = new Produit(R.drawable.foretnoire, "Fôret noire", "Attention à ne pas vous y perdre");
        Produit parisBrest = new Produit(R.drawable.parisbrest, "Paris-Brest", "On pourrait croire qu'il s'agit d'une épreuve de cyclisme, mais c'est en fait une patisserie");
        Produit galetteDesRois = new Produit(R.drawable.galette, "Galette à la frangipane", "On raconte que c'est le quatrième roi mage, Balnazzar, qui a apporté la galette des rois au Christ Cosmique");
        Produit kougelhopf = new Produit(R.drawable.kougelhopf, "Kougelhopf", "Parce que ça aurait été trop simple de l'écrire simplement 'kouglopf'");
        Produit tarteCreme = new Produit(R.drawable.tartecreme, "Tarte à la crème", "Pas de blague");
        Produit tiramisu = new Produit(R.drawable.tiramisu, "Tiramisu", "Le saviez-vous ? Le tiramisu tient son nom d'un général japonais du VIIème siècle");

        ArrayList<Produit> liste_produit = new ArrayList<Produit>();
        liste_produit.add(painAuChocolat);
        liste_produit.add(eclair);
        liste_produit.add(tarteAuxFraises);
        liste_produit.add(foretNoire);
        liste_produit.add(parisBrest);
        liste_produit.add(galetteDesRois);
        liste_produit.add(kougelhopf);


        mAdapter = new AdapterProduit(liste_produit);

        recyclerView.setAdapter(mAdapter);

    }
}
