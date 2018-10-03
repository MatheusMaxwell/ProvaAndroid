package com.example.matheusmaxwellmeireles.provaandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.matheusmaxwellmeireles.provaandroid.R;
import com.example.matheusmaxwellmeireles.provaandroid.adapter.MyAdapterGrid;
import com.example.matheusmaxwellmeireles.provaandroid.model.Item;

import java.util.ArrayList;

public class MainActivity extends Activity {

    GridView gridView;
    ArrayList<Item> items;
    Button button;
    CheckBox checkBox;
    ArrayList<Integer> checks;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createListItems();

        gridView = findViewById(R.id.grid);
        gridView.setAdapter(new MyAdapterGrid(MainActivity.this, items));

        checkBox = findViewById(R.id.chkBox);

        button = findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), ActivityDescription.class);

                intent.putExtra("items", items);

                startActivity(intent);

            }
        });
    }

    //cria a lista dos itens
    public void createListItems (){

        items = new ArrayList<>();
        Item item;
        item = new Item( "Iphone X", R.drawable.iphonex, false);
        items.add(item);
        item = new Item( "Galaxy Note 9", R.drawable.note9, false);
        items.add(item);
        item = new Item("Galaxy Note 8", R.drawable.note8, false);
        items.add(item);
        item = new Item( "Iphone 6s", R.drawable.iphone6s, false);
        items.add(item);
        item = new Item( "Iphone 7 Plus", R.drawable.iphone7plus, false);
        items.add(item);
        item = new Item( "Galaxy S9", R.drawable.s9, false);
        items.add(item);


    }

}
