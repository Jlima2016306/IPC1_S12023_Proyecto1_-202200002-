package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_kiosko;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_Kiosko {

    public static ArrayList<M_kiosko> kiosko = new ArrayList<>();

    public ArrayList getArrayKiosko() {
        return kiosko;
    }


    public void setArrayKiosko(M_kiosko kiosko){
        this.kiosko.add(kiosko);

    }


    public void setEditArrayDepartamento(M_kiosko kiosko, int id){
        this.kiosko.set(id,kiosko);
    }



    public static String  Crearkiosko(String nombre, String codigoRegion ){
        Controlador_Kiosko kiosk = new Controlador_Kiosko();
        M_kiosko kioskoNuevo = new M_kiosko();
        ArrayList<M_kiosko> visualizadorKiosko = new ArrayList<>();
        visualizadorKiosko=kiosk.getArrayKiosko();
        String Exito = "true";

        for (M_kiosko p : visualizadorKiosko) {
            if( p.getD_nombre().equals(nombre)){
                Exito ="Ya existe un kiosko con ese nombre;";

            }


        }
        if(Exito.equals("true")){
            kioskoNuevo.setD_codigo("kiosk_"+kiosk.generarid());
            kioskoNuevo.setD_nombre(nombre);
            kioskoNuevo.setM_CodigoRegion(codigoRegion);

            kiosk.setArrayKiosko(kioskoNuevo);
        }



        return Exito;


    }


    public static String  EditarKiosko(String ID,String nombre, String codigoRegion ){


        Controlador_Kiosko kiosk = new Controlador_Kiosko();
        M_kiosko kioskoNuevo = new M_kiosko();
        ArrayList<M_kiosko> visualizadorKiosko = new ArrayList<>();
        visualizadorKiosko=kiosk.getArrayKiosko();

        String Exito = "";

        int id=0;

        int index = 0;
        for (M_kiosko p : visualizadorKiosko) {
            if(p.getD_codigo().equals(ID) ){
                System.out.println(ID);
                Exito = "true";
                id = index;

            }
            index++;

        }
        for (M_kiosko p : visualizadorKiosko) {
            if(!p.getD_codigo().equals(ID)){
                if( p.getD_nombre().equals(nombre)){
                    Exito ="Ya existe un kiosko con ese nombre;";

                }

            }
        }

        if(Exito=="true"){
            kioskoNuevo.setD_codigo(ID);
            kioskoNuevo.setD_nombre(nombre);
            kioskoNuevo.setM_CodigoRegion(codigoRegion);

            kiosk.setEditArrayDepartamento(kioskoNuevo,id);
        } else if (Exito !="Ya existe un kiosko con ese nombre;")
        {
            Exito= "No se encontro ningun kiosko con ese codigo";

        }


        return Exito;


    }



    public String generarid(){
        UUID uuid = UUID.randomUUID();

        String idAleatoria = uuid.toString().substring(0, 5);

        return idAleatoria;
    }



}
