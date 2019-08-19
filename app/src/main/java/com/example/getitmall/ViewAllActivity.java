package com.example.getitmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deal Of The Day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = findViewById(R.id.recycler_view);
        gridview = findViewById(R.id.grid_view);

        recyclerview.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);



        gridview.setVisibility(View.VISIBLE);
        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dress6,"Ladies","Good Quality","Kshs.5 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies2,"Ladies","High Quality","Kshs.4 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies1,"Banyan","Best Quality","Kshs.9 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies4,"Ladies","Good Quality","Kshs.9 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.bed9,"Ilustrous","Medium Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.bed8,"Sal Swee","Good Quality","Kshs.4 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.blazer,"Blazer","High Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner1,"Ladies Tweng","Good Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner2,"The Lady","Best Quality","Kshs.5 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner3,"Mens Tweng","Good Quality","Kshs.9 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner3,"India stuff","Medium Quality","Kshs.145 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dining3,"Sal Wear","Good Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies5,"Ladies","High Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dining4,"Hold Dee","Good Quality","Kshs.7 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.office3,"The Real Gent","Best Quality","Kshs.5 995/-"));
        GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
        gridview.setAdapter(gridProductLayoutAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
