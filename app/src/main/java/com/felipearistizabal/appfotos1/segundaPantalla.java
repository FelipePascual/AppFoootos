package com.felipearistizabal.appfotos1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class segundaPantalla extends AppCompatActivity {

    String mensaje;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);
        message = findViewById(R.id.textoSegundaP);

        Intent recibirDatos = getIntent();
        mensaje = recibirDatos.getStringExtra("textoSegundaP");
        message.setText(mensaje);
    }
}