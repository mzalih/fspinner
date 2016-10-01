package com.zalih.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.zalih.fspinner.FSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FSpinner fSpinner =(FSpinner)findViewById(R.id.spinner);
        ArrayList<String> choices = new ArrayList<>();
        //choices.add("Kerala");
        //choices.add("Andaman Nicobar");
        //choices.add("Goa");
        //choices.add("Punjab");
        fSpinner.setPreSelectedString("Select an item");
        fSpinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, choices));


    }
}
