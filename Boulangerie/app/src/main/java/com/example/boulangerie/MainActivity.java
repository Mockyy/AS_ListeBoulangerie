package com.example.boulangerie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterProduit.OnItemListener {

    private RecyclerView recyclerView;
    private AdapterProduit mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Produit> liste_produit = new ArrayList<Produit>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On récupère la vue du RecyclerView dans le layout
        recyclerView = (RecyclerView) findViewById(R.id.liste);

        recyclerView.setHasFixedSize(true);

        //On set un LayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la liste
        setListe(liste_produit);

        //On set l'adapter avec la liste
        mAdapter = new AdapterProduit(liste_produit, this);

        //On applique l'adapter au RecyclerView
        recyclerView.setAdapter(mAdapter);
    }

    //Remplit la liste passée en argument de patisseries
    private void setListe(ArrayList<Produit> liste)
    {
        Produit painAuChocolat = new Produit(R.drawable.painauchocolat, "Pain au chocolat", "Ou chocolatine, c'est vous qui voyez");
        Produit eclair = new Produit(R.drawable.eclair, "Eclair au chocolat", "Celui qu'on mange, pas celui quand il y a de l'orage");
        Produit tarteAuxFraises = new Produit(R.drawable.tarteauxfraises, "Tarte aux fraises", "D'habitude dans les tartes, je mange les fruits puis je laisse la pâte");
        Produit foretNoire = new Produit(R.drawable.foretnoire, "Fôret noire", "Attention à ne pas vous y perdre");
        Produit parisBrest = new Produit(R.drawable.parisbrest, "Paris-Brest", "On pourrait croire qu'il s'agit d'une épreuve de cyclisme, mais c'est en fait une patisserie");
        Produit galetteDesRois = new Produit(R.drawable.galette, "Galette à la frangipane", "On raconte que c'est le quatrième roi mage, Balnazzar, qui a apporté la galette des rois au Christ Cosmique");
        Produit kougelhopf = new Produit(R.drawable.kougelhopf, "Kougelhopf", "Parce que ça aurait été trop simple de l'écrire simplement 'kouglopf'");
        Produit tarteCreme = new Produit(R.drawable.tartecreme, "Tarte à la crème", "Pas de blague");
        Produit tiramisu = new Produit(R.drawable.tiramisu, "Tiramisu", "Le saviez-vous ? Le tiramisu tient son nom d'un général japonais du XVIème siècle (c fo)");

        liste.add(painAuChocolat);
        liste.add(eclair);
        liste.add(tarteAuxFraises);
        liste.add(foretNoire);
        liste.add(parisBrest);
        liste.add(galetteDesRois);
        liste.add(kougelhopf);
        liste.add(tarteCreme);
        liste.add(tiramisu);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, PageProduitActivity.class);
        intent.putExtra("Pat", liste_produit.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
