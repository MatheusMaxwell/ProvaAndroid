package com.example.matheusmaxwellmeireles.provaandroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.matheusmaxwellmeireles.provaandroid.R;
import com.example.matheusmaxwellmeireles.provaandroid.model.Item;

import java.util.ArrayList;

public class MyAdapterGrid extends BaseAdapter {

    Context context;
    ArrayList<Item> items;

    public MyAdapterGrid(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Item item = items.get(position);

        if(convertView == null){
            convertView = View.inflate(context, R.layout.grid_layout, null);
        }

        ImageView imageView = convertView.findViewById(R.id.image);
        CheckBox checkBox = convertView.findViewById(R.id.chkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(item.isCheck()){
                    item.setCheck(false);
                }
                else{
                    item.setCheck(true);
                }
            }
        });

        imageView.setImageResource(item.getImage());




        return convertView;
    }
}
