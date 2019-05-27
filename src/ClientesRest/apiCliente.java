/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientesRest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jp
 */
public class apiCliente {

    public static apiCliente instance;

    public static apiCliente getInstance() {
        if (instance == null) {
            instance = new apiCliente();
        }
        return instance;
    }

    public List<String> getRazas() {
        List<String> listaRazas = new ArrayList<>();
        try {
            URL url = new URL("https://dog.ceo/api/breeds/list/all"); //creo la url
            HttpURLConnection conUrl = (HttpURLConnection) url.openConnection();//creo la conexion
            conUrl.setRequestMethod("GET");//hago una peticion al metodo get
            conUrl.setRequestProperty("Content-type", "application/json");//defino la respuesta y el tipo
            conUrl.setRequestProperty("Accept", "application/json");//defino que acepte json

            if (conUrl.getResponseCode() != 200) {//si falla la peticion
                throw new RuntimeException("Fallo : HTTP Codigo Error :" + conUrl.getResponseCode());

            }
//si no falla
            InputStreamReader in = new InputStreamReader((InputStream) conUrl.getInputStream()); //recibo lo que devuelve con un inpustreamreader
            BufferedReader br = new BufferedReader(in);//otra opcion pireee
            Reader rd = new BufferedReader(in);//creo un reader con lo que vino 
            GsonBuilder gson = new GsonBuilder();//el builder de json
            JsonObject jsonRazas = gson.create().fromJson(rd, JsonObject.class);//creo un objeto json con todo los datos que vinieron
            listaRazas.addAll((ArrayList<String>)getDecerializar(jsonRazas));//deserializo el json en un arraylist de String
            /*
            String raza;

            while ((raza = br.readLine()) != null) {
                System.err.println(raza);
            }*/
            conUrl.disconnect();//desconecto la conexion

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
     return listaRazas;
    }

    public List<String> getRazas2() {
        List<String> listraza = null;
        try {
            Client client = ClientBuilder.newClient();//creo el cliente 
            WebTarget target = client.target("https://dog.ceo/api/breeds/list/all");//creoo el WebTarget con la url de la api
            JsonObject jsoo = new JsonObject();
            String razas = target.request(MediaType.APPLICATION_JSON).get(String.class);//peticion get al WebTarget, la clase String porque retorna una cadena json

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return listraza;
    }

    private List getDecerializar(JsonObject fromJson) {
        List<String> razas = new ArrayList<>();
        Set<Map.Entry<String, JsonElement>> entrySet = fromJson.entrySet();//creo el primer set del contenido del json
        Iterator<Map.Entry<String, JsonElement>> iterator = entrySet.iterator();//creo el set de claves iteradoras
        ArrayList<String> arrJSEle = new ArrayList<>();//arreglo que contiene las claves de los elementos
        while (iterator.hasNext()) {//recorro el set de claves
            Map.Entry<String, JsonElement> next = iterator.next(); 
            arrJSEle.add(next.getKey());//obtengo la clave y la cargo
        }
        Set<Map.Entry<String, JsonElement>> entrySet1 = fromJson.getAsJsonObject((String) arrJSEle.get(1)).entrySet();//obtengo el arreglo de objetos que tiene adentro

        Iterator<Map.Entry<String, JsonElement>> iterator1 = entrySet1.iterator(); //el iterador de objetos es un diccionario con claves
        //GsonBuilder gsBuild = new GsonBuilder().
        while (iterator1.hasNext()) {
            String key = (String) iterator1.next().getKey();//obtengo la key o la raza
            if (fromJson.getAsJsonObject((String) arrJSEle.get(1)).get(key).getAsJsonArray().size() > 0) {//pregunto si ese objeto es un arreglo 
                razas.addAll((ArrayList<String>)esArreglo(fromJson.getAsJsonObject((String) arrJSEle.get(1)).get(key), key));//si es un arreglo deserializo el arreglo
            }else{razas.add(key);}//si no agrego la raza o key a la lista
            

        }
        return razas;
    }

    private List esArreglo(JsonElement value, String key) {
        List<String> razasNombre = new ArrayList<>();

        try {
            if (value.isJsonArray()) {

                JsonArray asJsonArray = value.getAsJsonArray();
                for (JsonElement ele : asJsonArray) {
                    razasNombre.add(key + " " + (String) ele.getAsString());

                }

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return razasNombre;
    }

}
