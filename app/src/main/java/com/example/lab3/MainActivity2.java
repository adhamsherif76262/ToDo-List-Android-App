package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String[] My_Array = getResources().getStringArray(R.array.Grid_Array);
        ArrayAdapter<String> Grid_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,My_Array);
        GridView My_Grid = (GridView)findViewById(R.id.Letters_Grid_View);
        My_Grid.setAdapter(Grid_Adapter);
        My_Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView My_Text_view = (TextView) view;
                String Value = ((TextView) view).getText().toString();
                if(Character.isLowerCase(Value.charAt(0))){My_Text_view.setText(Value.toUpperCase());}
                else if(Character.isUpperCase(Value.charAt(0))){My_Text_view.setText(Value.toLowerCase());}
            }
        });
        My_Grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView My_Text_view = (TextView) view;
                String Value="";
                My_Text_view.setText(Value);

//                Grid_Adapter.remove(Grid_Adapter.getItem(i));
//                Grid_Adapter.remove(Value);
                return true;
            }
        });
    }
}