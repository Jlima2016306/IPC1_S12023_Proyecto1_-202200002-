package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_region;
import com.usac_delivery.usac_delivery.modelos.M_targeta;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_targeta {
    public static ArrayList<M_targeta> targetas = new ArrayList<>();
    public static ArrayList<M_targeta> targetasUsuario = new ArrayList<>();


    public ArrayList getTargetas() {
        return targetas;
    }

    public static ArrayList getTargetasNombre(String idUsuario) {
        M_targeta nuevaTargeta = new M_targeta();
        Controlador_targeta targeta = new Controlador_targeta();
        ArrayList<M_targeta> visualizadorTargeta = new ArrayList<>();

        visualizadorTargeta= targeta.getTargetas();
        String Exito="";
        System.out.println("tramaño"+targetasUsuario.size());

        targetasUsuario.removeAll(targetasUsuario);


        System.out.println("tramaño"+targetasUsuario.size());
        for(M_targeta p:visualizadorTargeta){
            if(p.getIdUsuario().equals(idUsuario)){

                targetasUsuario.add(p);
            }
        }

        System.out.println("tramaño"+visualizadorTargeta.size());

        return targetasUsuario;
    }

    public void setEditArraytARGJETA(M_targeta targeta,int id){
        this.targetas.set(id,targeta);
    }



    public  void setTargetas(M_targeta targetas) {
        Controlador_targeta.targetas.add(targetas)  ;
    }
    public static String  RegistrarTargeta(String numero, String nombre, String Fecha, String idUser){
        M_targeta nuevaTargeta = new M_targeta();
        Controlador_targeta targeta = new Controlador_targeta();
        ArrayList<M_targeta> visualizadorTargeta = new ArrayList<>();

        visualizadorTargeta= targeta.getTargetas();
        String Exito="";

        System.out.println(visualizadorTargeta.isEmpty());

        for(M_targeta p:visualizadorTargeta){
            System.out.println(p.getIdUsuario()+" "+p.getD_nombre()+" "+p.getD_codigo());
            System.out.println("yo soy micky"+idUser);
            if(p.getIdUsuario().equals(idUser)){
                System.out.println("usuario encontrado");
                if(p.getD_nombre().equals(nombre)||p.getD_codigo().equals(numero) ){
                    Exito="Ya registro esa tarjeta";
                }
            }

        }

        if(Exito==""){
            nuevaTargeta.setIdTargeta("Target_"+targeta.generarid());
            nuevaTargeta.setD_nombre(nombre);
            nuevaTargeta.setD_codigo(numero);
            nuevaTargeta.setFecha_de_vencimiento(Fecha);
            nuevaTargeta.setIdUsuario(idUser);

            targeta.setTargetas(nuevaTargeta);

            Exito="true";
        }



        return Exito;


    };


    public static String  EditarTargeta(String numero, String nombre, String Fecha, String idUser,String id) {
        M_targeta nuevaTargeta = new M_targeta();
        Controlador_targeta targeta = new Controlador_targeta();
        ArrayList<M_targeta> visualizadorTargeta = new ArrayList<>();
        ArrayList<M_targeta> visualizadorTargeta2 = new ArrayList<>();

        visualizadorTargeta = targeta.getTargetas();
        visualizadorTargeta2 = targeta.getTargetasNombre(idUser);
        String Exito = "";

        System.out.println(visualizadorTargeta.isEmpty());
        for (M_targeta p : visualizadorTargeta2) {
            if (!p.getIdTargeta().equals(id)) {
                if (p.getD_nombre().equals(nombre) || p.getD_codigo().equals(numero)) {
                    Exito = "Ya existe una tarjeta con esos datos";
                }
            }
        }

        int ID = 0;
        int index = 0;
        if (Exito != "Ya existe una tarjeta con esos datos") {
            for (M_targeta p : visualizadorTargeta) {
                if (p.getIdTargeta().equals(id)) {
                    ID = index;
                    Exito = "true";
                }
                index++;
            }
        }


            if(Exito=="true"){
            nuevaTargeta.setIdTargeta(id);
            nuevaTargeta.setD_nombre(nombre);
            nuevaTargeta.setD_codigo(numero);
            nuevaTargeta.setFecha_de_vencimiento(Fecha);
            nuevaTargeta.setIdUsuario(idUser);

            targeta.setEditArraytARGJETA(nuevaTargeta,ID);

            Exito="true";
        }else if(Exito!="Ya existe una tarjeta con esos datos"){
            Exito="No se encontro la tarjeta";
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
