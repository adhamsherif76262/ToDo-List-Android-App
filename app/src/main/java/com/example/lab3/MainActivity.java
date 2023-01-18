package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView My_list = (ListView)findViewById(R.id.ToDo_List_View);
        final ArrayAdapter<String> List_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        My_list.setAdapter(List_Adapter);
        Button Add_Button = (Button) findViewById(R.id.Add_ToDo_Item_Button);
        Add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ToDo_Edit_Text = (EditText) findViewById(R.id.Edit_Text_1);
                if(ToDo_Edit_Text.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Fill the ToDo Field Before Adding !", Toast.LENGTH_LONG).show();
                }
                else {
                    String Value = ToDo_Edit_Text.getText().toString();
                    List_Adapter.add(Value);
                    ToDo_Edit_Text.getText().clear();
                }
            }
        });
        My_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ((TextView)view).getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        My_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                List_Adapter.remove(List_Adapter.getItem(i));
//                The return statement value doesn't matter
                return true;
//                return false;
            }
        });
        Button Grid_View_Button = (Button) findViewById(R.id.Grid_Activity_Button);
        Grid_View_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
}