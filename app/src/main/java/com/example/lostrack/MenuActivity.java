package com.example.lostrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        ImageView menuButton = findViewById(R.id.menuImage);
        menuButton.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this,MyItemsActivity.class)));
        ListView menuList =  findViewById(R.id.menuList);
        menuList.setOnItemClickListener((parent, view, position, id) -> {
            switch (position){
                case 1:
                    break;
                case 2:
                    startActivity(new Intent(MenuActivity.this, MyItemsActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MenuActivity.this, CurrentItemsActivity.class));
                    break;
                default:
                        break;
            }
        });
        menuList.addFooterView(new ImageView(this));
        menuList.addHeaderView(new ImageView(this));
        ArrayList<Items> menuArrayList = new ArrayList<>();
        menuArrayList.add(new Items("Schedule", R.drawable.plus));
        menuArrayList.add(new Items("MyItems", R.drawable.plus));
        menuArrayList.add(new Items("CurrentItems", R.drawable.plus));

        MenuAdapter menuAdapter = new MenuAdapter(getBaseContext(), menuArrayList);
        menuList.setAdapter(menuAdapter);
    }

}
