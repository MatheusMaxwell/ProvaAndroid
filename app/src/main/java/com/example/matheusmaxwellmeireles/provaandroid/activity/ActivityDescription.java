package com.example.matheusmaxwellmeireles.provaandroid.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matheusmaxwellmeireles.provaandroid.R;
import com.example.matheusmaxwellmeireles.provaandroid.adapter.MyAdapterList;
import com.example.matheusmaxwellmeireles.provaandroid.model.Item;

import java.util.ArrayList;



public class ActivityDescription extends Activity {

    ArrayList<Item> itemsCheck;
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ArrayList<Item> items = (ArrayList<Item>) getIntent().getSerializableExtra("items");
        itemsCheck = new ArrayList<>();

        for (int i=0; i<items.size();i++){
            if(items.get(i).isCheck()){
                itemsCheck.add(items.get(i));
            }
        }
        unCheckAll();
        listView = findViewById(R.id.list);
        listView.setAdapter(new MyAdapterList(ActivityDescription.this, itemsCheck));

        button = findViewById(R.id.btnCompartilhar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = getStringForShare();
                if(msg.isEmpty()){
                    new AlertDialog.Builder(ActivityDescription.this).setTitle("Erro!").
                            setMessage("Nenhum item foi selecionado.").setPositiveButton("OK",null)
                            .show();
                }
                else{
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, msg);
                    intent.setType("text/plain");
                    startActivity(intent);
                }
            }
        });



    }

    //coloca false em todos os itens da lista
    private void unCheckAll(){
        for(int i=0; i<itemsCheck.size(); i++){
            itemsCheck.get(i).setCheck(false);
        }
    }

    //Junta todas as descriçoes em uma string
    private String getStringForShare (){
        String ret = "";

        for(int i=0; i<itemsCheck.size(); i++){
            if(itemsCheck.get(i).isCheck()){
                if(i == itemsCheck.size()){
                    ret += itemsCheck.get(i).getDesc() + ".";
                }
                else{
                    ret += itemsCheck.get(i).getDesc() + ", ";
                }

            }
        }

        return ret;
    }

}
