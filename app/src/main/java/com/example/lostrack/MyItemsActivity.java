package com.example.lostrack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MyItemsActivity extends AppCompatActivity {
//        arrayAdapter = new ArrayAdapter<MyItems>(MyItemsActivity.this,R.layout.example_of_list_of_items,R.id.exampleTextView,arrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_items);

        myItemsList = findViewById(R.id.ListOfMyItems);
        arrayList.add(new Items("Keys", R.drawable.plus));
        arrayList.add(new Items("Wallet", R.drawable.plus));
        arrayList.add(new Items("Physics", R.drawable.plus));
        arrayList.add(new Items("umovnyy vasyl", R.drawable.plus));
        arrayList.add(new Items("Smartphone)", R.drawable.plus));
        arrayList.add(new Items("Backpack", R.drawable.plus));
        for (int i = 0; i < 90; i++){
            arrayList.add(new Items("Maxx)", R.drawable.plus));
        }
        myItemsList.addFooterView(new ImageView(this));
        myItemsList.addHeaderView(new ImageView(this));
        myItemsList.setAdapter(myItemsAdapter);
        for (int i = 0; i < 90; i++){
            arrayList.remove(6);
        }
        myItemsAdapter.notifyDataSetChanged();
        myItemsAdapter.notifyDataSetInvalidated();
        arrayList.add(new Items("M", R.drawable.plus));
        myItemsAdapter.notifyDataSetChanged();
        myItemsAdapter.notifyDataSetInvalidated();


        myItemsList.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),
                    "Click ListItem Number " + position, Toast.LENGTH_SHORT)
                    .show();
//            arrayList.remove((position-1));
//            myItemsAdapter.notifyDataSetChanged();
//            myItemsAdapter.notifyDataSetInvalidated();
        });
    }
    ListView myItemsList;
    ArrayList<Items> arrayList = new ArrayList<>();
    ItemsAdapter myItemsAdapter = new ItemsAdapter(MyItemsActivity.this, arrayList);
//    ArrayAdapter arrayAdapter;

    public void addNewItem(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MyItemsActivity.this);
        dialog.setView(R.layout.add_new_item);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        Button addButton = alertDialog.findViewById(R.id.addButton);
        assert addButton != null;
        addButton.setOnClickListener(v ->{
            LayoutInflater inflater = getLayoutInflater();
//        View vv = inflater.inflate(R.layout.my_items, null);
            EditText nameOfItem = alertDialog.findViewById(R.id.newNameOfItem);
            assert nameOfItem != null;
            Log.i("Name", nameOfItem.getText().toString());
//        textView.setText(nameOfItem.getText().toString());
            arrayList.add(new Items(nameOfItem.getText().toString(), R.drawable.plus));
            myItemsAdapter.notifyDataSetChanged();
            myItemsAdapter.notifyDataSetInvalidated();
            alertDialog.cancel();
        });


    }


    public void notificationClicked(View view){
        ImageView i = findViewById(R.id.notificationImageView);
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
        Intent intent = new Intent(getBaseContext(), MenuActivity.class);
        startActivity(intent);
    }
}
