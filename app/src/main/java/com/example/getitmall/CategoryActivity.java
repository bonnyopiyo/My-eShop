package com.example.getitmall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Home"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Clocks"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Bedroom"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Dining"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Office"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Sofas"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Wall Arts"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Outdoors"));
        categoryModelList.add(new com.example.getitmall.CategoryModel("link", "Appliances"));



        ///////////// Horizontal Product Layout

        List<com.example.getitmall.HorizontalProductScrollModel>horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies2,"LadiesWear","Good Quality","Kshs.7 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.draw5,"CouplesWear","Good Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.draw2,"MensWear","Good Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.pic5,"SwagLady","Good Quality","Kshs.5 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.indianmenswear,"Menswear","Good Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.draw4,"Couples wear","Good Quality","Kshs.9 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dress6,"Ladies","Good Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.draw1,"Vashti","Good Quality","Kshs.9 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.pic1,"Aeropostale","Good Quality","Kshs.14 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.pic6,"See me through","Good Quality","Kshs.13 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dress6,"Slim","Good Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner1,"Ladies","Good Quality","Kshs.65 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner2,"Ladies","Good Quality","Kshs.14 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.banner3,"Gents","Good Quality","Kshs.15 995/-"));





        ///////////// Horizontal Product Layout




        ///////////// Grid Product Layout




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
