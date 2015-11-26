package com.example.fran.examen_ejercicio4;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        He conseguido que lea y busque en una lista (es decir en una arrayList. Tambien que lea
        en un archivo, pero no consigo aplicar el filtro al fichero
         */


        //MONTAJE DEL ARCHIVO

        //Lista
        final ArrayList<String> lista = new ArrayList<String>();
        lista.add("anteultimo");
        lista.add("expresidente");
        lista.add("extragrande");
        lista.add("prehistoria");
        lista.add("remormado");
        lista.add("superheroe");
        lista.add("subterraneo");

        final int searchListLength = lista.size();
        final String TAG = "ExamenTest";

        //LECTURA DE LISTA
        String search = "ex";

        for (int i = 0; i < searchListLength; i++) {
            if (lista.get(i).startsWith(search)) {
                String Found = lista.get(i).toString();
                Log.v(TAG, "Encontrado: " + Found);
            }
        }

        //LECTURA DESDE FICHERO

        //Montamos el fichero con la lista de arriba

        final String file_name = "ficheroexamen";
        final String lineSep = System.getProperty("line.separator");

        try {
            FileOutputStream fos = openFileOutput(file_name, Context.MODE_APPEND);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < searchListLength; i++) {
                String textField = new String(lista.get(i).toString() + lineSep);
                dos.writeBytes(textField);
            }
            //Cerramos el FileOutputStream
            fos.close();
            //Cerramos el FileOutputStream
            dos.close();
            //Mostramos un toast para asegurarnos de que ha recibido la orden
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        try {

                    FileInputStream fin = openFileInput(file_name);
                    DataInputStream dis = new DataInputStream(fin);
                    byte[] buff = new byte[1000];
                    dis.read(buff);
                    //Asignamnos el texto en el textView
                    //if (new String(buff).startsWith("ex")){
                        Log.v(TAG, new String(buff));
                    //}
                    //Cerramos el FileInputStream
                    fin.close();
                    //Cerramos el DataInputStream
                    dis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}



