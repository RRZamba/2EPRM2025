package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityTela2 extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome, txtSenha, txtConfSenha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //2)Iniciando os elementos
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtConfSenha = (EditText)  findViewById(R.id.txtConfSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        //3) Evento btnCadastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNome.getText().toString();
                String senha = txtSenha.getText().toString();
                String confSenha = txtConfSenha.getText().toString();

                // Verificando se senha == confSenha
                if(senha.equals(confSenha))
                {
                    //Intent
                    Intent it = new Intent(ActivityTela2.this,
                                            ActivityTela3.class);

                    //Passar os valores para outra tela
                    it.putExtra("Valor1",nome);

                    startActivity(it);
                }
                else
                {
                    Toast.makeText(ActivityTela2.this,
                                  "Senhas não conferem!!! Otário!!!",
                                    Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
