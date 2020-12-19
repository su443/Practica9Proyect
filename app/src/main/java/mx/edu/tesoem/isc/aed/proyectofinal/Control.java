package mx.edu.tesoem.isc.aed.proyectofinal;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Control {

    private final String Archivo="Final.tesoem";
    List<Datos> datos = new ArrayList<>();

    public boolean Existencia(Context context){
        String[] archivos = context.fileList();
        for (String archivo : archivos)
            if (archivo.equals(Archivo))
                return true;
            return false;
    }

    public boolean Escritura(Context context,List<Datos> datos){
        try{
            OutputStreamWriter archivo = new OutputStreamWriter(context.openFileOutput(Archivo, Activity.MODE_PRIVATE));
            for (Datos dato : datos)
                archivo.write(Json(dato)+"\n");
            archivo.flush();
            archivo.close();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean Lectura(Context context){
        try{
            InputStreamReader archivo = new InputStreamReader(context.openFileInput(Archivo));
            BufferedReader br = new BufferedReader(archivo);
            String  linea ="";
            while((linea = br.readLine()) != null)
                datos.add(Clase(linea));
            br.close();
            archivo.close();
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    public List<Datos> getDatos(){
        return datos;
    }

    private String Json(Datos dato){
        Gson gson = new Gson();
        return gson.toJson(dato);
    }

    private Datos Clase(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Datos.class);
    }
}
