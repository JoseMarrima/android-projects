package com.example.josemarrima.changana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        ArrayList<Numbers> numbersArrayList = new ArrayList<Numbers>();
        numbersArrayList.add(new Numbers("One","Um", R.drawable.numbers, R.raw.lundi));
        numbersArrayList.add(new Numbers("Three","Tres"));
        numbersArrayList.add(new Numbers("Four","Quatro"));
        numbersArrayList.add(new Numbers("Five","Cinco"));
        numbersArrayList.add(new Numbers("Six","Seis"));
        numbersArrayList.add(new Numbers("Seven","Set"));
        numbersArrayList.add(new Numbers("Eight","Oito"));
        numbersArrayList.add(new Numbers("Nine","Nove"));
        numbersArrayList.add(new Numbers("Ten","Dez"));

        NumbersAdapter numbersAdapter = new NumbersAdapter(this, numbersArrayList);

        ListView numbersListView = (ListView) findViewById(R.id.numbersList);

        numbersListView.setAdapter(numbersAdapter);
    }
}
