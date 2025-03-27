package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela02 extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome, txtSenha, txtConfSenha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);

        // 2) 'Linkando' os itens
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtConfSenha = (EditText) findViewById(R.id.txtConfSenha);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        // 3) Evento do botao
        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Pegando os valores
                String nome = txtNome.getText().toString();
                String senha = txtSenha.getText().toString();
                String confSenha = txtConfSenha.getText().toString();

                //Verificando as senhas
                if(senha.equals(confSenha))
                {
                    //Chamando Intent
                    Intent it = new Intent(Tela02.this,
                                           Tela03.class);

                    //Passar os valores para a outra activity
                    it.putExtra("valor1",nome);
                    it.putExtra("valor2",senha);

                    //Chamando a outra activity
                    startActivity(it);

                }
                else
                {
                    Toast.makeText(Tela02.this,
                                   "Senhas não conferem",
                                  Toast.LENGTH_LONG).show();
                }
            }
        });//
    }
}