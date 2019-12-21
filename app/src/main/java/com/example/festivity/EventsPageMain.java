package com.example.festivity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventsPageMain extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_recycler);

//        listView = findViewById(R.id.listview3);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//
//        arrayList.add("Event 1");
//        arrayList.add("Event 2");
//        arrayList.add("Event 3");
//        arrayList.add("Event 4");
//        arrayList.add("Event 5");
//        arrayList.add("Event 6");
//        arrayList.add("Event 7");
//        arrayList.add("Event 8");
//
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Opens Particular Event Page
//            }
//        });

        RecyclerView recyclerView = findViewById(R.id.rv_list);
        List<item> mlist = new ArrayList<>();
        mlist.add(new item(R.drawable.slurp,"Slurp"));
        mlist.add(new item(R.drawable.pong,"Pong"));
        mlist.add(new item(R.drawable.pop,"Pop"));


        Events_adapter eventsadapter = new Events_adapter(this, mlist);
        recyclerView.setAdapter(eventsadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
