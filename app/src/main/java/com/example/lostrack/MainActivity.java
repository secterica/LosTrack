package com.example.lostrack;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        Handler handler = new Handler();
        Runnable runnable = () -> {
            Intent intent  = new Intent(getBaseContext(), MyItemsActivity.class);
            startActivity(intent);
        };
        handler.postDelayed(runnable,500);
    }
}

