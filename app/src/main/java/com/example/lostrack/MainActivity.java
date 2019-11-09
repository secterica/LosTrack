package com.example.lostrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ArrayList<String > Items = new ArrayList<>();
                Items.add("Keys");
                Items.add("Wallet");
                setContentView(R.layout.menu);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, Items);
                ListView listOfMyItems = findViewById(R.id.ListOfMyItems);
                listOfMyItems.setAdapter(arrayAdapter);
            }
        };
        while (!handler.postDelayed(runnable, 3000)) {
            Log.i("I","loading...");
        }

    }
}
