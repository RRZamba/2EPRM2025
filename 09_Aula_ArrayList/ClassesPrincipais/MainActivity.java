package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // 1) Atributos
    Spinner spinner;
    TextView textoArtista;
    ImageView imagem;

    String artista;
    int im;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2) 'Iniciando' os elementos
        textoArtista = (TextView) findViewById(R.id.textoArtista);
        spinner = (Spinner) findViewById(R.id.spinner);
        imagem = (ImageView) findViewById(R.id.imagem);

        /*  3) Criando um ArrayList
            Funciona como um array porém
            é uma classe e permite a persistência
            de vários tipos, além de métodos de acesso!!!
         */
        ArrayList<String> listinha = new ArrayList<String>();

        // 4) Adicionando coisas na listinha
        listinha.add("");
        listinha.add("Black Sabbath");
        listinha.add("Helloween");
        listinha.add("Rush");
        listinha.add("Kiss");
        listinha.add("Tralalero");

        // 5) Adaptando o ArrayList<> para colocá-lo no layout
        ArrayAdapter<String> adptador =
                new ArrayAdapter<String>(MainActivity.this,
                               android.R.layout.simple_list_item_1,
                               listinha);

        // 6) Inserindo o ArrayList<> já adaptado no Layout
        spinner.setAdapter(adptador);

        // 7) Evento do Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l)
            {
                String itemSelecionado = listinha.get(posicao);

                if(itemSelecionado.equals(""))
                {
                    artista = "";
                    im = R.drawable.ic_launcher_background;
                }

                if(itemSelecionado.equals("Black Sabbath"))
                {
                    artista = "Black Sabbath é uma banda de heavy metal britânica formada no ano de 1968 em Birmingham pelo guitarrista e principal compositor Tony Iommi, o baixista e principal letrista Geezer Butler, o vocalista Ozzy Osbourne e o baterista Bill Ward.";
                    im = R.drawable.bs;
                }
                if(itemSelecionado.equals("Helloween"))
                {
                    artista = "Helloween é uma influente banda de power metal alemã, fundada em 1984. É composta por Andi Deris, Dani Löble, Sascha Gerstner, Michael Weikath e Markus Grosskopf, sendo esses dois últimos membros fundadores, junto com Kai Hansen e Ingo Schwichtenberg. "  ;
                    im = R.drawable.helo;
                }
                if(itemSelecionado.equals("Rush"))
                {
                    artista = "Rush foi uma banda canadense de rock formada em agosto de 1968 na cidade de Toronto, Ontário. A banda era composta pelo baixista, tecladista e vocalista principal Geddy Lee, pelo guitarrista e backing vocal Alex Lifeson e pelo baterista John Rutsey. "  ;
                    im = R.drawable.rush;
                }
                if(itemSelecionado.equals("Kiss"))
                {
                    artista = "Kiss foi uma banda de hard rock dos Estados Unidos, formada em Nova Iorque em 1973 por Paul Stanley e Gene Simmons. ";
                    im = R.drawable.kiss;
                }
                if(itemSelecionado.equals("Tralalero"))
                {
                    artista = "\"Tralalero Tralala\" é uma expressão que viralizou como meme online, especialmente no contexto do \"Brainrot Italiano\"";
                    im = R.drawable.tralalero;

                }

                textoArtista.setText(artista);


                imagem.setImageResource(im);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });





    }
}