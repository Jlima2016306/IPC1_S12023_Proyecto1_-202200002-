package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_departamento;
import com.usac_delivery.usac_delivery.modelos.M_municipios;
import com.usac_delivery.usac_delivery.modelos.M_targeta;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_Municipio {
    public static ArrayList<M_municipios> municipio = new ArrayList<>();
    public static ArrayList<M_municipios> municipioDepi = new ArrayList<>();

    public ArrayList getArrayMunicipios() {
        return municipio;
    }


    public void setArrayMunicipios(M_municipios municipio){
        this.municipio.add(municipio);

    }

    public static ArrayList getMunicipiosDepartamentoID(String idDep) {
        Controlador_Municipio muni = new Controlador_Municipio();
        ArrayList<M_municipios> visualizadorMuni = new ArrayList<>();

        visualizadorMuni= muni.getArrayMunicipios();

        municipioDepi.removeAll(municipioDepi);


        for(M_municipios p:visualizadorMuni){
            if(p.getM_codigoDepartamento().equals(idDep)){

                municipioDepi.add(p);
            }
        }


        return municipioDepi;
    }


    public void setEditArrayMunicipio(M_municipios municipio, int id){
        this.municipio.set(id,municipio);
    }



    public static String  CrearMunicipio(String nombre, String codigoDep ){
        Controlador_Municipio muni = new Controlador_Municipio();
        M_municipios municipioNuevo = new M_municipios();
        ArrayList<M_municipios> visualizadorMuni = new ArrayList<>();
        visualizadorMuni=muni.getArrayMunicipios();
        String Exito = "true";

        for (M_municipios p : visualizadorMuni) {
            if( p.getD_nombre().equals(nombre)){
                Exito ="Ya existe un municipio con ese nombre;";

            }


        }
        if(Exito.equals("true")){
            municipioNuevo.setD_codigo("Muni_"+muni.generarid());
            municipioNuevo.setD_nombre(nombre);
            municipioNuevo.setM_codigoDepartamento(codigoDep);

            muni.setArrayMunicipios(municipioNuevo);
        }



        return Exito;


    }


    public static String  EditarMunicipio(String ID,String nombre, String codigoDep){
        Controlador_Municipio muni = new Controlador_Municipio();
        M_municipios municipioNuevo = new M_municipios();
        ArrayList<M_municipios> visualizadorMuni = new ArrayList<>();
        visualizadorMuni=muni.getArrayMunicipios();
        String Exito = "true";

        int id=0;

        int index = 0;
        for (M_municipios p : visualizadorMuni) {
            if(p.getD_codigo().equals(ID) ){
                System.out.println(ID);
                Exito = "true";
                id = index;

            }
            index++;

        }
        for (M_municipios p : visualizadorMuni) {
            if(!p.getD_codigo().equals(ID)){
                if( p.getD_nombre().equals(nombre)){
                    Exito ="Ya existe un municipio con ese nombre;";

                }

            }
        }

        if(Exito=="true"){
            municipioNuevo.setD_codigo(ID);
            municipioNuevo.setD_nombre(nombre);
            municipioNuevo.setM_codigoDepartamento(codigoDep);

            muni.setEditArrayMunicipio(municipioNuevo,id);
        } else if (Exito !="Ya existe un municipio con ese nombre;")
        {
            Exito= "No se encontro ningun municipio con ese codigo";

        }


        return Exito;


    }

    //funciones soport

    public String generarid(){
        UUID uuid = UUID.randomUUID();

        // Tomar los primeros 5 caracteres del UUID como un string
        String idAleatoria = uuid.toString().substring(0, 5);

        return idAleatoria;
    }
}
