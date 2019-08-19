package com.example.getitmall;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private com.example.getitmall.CategoryAdapter categoryAdapter;


    ///////////// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutviewAllBtn;
    private RecyclerView horizontalRecyclerView;

    ///////////// Horizontal Product Layout

    ///////////// Grid Product layout
    private TextView gridLayoutTitle;
    private Button gridLayoutViewAllBtn;
    private GridView gridview;

    ///////////// Grid Product layout



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

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

        categoryAdapter = new com.example.getitmall.CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        ///////////// Horizontal Product Layout
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutviewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        horizontalLayoutviewAllBtn.setVisibility(View.VISIBLE);
        horizontalLayoutviewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAllIntent = new Intent(view.getContext(),ViewAllActivity.class);
                viewAllIntent.putExtra("layout_code",0);
                view.getContext().startActivity(viewAllIntent);
            }
        });


        List<com.example.getitmall.HorizontalProductScrollModel>horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dining3,"Style Up","Good Quality","Kshs.10 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies1,"Awes dress","High Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dining4,"Banyan","Best Quality","Kshs.7 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.bed9,"Ilustrous","Good Quality","Kshs.3 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.office3,"Gents suit","Medium Quality","Kshs.5 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.office4,"Sal Lady","Good Quality","Kshs.6 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.blazer,"Menswear","High Quality","Kshs.7 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.ladies4,"Queens Wear","Good Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.dress6,"The Hip","Best Quality","Kshs.8 995/-"));
        horizontalProductScrollModelList.add(new com.example.getitmall.HorizontalProductScrollModel(R.drawable.office4,"Cedar Chinese","Good Quality","Kshs.7 995/-"));

        com.example.getitmall.HorizontalProductScrollAdapter horizontalProductScrollAdapter = new com.example.getitmall.HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        ///////////// Horizontal Product Layout


        ///////////// Grid Product Layout

        TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridLayoutTitle.setVisibility(View.VISIBLE);
        gridLayoutViewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewAllIntent = new Intent(view.getContext(),ViewAllActivity.class);
                viewAllIntent.putExtra("layout_code",2);
                view.getContext().startActivity(viewAllIntent);
            }
        });


        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));



        ///////////// Grid Product Layout



        return view;

    }

}
