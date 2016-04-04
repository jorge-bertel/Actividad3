package com.example.jorgeandres.notaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView porc1,porc2,porc3;
    EditText eExpo, ePrac, eProy, eNota;
    Button bCalc,bclear;
    double expo2=0,prac2=0,proye2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eExpo = (EditText) findViewById(R.id.eExpo);
        ePrac = (EditText) findViewById(R.id.ePrac);
        eProy = (EditText) findViewById(R.id.eProy);
        eNota = (EditText) findViewById(R.id.eNotaF);
        bCalc = (Button) findViewById(R.id.bCalcular);
        bclear = (Button) findViewById(R.id.bLimpiar);
        porc1=(TextView) findViewById(R.id.eporc1);
        porc2=(TextView) findViewById(R.id.eporc2);
        porc3=(TextView) findViewById(R.id.eporc3);

        porc1.setText(String.valueOf(expo2+"%"));
        porc2.setText(String.valueOf(prac2+"%" ));
        porc3.setText(String.valueOf(proye2+"%"));




        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double cien,nota, exp1, prac1, proy1;

                exp1 = Double.parseDouble(eExpo.getText().toString());
                prac1 = Double.parseDouble(ePrac.getText().toString());
                proy1 = Double.parseDouble(eProy.getText().toString());

                nota = exp1 * expo2 / 100 +
                        prac1 * prac2 / 100 +
                        proy1 * proye2 / 100;
                cien=expo2+prac2+proye2;
                if (nota <= 5 && cien==100  ) {
                    eNota.setText(String.valueOf(nota));
                } else {
                    eNota.setText(String.valueOf("datos invalidos de 0-5 notas o porcentaje "));
                }
            }
        });

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExpo.setText("");
                ePrac.setText("");
                eProy.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mConfigurar) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("pExpo", expo2);
            intent.putExtra("pPrac", prac2);
            intent.putExtra("pProy", proye2);
            startActivityForResult(intent, 1234);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1234 && resultCode == RESULT_OK) {
            expo2 = Double.parseDouble(data.getExtras().getString("npExp"));
            prac2 = Double.parseDouble(data.getExtras().getString("npPrac"));
            proye2 = Double.parseDouble(data.getExtras().getString("npProy"));

            porc1.setText(String.valueOf(expo2+"%"));
            porc2.setText(String.valueOf(prac2+"%"));
            porc3.setText(String.valueOf (proye2+"%"));

            Toast.makeText(MainActivity.this, "Nuevos Datos: Exposiciones: " + expo2 + " Practicas" + prac2 + " " +
                    "Proyecto" + proye2, Toast.LENGTH_SHORT).show();
        }
    }
}
