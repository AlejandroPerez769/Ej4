package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


/**
 * MainActivity es la parte principal de la calculadora.
 * Se encarga de que el usuario pueda interactuar con los botones.
 *
 * @version 1.0
 * @since 2024-11-05
 */


public class MainActivity extends AppCompatActivity {

    TextView barra;


    private void botones() {

        findViewById(R.id.boton1).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton2).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton3).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton44).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton5).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton6).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton7).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton8).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton9).setOnClickListener(anyadirNumeros);
        findViewById(R.id.boton0).setOnClickListener(anyadirNumeros);

        findViewById(R.id.botonmenos).setOnClickListener(anyadirNumeros);
        findViewById(R.id.botonmas).setOnClickListener(anyadirNumeros);
        findViewById(R.id.botonc).setOnClickListener(borrarDatos);
        findViewById(R.id.botonIgual).setOnClickListener(resultado);
        findViewById(R.id.botonMult).setOnClickListener(anyadirNumeros);


    }



    private final View.OnClickListener resultado = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

           Calculator.resultado();

        }
    };

    private final View.OnClickListener borrarDatos = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Calculator.borrarDatos();

        }
    };

    private final View.OnClickListener anyadirNumeros = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Calculator.anyadirNumeros(view);

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        barra = findViewById(R.id.barra);
        Calculator.setBarra(barra);

        botones();



    }
}