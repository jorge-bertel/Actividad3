package com.example.jorgeandres.notaapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    TextView porc4, porc5, porc6;
    EditText epExpo, epPrac, epProy;
    Button bGuardar, cclear;
    double uno, dos, tres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        epExpo = (EditText) findViewById(R.id.epExpo);
        epPrac = (EditText) findViewById(R.id.epPrac);
        epProy = (EditText) findViewById(R.id.epProy);
        bGuardar = (Button) findViewById(R.id.bGuardar);
        porc4 = (TextView) findViewById(R.id.eporc1);
        porc5 = (TextView) findViewById(R.id.eporc2);
        porc6 = (TextView) findViewById(R.id.eporc3);
        cclear = (Button) findViewById(R.id.cLimpiar);

        Bundle extras = getIntent().getExtras();

        epExpo.setText(String.valueOf(extras.getInt("pExpo")));
        epPrac.setText(String.valueOf(extras.getInt("pPrac")));
        epProy.setText(String.valueOf(extras.getInt("pProy")));

        uno = Double.parseDouble(epExpo.getText().toString());
        dos = Double.parseDouble(epPrac.getText().toString());
        tres = Double.parseDouble(epProy.getText().toString());


        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uno + dos + tres == 100) {
                    Intent intent = new Intent();
                    intent.putExtra("npExp", epExpo.getText().toString());
                    intent.putExtra("npPrac", epPrac.getText().toString());
                    intent.putExtra("npProy", epProy.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Error();

                }
            }
        });
        cclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epExpo.setText("");
                epPrac.setText("");
                epProy.setText("");
            }
        });
    }

    void Error() {
        Toast.makeText(this,"porcentaje total tiene que ser 100%", Toast.LENGTH_LONG).show();
    }

}




