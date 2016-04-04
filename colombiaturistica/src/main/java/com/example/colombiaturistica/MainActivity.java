package com.example.colombiaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mhoteles) {
            Intent a= new Intent(this,hoteles.class);
            startActivity(a);
            return true;
        }

        if (id == R.id.mbares) {
            Intent b= new Intent(this,bares.class);
            startActivity(b);
            return true;
        }
        if (id == R.id.msitios) {
            Intent c= new Intent(this,Sitios.class);
            startActivity(c);
            return true;
        }
        if (id == R.id.mdemo) {
            Intent d= new Intent(this,demografica.class);
            startActivity(d);
            return true;
        }
        if (id == R.id.macerca) {
            Intent f= new Intent(this,acerca.class);
            startActivity(f);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
