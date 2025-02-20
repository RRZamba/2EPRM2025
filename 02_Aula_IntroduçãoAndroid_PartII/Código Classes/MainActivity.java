package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1) Atributos
    EditText nome, funcao, salario;
    Button salvarLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Linkando os elementos com a programaçao
        nome = (EditText) findViewById(R.id.Nome);
        funcao = (EditText) findViewById(R.id.Funcao);
        salario= (EditText) findViewById(R.id.Salario);
        salvarLimpar = (Button) findViewById(R.id.SalvarLimpar);


        //Evento 1 do botao
        salvarLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                 //Recuperando valores
                String vNome = nome.getText().toString();
                String vFuncao = funcao.getText().toString();
                double vSalario = Double.parseDouble(
                                salario.getText().toString());

                //Mensagem
                String mens = "Nome: " + nome + "\n" +
                              "Função: " + nome + "\n" +
                              "Salário: " + nome + "\n";

                //Mostrando
                Toast.makeText(MainActivity.this,
                                mens,
                                Toast.LENGTH_LONG);


            }
        });//botao 1


        //Evento 2 do botão
        salvarLimpar.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                nome.setText("");
                funcao.setText("");
                salario.setText("");

                Toast.makeText(MainActivity.this,
                        "Campos Limpos!",
                        Toast.LENGTH_LONG);

                return true;
            }
        });

    }
}