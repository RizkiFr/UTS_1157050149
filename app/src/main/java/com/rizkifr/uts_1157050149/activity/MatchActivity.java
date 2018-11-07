package com.rizkifr.uts_1157050149.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rizkifr.uts_1157050149.R;
import com.rizkifr.uts_1157050149.adapter.MatchAdapter;
import com.rizkifr.uts_1157050149.model.MatchModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchActivity extends AppCompatActivity {

    @BindView(R.id.rv_pertandingan)
    RecyclerView mRecyclerView;
    MatchAdapter mAdapter;
    ArrayList<MatchModel> listMatch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Hasil PERSIB");

        listMatch.add(new MatchModel("Persib", "Persija", "3", "2", "Stadion Bandung Lautan API", R.drawable.persib, R.drawable.persija, "http://persib.co.id/"));
        listMatch.add(new MatchModel("Persib", "Psms", "3", "0", "Stadion Bandung Lautan API", R.drawable.persib, R.drawable.psms, "http://persib.co.id/"));
        listMatch.add(new MatchModel("Persib", "Arema", "2", "1", "Stadion Bandung Lautan API", R.drawable.persib, R.drawable.arema, "http://persib.co.id/"));
        listMatch.add(new MatchModel("Persib", "Sriwijaya", "2", "1", "Stadion Bandung Lautan API", R.drawable.persib, R.drawable.sriwijaya, "http://persib.co.id/"));

        mRecyclerView = findViewById(R.id.rv_pertandingan);
        mAdapter = new MatchAdapter(MatchActivity.this, listMatch);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

