package com.jasrin.simplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String country[]={"Bangladesh","India","Pakistan","New Zealand","China","USA","Australia","Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,country);//adapter initialize

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("name",country[position]);
                startActivity(intent);
                Toast.makeText(MainActivity.this, country[position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
