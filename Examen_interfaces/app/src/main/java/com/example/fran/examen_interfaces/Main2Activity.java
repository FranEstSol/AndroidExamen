package com.example.fran.examen_interfaces;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //DATOS
        //Creamos la Array de contactos
        String[] contactos = new String[]{"Invitado","Organizador","Revisor","Autor",};
        //Transformamos la Array en un ArrayList tipo lista
        ArrayList<String> listaContactos = new ArrayList<String>(Arrays.asList(contactos));
        //Creamos un adapter de strings al cual le metemos el contexto (this), un textView desde la clase R y la propia lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaContactos);

        //INTERFAZ
        //creacion del listView y le damos el adapter.
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        //Esto permite que se pueda hacer longClick en los elementos
        registerForContextMenu(listView);

    }

  /*  list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            //Message
            Toast.makeText(getBaseContext(), "FILE: " + itemsFiles.get(position).getName(), Toast.LENGTH_LONG).show();
            return false;
        }
    });
*/


}
