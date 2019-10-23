package com.example.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsPage extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);

        listView = findViewById(R.id.listview3);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Event 1");
        arrayList.add("Event 2");
        arrayList.add("Event 3");
        arrayList.add("Event 4");
        arrayList.add("Event 5");
        arrayList.add("Event 6");
        arrayList.add("Event 7");
        arrayList.add("Event 8");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Opens Particular Event Page
            }
        });
    }
}
