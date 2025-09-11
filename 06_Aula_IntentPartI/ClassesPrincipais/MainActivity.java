package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    //1) Atributo
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando os elementos
        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        //3) Evento do Botão
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*      ::: INTENT :::
                    Classe responsável pela manipulação
                    das activities... permitindo um
                    'ligação' entre elas, além de passagem
                    de valores!!!   :)
                 */

                //Instanciando a classe Intent
                Intent it = new Intent(MainActivity.this,
                                        ActivityTela2.class);

                //Iniciando a Tela02
                startActivity(it);
            }
        });

    }
}