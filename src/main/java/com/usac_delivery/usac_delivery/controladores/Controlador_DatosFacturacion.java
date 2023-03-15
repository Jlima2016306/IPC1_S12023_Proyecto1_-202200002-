package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_DatosFacturacion;
import com.usac_delivery.usac_delivery.modelos.M_targeta;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_DatosFacturacion {
    public static ArrayList<M_DatosFacturacion> D_facturacion = new ArrayList<>();
    public static ArrayList<M_DatosFacturacion> D_facturacion_User = new ArrayList<>();

    public ArrayList getArrayDFacturacion() {
        return D_facturacion;
    }

    public static ArrayList getArrayDFacturacionUserID(String idUsuario) {
        M_DatosFacturacion nuevoDF = new M_DatosFacturacion();
        Controlador_DatosFacturacion DF = new Controlador_DatosFacturacion();
        ArrayList<M_DatosFacturacion> visualizadorDF = new ArrayList<>();

        visualizadorDF= DF.getArrayDFacturacion();
        String Exito="";

        D_facturacion_User.removeAll(D_facturacion_User);


        for(M_DatosFacturacion p:visualizadorDF){

            if(p.getDF_idUsuario().equals(idUsuario)){

                D_facturacion_User.add(p);
            }
        }

        System.out.println(D_facturacion_User.size()+"piti");


        return D_facturacion_User;
    }

    public void setEditArrayDfacturacion(M_DatosFacturacion DF,int id){
        this.D_facturacion.set(id,DF);
    }


    public  void setD_facturacion(M_DatosFacturacion DF) {
        Controlador_DatosFacturacion.D_facturacion.add(DF)  ;
    }


    public static String  RegistrarDF(String nombre, String direccion,String nit, String idUser){
        M_DatosFacturacion nuevoDF = new M_DatosFacturacion();
        Controlador_DatosFacturacion DF = new Controlador_DatosFacturacion();
        ArrayList<M_DatosFacturacion> visualizadorDF = new ArrayList<>();

        String Exito="";





            nuevoDF.setD_codigo("DF_"+DF.generarid());
            nuevoDF.setD_nombre(nombre);
            nuevoDF.setDF_dirección(direccion);
            nuevoDF.setDF_nit(nit);
            nuevoDF.setDF_idUsuario(idUser);


            DF.setD_facturacion(nuevoDF);

            Exito="true";




        return Exito;


    };


    public static String  EditarDF(String nombre, String direccion,String nit, String idUser,String Codigo){
        M_DatosFacturacion nuevoDF = new M_DatosFacturacion();
        Controlador_DatosFacturacion DF = new Controlador_DatosFacturacion();
        ArrayList<M_DatosFacturacion> visualizadorDF = new ArrayList<>();


        visualizadorDF= DF.getArrayDFacturacionUserID(idUser);
        String Exito="";
        int id =0;
        int index =0;

        Exito= visualizadorDF.isEmpty()+"";
        for(M_DatosFacturacion p:visualizadorDF){
            if(p.getD_codigo().equals(Codigo)){
                Exito = "true";
                id=index;
            }
            index++;
        }

        if (Exito == "true") {
            nuevoDF.setD_codigo("DF_"+DF.generarid());
            nuevoDF.setD_nombre(nombre);
            nuevoDF.setDF_dirección(direccion);
            nuevoDF.setDF_nit(nit);
            nuevoDF.setDF_idUsuario(idUser);


            DF.setEditArrayDfacturacion(nuevoDF,id);

            Exito="true";
        }else{
            Exito="No existe ese DF que intenta editar";
        }





        return Exito;


    };

    public String generarid(){
        UUID uuid = UUID.randomUUID();

        // Tomar los primeros 5 caracteres del UUID como un string
        String idAleatoria = uuid.toString().substring(0, 5);

        return idAleatoria;
    }

}
