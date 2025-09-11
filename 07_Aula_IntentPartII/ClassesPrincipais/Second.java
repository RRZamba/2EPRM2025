package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity
{
    TextView lblTitulo2;
    Button btnNavegador,btnLigar,btnCompartilhar,btnCamera,
           btnGaleria,btnMaps,btnEmail,btnCalendario, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Iniciando os elementos
        lblTitulo2 = (TextView) findViewById(R.id.lblTitulo2);
        btnNavegador = (Button) findViewById(R.id.btnNavegador);
        btnLigar = (Button) findViewById(R.id.btnLigar);
        btnCompartilhar = (Button) findViewById(R.id.btnCompartilhar);
        btnCamera = (Button) findViewById(R.id.btnCamera);
        btnGaleria = (Button) findViewById(R.id.btnGaleria);
        btnMaps = (Button) findViewById(R.id.btnMaps);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnCalendario = (Button) findViewById(R.id.btnCalendario);
        btnFechar = (Button) findViewById(R.id.btnFechar);

        //Recebendo valores da tela anterior (MainActivity) pelo Intent
        String nome = getIntent().getStringExtra("ValorNome");
        int idade = getIntent().getIntExtra("ValorIdade",0);

        //Mudando o titulo
        lblTitulo2.setText("Bem-vindo, " + nome + "de "
                               + idade + "anos!!!");

        // ----- Intents Implícitos -------//
        btnNavegador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Pegando o site
                Uri site = Uri.parse("https://google.com");
                startActivity(new Intent(Intent.ACTION_VIEW,site));
            }
        });


        btnLigar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri numeroTel = Uri.parse("tel:11979801104");
                startActivity(new Intent(Intent.ACTION_DIAL,numeroTel));
            }
        });

        btnCompartilhar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT, "Meu textinho compartilhado!");
                startActivity(it.createChooser(it,"Compartilhar via"));
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri local = Uri.parse(
                 "geo:0,0?q=ETEC Lauro Gomes, São Bernardo do Campo");
                Intent it = new Intent(Intent.ACTION_VIEW,local);
                it.setPackage("com.google.android.app.maps");
                startActivity(it);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(Intent.ACTION_SENDTO);
                it.setData(Uri.parse("mailto:rafael@gmail.com"));
                it.putExtra(Intent.EXTRA_SUBJECT,"Assunto do email");
                it.putExtra(Intent.EXTRA_TEXT,"Corpo do meu email");
                startActivity(it);

            }
        });

        btnCalendario.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent it = new Intent(Intent.ACTION_INSERT);
                it.setData(CalendarContract.Events.CONTENT_URI);
                it.putExtra(CalendarContract.Events.TITLE,"Reunião!!!");
                it.putExtra(CalendarContract.Events.EVENT_LOCATION,"SBC");
                it.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,System.currentTimeMillis());
                it.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                                      System.currentTimeMillis()+720000);
                startActivity(it);

            }
        });


        btnFechar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });




    }
}