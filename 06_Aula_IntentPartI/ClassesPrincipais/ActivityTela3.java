package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityTela3 extends AppCompatActivity
{
    //1) Atributos
    TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        // 2) Iniciando o elemento
        txtFinal = (TextView) findViewById(R.id.txtFinal);

        // 3) Intent para receber o valor
        Intent it = getIntent();

        //3) Mensagem
        String mensagem = "Usuário Cadastrado!!! \n Nome: "
                         + it.getStringExtra("Valor1");

        //4) Colocando a mensagem no TextView
        txtFinal.setText(mensagem);
    }
}