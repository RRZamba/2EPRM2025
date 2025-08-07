package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome , txtFuncao , txtSalario;
    Button btnSalvarApagar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) 'Linkando' os atributos com o layout
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtFuncao = (EditText) findViewById(R.id.txtFuncao);
        txtSalario = (EditText) findViewById(R.id.txtSalario);
        btnSalvarApagar = (Button)  findViewById(R.id.btnSalvarApagar);

        // 3) Evento do btnSalvarApagar
        btnSalvarApagar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando valores!!!   :)
                String nome = txtNome.getText().toString();
                String funcao = txtFuncao.getText().toString();
                double salario = Double.parseDouble(txtSalario
                                       .getText().toString());

                // Montando uma mensagem
                String mens = "Nome: " + nome
                            + "\n Função: " + funcao
                            + "\n Salário:" + salario;

                // Mostrando uma notificação
                Toast.makeText(MainActivity.this,
                                mens,Toast.LENGTH_LONG).show();
            }
        });//

        // 4) evento do botao (clique longo)
        btnSalvarApagar.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                //Limpar os campos
                txtNome.setText("");
                txtFuncao.setText("");
                txtSalario.setText("");
                return true;
            }
        });//
    }
}