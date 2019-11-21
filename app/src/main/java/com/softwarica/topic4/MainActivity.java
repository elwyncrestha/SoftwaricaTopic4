package com.softwarica.topic4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softwarica.topic4.activity.MessageActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    public static final Map<String, String> countries = new HashMap<String, String>() {
        {
            put("Nepal", "Kathmandu");
            put("India", "New Delhi");
            put("China", "Beijing");
            put("UK", "London");
            put("US", "Washington D.C.");
            put("Canada", "Ottawa");
        }
    };

    private ListView lvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvCountry = findViewById(R.id.lvCountry);
        ArrayAdapter countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(countries.keySet()));
        lvCountry.setAdapter(countryAdapter);

        lvCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra("message", countries.get(selectedItem));
                startActivity(intent);
            }
        });
    }
}
