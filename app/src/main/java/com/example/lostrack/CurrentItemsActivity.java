package com.example.lostrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class CurrentItemsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_items);

        currentItemsList = findViewById(R.id.ListOfCurrentItems);
        arrayList.add(new MyItems("Keys", R.drawable.plus));
        arrayList.add(new MyItems("Wallet", R.drawable.plus));
        arrayList.add(new MyItems("Physics", R.drawable.plus));
        arrayList.add(new MyItems("umovnyy vasyl", R.drawable.plus));
        arrayList.add(new MyItems("Smartphone)", R.drawable.plus));
        for (int i = 0; i < 90; i++){
            arrayList.add(new MyItems("Maxx)", R.drawable.plus));
        }
        currentItemsList.addFooterView(new ImageView(this));
        currentItemsList.addHeaderView(new ImageView(this));
        currentItemsList.setAdapter(currentItemsAdapter);
        for (int i = 0; i < 90; i++){
            arrayList.remove(5);
        }
        currentItemsAdapter.notifyDataSetChanged();
        currentItemsAdapter.notifyDataSetInvalidated();
        arrayList.add(new MyItems("Maxx)", R.drawable.plus));
        arrayList.add(new MyItems("Maxx)", R.drawable.plus));
        currentItemsAdapter.notifyDataSetChanged();
        currentItemsAdapter.notifyDataSetInvalidated();

        currentItemsList.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + position, Toast.LENGTH_SHORT)
                    .show();
//            arrayList.remove((position-1));
//            myItemsAdapter.notifyDataSetChanged();
//            myItemsAdapter.notifyDataSetInvalidated();
        });
    }
    ListView currentItemsList;
    ArrayList<MyItems> arrayList = new ArrayList<>();
    MyItemsAdapter currentItemsAdapter = new MyItemsAdapter(CurrentItemsActivity.this, arrayList);


    public void addNewItem(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(CurrentItemsActivity.this);
        dialog.setView(R.layout.add_new_item);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();

    }

    public void addNewItemButtonClicked(View view) {
        LayoutInflater inflater = getLayoutInflater();
//        View vv = inflater.inflate(R.layout.my_items, null);
        View v = inflater.inflate(R.layout.add_new_item, null);
        EditText nameOfItem = v.findViewById(R.id.newNameOfItem);
        TextView textView = findViewById(R.id.currentItemsTextView);

        Log.i("Name", nameOfItem.getText().toString());
//        textView.setText(nameOfItem.getText().toString());
        arrayList.add(new MyItems(nameOfItem.getText().toString() + "lol", R.drawable.forwardbutton));
        currentItemsAdapter.notifyDataSetChanged();
        currentItemsAdapter.notifyDataSetInvalidated();
    }

    public void notificationClicked(View view){
        ImageView i = findViewById(R.id.currentItemsNotificationImageView);
        if (i.getTag()==null){
            i.setImageResource(R.drawable.notification_active);
            i.setTag(new Object());

            Toast.makeText(getApplicationContext(),
                    "Notification enabled", Toast.LENGTH_SHORT)
                    .show();
        }else{
            i.setTag(null);
            i.setImageResource(R.drawable.notification_disabled);

            Toast.makeText(getApplicationContext(),
                    "Notification disabled", Toast.LENGTH_SHORT)
                    .show();}
    }

    public void openMenu(View view) {
        Intent intent = new Intent(CurrentItemsActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}

