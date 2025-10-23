package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //1) Atributos
    EditText txtNome,txtEnd,txtCpf,txtCargo;
    Button btnCad;
    ListView listinha;

    //ArrayList<>
    ArrayList<Usuario> listaLogica = new ArrayList<Usuario>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2) Iniciando elementos da tela
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEnd = (EditText) findViewById(R.id.txtEnd);
        txtCpf =(EditText) findViewById(R.id.txtCpf);
        txtCargo = (EditText) findViewById(R.id.txtCargo);
        btnCad = (Button) findViewById(R.id.btnCad);
        listinha = (ListView) findViewById(R.id.listinha);

        // 3) Evento do Button
        btnCad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Recuperando valores
                String end = txtEnd.getText().toString();
                String nome = txtNome.getText().toString();
                String cpf = txtCpf.getText().toString();
                String cargo = txtCargo.getText().toString();

                //Instanciando a classe Usuario
                Usuario user = new Usuario(nome,cpf,end,cargo);

                /*
                    Exemplo do ArrayList com a classe Usuario
                    |  Nome   | End |   CPF    | Cargo |
                   0| Bruna   | SBC | 787878   | Chefe |
                   1| Douglas | SBC | 555555   | Caixa |
                   2| Camila  | SBC | 888888   | Dona  |

                 */

                //Inserindo o objeto user no ArrayList
                listaLogica.add(user);

                //Adaptando a listaLogica
                ArrayAdapter<Usuario> adaptadorLista =
                          new ArrayAdapter<>(MainActivity.this,
                                   android.R.layout.simple_list_item_1,
                                   listaLogica);

                //Inserindo a lista já adaptada no layout
                listinha.setAdapter(adaptadorLista);

                //Limpando os campos
                txtEnd.setText("");
                txtNome.setText("");
                txtCargo.setText("");
                txtCpf.setText("");
            }
        });

        // 4) Evento da listinha
        listinha.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                //Recuperando os valores do ArrayList
                String nome = listaLogica.get(position).getNome();
                String cpf = listaLogica.get(position).getCpf();
                String mens = "Nome: " + nome + "\n cpf: " + cpf
                                + "Parabéns!!! Você é um OTRÁRIO!!!";


                //Mostrando que funcionou
                Toast.makeText(MainActivity.this,
                                mens,
                                Toast.LENGTH_LONG).show();
            }
        });
    }
}

   /*       !!!!FAZER!!!!
       Criar um evento de clique longo que ao ser
       chamado, exclua o item clicado!!!!!
    */


