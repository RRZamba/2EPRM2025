package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela03 extends AppCompatActivity
{
    //1) Atributo
    TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);

        //2) 'linkando'
        txtFinal = (TextView) findViewById(R.id.txtFinal);

        // 3) Chamando o getIntent() para recuperar as var.
        Intent it = getIntent();

        // 3) Mensagem
        String texto = "Usuário Cadastrado com Sucesso!!! " +
                       "\n Nome: " + it.getStringExtra("valor1") +
                       "\n Senha: " + it.getStringExtra("valor2") +
                       "\n Parabéns...Você é um verdadeiro otário!!!";

        // 4) Colocando o valor no TextView
        txtFinal.setText(texto);
    }
}