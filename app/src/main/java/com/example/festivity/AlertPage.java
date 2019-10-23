package com.example.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AlertPage extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_page);

        Spinner spinner = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.AlertTeams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openMainDashboard();
            }
        });
    }

    public void openMainDashboard(){
        Intent intent = new Intent(this, MainDashboard.class);
        startActivity(intent);
    }
}
