package com.example.colombiaturistica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class bares extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bares);
        Bundle extras = getIntent().getExtras();
    }

}
