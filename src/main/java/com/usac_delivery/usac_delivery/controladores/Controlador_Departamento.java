package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_departamento;
import com.usac_delivery.usac_delivery.modelos.M_region;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_Departamento {
    public static ArrayList<M_departamento> departamento = new ArrayList<>();

    public ArrayList getArrayDepartamento() {
        return departamento;
    }


    public void setArrayDepartamento(M_departamento departamento){
        this.departamento.add(departamento);

    }

    public void setEditArrayDepartamento(M_departamento departamento,int id){
        this.departamento.set(id,departamento);
    }



    public static String  CrearDepartamento(String nombre, String codigoRegion ){
        Controlador_Departamento depart = new Controlador_Departamento();
        M_departamento departamentoNuevo = new M_departamento();
        ArrayList<M_departamento> visualizadorDepart = new ArrayList<>();
        visualizadorDepart=depart.getArrayDepartamento();
        String Exito = "true";

        for (M_departamento p : visualizadorDepart) {
                if( p.getD_nombre().equals(nombre)){
                    Exito ="Ya existe un departamento con ese nombre;";

                }


        }
        if(Exito.equals("true")){
            departamentoNuevo.setD_codigo("Depart_"+depart.generarid());
            departamentoNuevo.setD_nombre(nombre);
            departamentoNuevo.setM_codigoRegion(codigoRegion);

            depart.setArrayDepartamento(departamentoNuevo);
        }



        return Exito;


    }


    public static String  EditarDepartamento(String ID,String nombre, String codigoRegion ){
        Controlador_Departamento depart = new Controlador_Departamento();
        M_departamento departamentoNuevo = new M_departamento();
        ArrayList<M_departamento> visualizadorDepart = new ArrayList<>();
        String Exito = "";

        int id=0;

        visualizadorDepart = depart.getArrayDepartamento();
        int index = 0;
        for (M_departamento p : visualizadorDepart) {
            if(p.getD_codigo().equals(ID) ){
                System.out.println(ID);
                Exito = "true";
                id = index;

            }
            index++;

        }
        for (M_departamento p : visualizadorDepart) {
            if(!p.getD_codigo().equals(ID)){
                if( p.getD_nombre().equals(nombre)){
                    Exito ="Ya existe un departamento con ese nombre;";

                }

            }
        }

        if(Exito=="true"){
            departamentoNuevo.setD_codigo(ID);
            departamentoNuevo.setD_nombre(nombre);
            departamentoNuevo.setM_codigoRegion(codigoRegion);

            depart.setEditArrayDepartamento(departamentoNuevo,id);
        } else if (Exito !="Ya existe un departamento con ese nombre;")
        {
            Exito= "No se encontro ningun departamento con ese codigo";

        }


        return Exito;


    }

    public M_departamento obtenerDepartamentoCodigo(String codigo){
        Controlador_Departamento departamento1 = new Controlador_Departamento();
        ArrayList<M_departamento> visualizadorDepartamento = new ArrayList<>();

        visualizadorDepartamento=departamento1.getArrayDepartamento();

        int id=0;

        int index = 0;
        for (M_departamento p : visualizadorDepartamento) {
            if(p.getD_codigo().equals(codigo) ){
                id = index;

            }
            index++;

        }

        return departamento.get(id);
    }


    public int obtenerIDdeDepartamento(String codigo){
        Controlador_Departamento departamento1 = new Controlador_Departamento();
        ArrayList<M_departamento> visualizadorDepartamento = new ArrayList<>();

        visualizadorDepartamento=departamento1.getArrayDepartamento();

        int id=0;

        int index = 0;
        for (M_departamento p : visualizadorDepartamento) {
            if(p.getD_codigo().equals(codigo) ){
                id = index;

            }
            index++;

        }

        return id;
    }

    public String generarid(){
        UUID uuid = UUID.randomUUID();

        String idAleatoria = uuid.toString().substring(0, 5);

        return idAleatoria;
    }

}
