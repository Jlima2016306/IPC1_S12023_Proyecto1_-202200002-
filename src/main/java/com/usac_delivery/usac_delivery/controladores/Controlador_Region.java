package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_Usuario;
import com.usac_delivery.usac_delivery.modelos.M_region;

import java.util.ArrayList;
import java.util.UUID;

public class Controlador_Region {
    public static ArrayList<M_region> region = new ArrayList<>();



    public ArrayList getArrayRegion() {
        return region;
    }


    public void setArrayRegion(M_region region){
        this.region.add(region);

    }

    public void setEditArrayRegion(M_region region,int id){
        this.region.set(id,region);
    }







    public static void  CrearListaDeRegiones(){
        M_region nuevaRegion = new M_region();
        M_region nuevaRegion1 = new M_region();
        M_region nuevaRegion2 = new M_region();
        M_region nuevaRegion3 = new M_region();
        M_region nuevaRegion4 = new M_region();
        M_region nuevaRegion5 = new M_region();

        Controlador_Region region = new Controlador_Region();
        ArrayList<M_region> visualizadorRegion = new ArrayList<>();

        //1
        nuevaRegion.setD_codigo("M"+region.generarid());
        nuevaRegion.setD_nombre("(NT)Metropolitana");
        nuevaRegion.setPrecioNormal(35);
        nuevaRegion.setPrecioEspecial(25);

        region.setArrayRegion(nuevaRegion);


        //2

        nuevaRegion1.setD_codigo("NT"+region.generarid());
        nuevaRegion1.setD_nombre("(NT)Norte");
        nuevaRegion1.setPrecioNormal(68.50);
        nuevaRegion1.setPrecioEspecial(45.55);
        region.setArrayRegion(nuevaRegion1);

        //3

        nuevaRegion2.setD_codigo("NO"+region.generarid());
        nuevaRegion2.setD_nombre("(NO)Nororiente");
        nuevaRegion2.setPrecioNormal(58.68);
        nuevaRegion2.setPrecioEspecial(35.48);
        region.setArrayRegion(nuevaRegion2);
        //4

        nuevaRegion3.setD_codigo("SO"+region.generarid());
        nuevaRegion3.setD_nombre("(SO)Suroriente");
        nuevaRegion3.setPrecioNormal(38.68);
        nuevaRegion3.setPrecioEspecial(32.48);
        region.setArrayRegion(nuevaRegion3);

        //5

        nuevaRegion4.setD_codigo("SOC"+region.generarid());
        nuevaRegion4.setD_nombre("(SOC)Suroccidente");
        nuevaRegion4.setPrecioNormal(34.00);
        nuevaRegion4.setPrecioEspecial(29.00);

        region.setArrayRegion(nuevaRegion4);

        //6
        nuevaRegion5.setD_codigo("NOC"+region.generarid());
        nuevaRegion5.setD_nombre("(NOC)Noroccidente");
        nuevaRegion5.setPrecioNormal(44.50);
        nuevaRegion5.setPrecioEspecial(40.00);

        region.setArrayRegion(nuevaRegion5);


        visualizadorRegion=region.getArrayRegion();

        for (M_region p : visualizadorRegion) {
            System.out.println(p.getD_nombre()+" "+p.getD_codigo());
        }

    }

    public static String  CrearRegion(String codigo, String nombre, double precioS, double precioEspecial){
        M_region nuevaRegion = new M_region();
        Controlador_Region region = new Controlador_Region();
        ArrayList<M_region> visualizadorRegion = new ArrayList<>();

        visualizadorRegion=region.getArrayRegion();
        String Exito="";
        String codigos = "Cod_Reg_"+region.generarid();


        for (M_region p : visualizadorRegion) {
            if(p.getD_codigo().equals(codigos)){
                Exito = Exito+System.lineSeparator()+"Ya existe una region con ese codigo;";

            }
            if(p.getD_nombre().equals(nombre)){
                Exito = Exito+System.lineSeparator()+"Ya existe una region con ese nombre;";

            }
        }

        if (Exito==""){

            nuevaRegion.setD_codigo(codigos);
            nuevaRegion.setD_nombre(nombre);
            nuevaRegion.setPrecioNormal(precioS);
            nuevaRegion.setPrecioEspecial(precioEspecial);

            region.setArrayRegion(nuevaRegion);

            Exito="true";
        }


        return Exito;


    };

    public static String editarRegion(String codigo, String nombre, double precioS, double precioEspecial){
        M_region nuevaRegion = new M_region();
        Controlador_Region region = new Controlador_Region();
        ArrayList<M_region> visualizadorRegion = new ArrayList<>();

        visualizadorRegion=region.getArrayRegion();
        String Exito="";
        int id=0;

        int index = 0;
        for (M_region p : visualizadorRegion) {
            if(p.getD_codigo().equals(codigo) ){
                Exito = "true";
                id = index;

            }
            index++;

        }

        for (M_region p : visualizadorRegion) {
            if(p.getD_nombre().equals(nombre)){
                Exito ="Ya existe una region con ese nombre;";

            }
        }

        if (Exito=="true"){
            nuevaRegion.setD_codigo(codigo);
            nuevaRegion.setD_nombre(nombre);
            nuevaRegion.setPrecioNormal(precioS);
            nuevaRegion.setPrecioEspecial(precioEspecial);

            region.setEditArrayRegion(nuevaRegion,id);

            Exito="true";

        } else if (Exito !="Ya existe una region con ese nombre;")
        {
            Exito= "No se encontro ninguna región con ese codigo";

        }

        return Exito;
    }


    public static M_region obtenerRegionCodigo(String codigo){
        Controlador_Region region1 = new Controlador_Region();
        ArrayList<M_region> visualizadorRegion = new ArrayList<>();

        visualizadorRegion=region1.getArrayRegion();

        int id=0;

        int index = 0;
        for (M_region p : visualizadorRegion) {
            if(p.getD_codigo().equals(codigo) ){
                id = index;

            }
            index++;

        }

        return region.get(id);
    }


    public int obtenerIDdeRegion(String codigo){
        Controlador_Region region1 = new Controlador_Region();
        ArrayList<M_region> visualizadorRegion = new ArrayList<>();

        visualizadorRegion=region1.getArrayRegion();

        int id=0;

        int index = 0;
        for (M_region p : visualizadorRegion) {
            if(p.getD_codigo().equals(codigo) ){
                id = index;

            }
            index++;

        }

        return id;
    }

    //funciones soport

    public String generarid(){
        UUID uuid = UUID.randomUUID();

        // Tomar los primeros 5 caracteres del UUID como un string
        String idAleatoria = uuid.toString().substring(0, 5);

        return idAleatoria;
    }
}

