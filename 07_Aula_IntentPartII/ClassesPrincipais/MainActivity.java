package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    EditText txtNome, txtIdade;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) Iniciando os elementos
        txtIdade = (EditText) findViewById(R.id.txtIdade);
        txtNome = (EditText) findViewById(R.id.txtNome);
        btnEntrar = (Button)  findViewById(R.id.btnEntrar);

        // 3) btnEntrar
        btnEntrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando os valores
                String nome = txtNome.getText().toString();
                int idade = Integer.parseInt(txtIdade.getText().toString());

                //Campos vaioz??? Aqui não irmão!!!
                if(nome.isEmpty())
                {
                    Toast.makeText(MainActivity.this,
                                        "Digite o nome, OTÁRIO!!!",
                                     Toast.LENGTH_LONG).show();
                    return;  //Sai do loop
                }
                if(idade == 0)
                {
                    Toast.makeText(MainActivity.this,
                            "Digite a idade!!!",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                //Validando idade
                if(idade >= 18)
                {
                    //Inicia o Intent
                    Intent it = new Intent(MainActivity.this,
                                                Second.class);

                    //Passando valores
                    it.putExtra("ValorNome",nome);
                    it.putExtra("ValorIdade",idade);

                    //Iniciando a outra tela
                    startActivity(it);
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "Você precisa ter mais de 18 anos!!!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}