package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    // 1) Atributos
    EditText valor, desc_aum;
    Button btnDesconto, btnAumento;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // 2) 'Linkando' o layout com a programação  S2!!!
       valor = (EditText) findViewById(R.id.ValorProduto);
       desc_aum = (EditText) findViewById(R.id.DescontoAumento);
       btnAumento = (Button) findViewById(R.id.btnAumento);
       btnDesconto = (Button) findViewById(R.id.btnDesconto);

       // 3) Calculando desconto
       btnDesconto.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               if(valor.getText().toString().isEmpty()  || desc_aum.getText().toString().isEmpty())
               {
                   //Verificando campos vazios
                   Toast.makeText(MainActivity.this,
                                  "Verificar campos vazios!!!",
                                  Toast.LENGTH_LONG).show();
               }
               else
               {


                   //Recebendo os valores
                   double varValor = Double.parseDouble(valor.getText().toString());
                   double varDesc_Aum = Double.parseDouble(desc_aum.getText().toString());


                   // Calcular e mostrar!!!!
                   double result = varValor - (varValor * (varDesc_Aum / 100));

                   // Mostrando o valor!!!!
                   Toast.makeText(MainActivity.this,
                           "Valor com desconto: " + result,
                           Toast.LENGTH_LONG).show();
               }
           }});//


            //Calculando Aumento
            btnAumento.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(valor.getText().toString().isEmpty()  || desc_aum.getText().toString().isEmpty())
                    {
                        //Verificando campos vazios
                        Toast.makeText(MainActivity.this,
                                "Verificar campos vazios!!!",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {


                        //Recebendo os valores
                        double varValor = Double.parseDouble(valor.getText().toString());
                        double varDesc_Aum = Double.parseDouble(desc_aum.getText().toString());

                        // Calcular aumento!!!!
                        double result = varValor + (varValor * (varDesc_Aum / 100));

                        //Mostrando o valor
                        Toast.makeText(MainActivity.this,
                                "Valor com aumento:" + result,
                                Toast.LENGTH_LONG).show();
                    }
                }
            });//


            // Calculando apenas o desconto
            btnDesconto.setOnLongClickListener(new View.OnLongClickListener()
            {

                @Override
                public boolean onLongClick(View view)
                {
                    if(valor.getText().toString().isEmpty()  || desc_aum.getText().toString().isEmpty())
                    {
                        //Verificando campos vazios
                        Toast.makeText(MainActivity.this,
                                "Verificar campos vazios!!!",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {

                        //Recuperandos valores
                        double varValor = Double.parseDouble(valor.getText().toString());
                        double varDesc_Aum = Double.parseDouble(desc_aum.getText().toString());

                        //Calculando
                        double result = varValor * (varDesc_Aum / 100);

                        // Mostrando
                        Toast.makeText(MainActivity.this,
                                "Desconto Aplicado: " + result,
                                Toast.LENGTH_LONG).show();
                    }

                    return true;
                }
            });//

            btnAumento.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view)
                {
                    if(valor.getText().toString().isEmpty()  || desc_aum.getText().toString().isEmpty())
                    {
                        //Verificando campos vazios
                        Toast.makeText(MainActivity.this,
                                "Verificar campos vazios!!!",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        //Recuperando os valores
                        double varValor = Double.parseDouble(valor.getText().toString());
                        double varDesc_Aum = Double.parseDouble(desc_aum.getText().toString());

                        double reusul = varValor * (varDesc_Aum / 100);

                        Toast.makeText(MainActivity.this,
                                "Aumento Aplicado: " + reusul,
                                Toast.LENGTH_LONG).show();
                    }

                    return true;
                }
            });//
    }
}