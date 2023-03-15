package com.usac_delivery.usac_delivery.controladores;
import com.usac_delivery.usac_delivery.modelos.M_Usuario;
import com.usac_delivery.usac_delivery.modelos.M_region;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controlador_Usuario {


    public static ArrayList<M_Usuario>  usuarios = new ArrayList<>();
    public static  ArrayList<M_Usuario> usuarioLogeado = new ArrayList<>();



// get and set
    public ArrayList getArrayPersonas() {
        return usuarios;
    }


    public void setArrayPersonas(M_Usuario usuarios){
        this.usuarios.add(usuarios);

    }

    public void setEditArrayPersonas(M_Usuario usuarios,int id){
        this.usuarios.set(id,usuarios);
    }




    public static ArrayList getArrayUserLogeado(){return usuarioLogeado;}

    public static void setArrayUsuarioLoggeado(M_Usuario usuariologet){
        usuarioLogeado.add(usuariologet);
    }

    public static void setArrayCerrarSesión(){
        usuarioLogeado.remove(0);
    }



    public static M_Usuario obtenerUserID(int codigo){
        Controlador_Usuario user1 = new Controlador_Usuario();
        ArrayList<M_Usuario> visualizador = new ArrayList<>();

        visualizador=user1.getArrayPersonas();

        int id=0;

        int index = 0;
        for (M_Usuario p : visualizador) {
            if(p.getP_id()== codigo ){
                id = index;

            }
            index++;

        }

        return usuarios.get(id);
    }

//metodos
    public static void CrearAdmin(){

        Controlador_Usuario usuario = new Controlador_Usuario();
        ArrayList<M_Usuario> usuarios = new ArrayList<>();




        M_Usuario usuarioAdmon = new M_Usuario();
        usuarioAdmon.setP_id(0);
        usuarioAdmon.setP_correo("ipc1_202200002@ipc1delivery.com");
        usuarioAdmon.setP_password("202200002");
        usuarioAdmon.setP_DPI("nada");
        usuarioAdmon.setP_alias("Administrador Principal");

        usuario.setArrayPersonas(usuarioAdmon);

    }





    public static boolean iniciarSesión(String correo, String password){
        boolean exito = false;
        Controlador_Usuario usuario = new Controlador_Usuario();
        ArrayList<M_Usuario> usuarios = new ArrayList<>();

        usuarios = usuario.getArrayPersonas();

        for (M_Usuario p : usuarios) {
            System.out.println(correo.equals(p.getP_correo()) +" and " +p.getP_correo());
            if(p.getP_correo().equals(correo)&& p.getP_password().equals(password)){
                System.out.println("Inicio Sesión con exito");
                exito = true;

                usuario.setArrayUsuarioLoggeado(p);


                break;
            }

        }
        if(!exito){
            System.out.println("Sus credenciales son incorrectas, si no posee una cuenta puede registrarse");
        }

        return exito;

    }


    public static String crearUsuario(String correo, String password, String nombre, String apellido, String DPI, String fechadeN,String genero, String nacionalidad, String alias, int telefono, int rol, String foto, int idkiosko){
        String exito = "true";
        boolean parecidoCorreo=false;
        boolean parecidoDPI=false;
        int contador = 0;




        if(validadorContraseña(password).equals("true") && validadorCorreo(correo).equals("true") && validadorFecha(fechadeN).equals("true")){


            Controlador_Usuario usuario = new Controlador_Usuario();
            ArrayList<M_Usuario> usuarios = new ArrayList<>();
            M_Usuario usuarioNuevo = new M_Usuario();
            //Contador de id
            usuarios = usuario.getArrayPersonas();


            for (M_Usuario p : usuarios) {
                if(p.getP_correo().equals(correo)){
                    parecidoCorreo=true;
                }
                if(p.getP_DPI().equals(DPI)){
                    parecidoDPI=true;
                }

            }

            if(parecidoCorreo || parecidoDPI){
                exito="";

                if(parecidoCorreo){
                    exito=exito+"El correo ya esta registrado"+System.lineSeparator();
                }
                if(parecidoDPI){
                    exito=exito+"El DPI ya esta registrado";
                }

            }else{
                for (M_Usuario p : usuarios) {
                    contador++;
                }

                usuarioNuevo.setP_id(contador);
                usuarioNuevo.setP_correo(correo);
                usuarioNuevo.setP_password(password);
                usuarioNuevo.setP_nombre(nombre);
                usuarioNuevo.setP_apellido(apellido);
                usuarioNuevo.setP_DPI(DPI);
                usuarioNuevo.setP_fechaDeNacimiento(fechadeN);
                usuarioNuevo.setP_genero(genero);
                usuarioNuevo.setP_nacionalidad(nacionalidad);
                usuarioNuevo.setP_alias(alias);
                usuarioNuevo.setP_telefono(telefono);
                usuarioNuevo.setP_rol(rol);
                usuarioNuevo.setP_idKiosko(idkiosko);
                usuarioNuevo.setFoto(foto);

                usuario.setArrayPersonas(usuarioNuevo);


                usuarios = usuario.getArrayPersonas();
                for (M_Usuario p : usuarios) {
                    System.out.println(p.getP_id()+"--"+p.getP_correo()+"--"+p.getP_password()+"--"+p.getP_idKiosko()+"--"+p.getP_rol());
                }


            }



        }else if(!validadorContraseña(password).equals("true")){

            exito= validadorContraseña(password) +System.lineSeparator()+System.lineSeparator();

            if(!validadorCorreo(correo).equals("true")){
                exito =exito+ validadorCorreo(correo)+System.lineSeparator()+System.lineSeparator();

            }
            if(!validadorFecha(fechadeN).equals("true")){
                exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();
            }


        }else if(!validadorCorreo(correo).equals("true")){
            exito = validadorCorreo(correo)+System.lineSeparator()+System.lineSeparator();

            if(!validadorFecha(fechadeN).equals("true")){
                exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();
            }

        }else{
            exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();


        }


        return exito;
    }

    public static String editarUsuario(String correo, String password, String nombre, String apellido, String DPI, String fechadeN,String genero, String nacionalidad, String alias, int telefono, int rol, String foto, int idkiosko,int id){
        String exito = "true";
        boolean parecidoCorreo=false;
        boolean parecidoDPI=false;
        int contador = 0;




        if(validadorContraseña(password).equals("true") && validadorCorreo(correo).equals("true") && validadorFecha(fechadeN).equals("true")){


            Controlador_Usuario usuario = new Controlador_Usuario();
            ArrayList<M_Usuario> usuarios = new ArrayList<>();
            M_Usuario usuarioNuevo = new M_Usuario();
            //Contador de id
            usuarios = usuario.getArrayPersonas();


            for (M_Usuario p : usuarios) {
                if(p.getP_correo().equals(correo)){
                    if(!usuarios.get(id).getP_correo().equals(correo)){
                        parecidoCorreo=true;

                    }
                }
                if(p.getP_DPI().equals(DPI)){
                    if(!usuarios.get(id).getP_DPI().equals(DPI)){
                        parecidoDPI=true;

                    }
                }

            }

            if(parecidoCorreo || parecidoDPI){
                exito="";

                if(parecidoCorreo){
                    exito=exito+"El correo ya esta registrado"+System.lineSeparator();
                }
                if(parecidoDPI){
                    exito=exito+"El DPI ya esta registrado";
                }

            }else{

                usuarioNuevo.setP_id(id);
                usuarioNuevo.setP_correo(correo);
                usuarioNuevo.setP_password(password);
                usuarioNuevo.setP_nombre(nombre);
                usuarioNuevo.setP_apellido(apellido);
                usuarioNuevo.setP_DPI(DPI);
                usuarioNuevo.setP_fechaDeNacimiento(fechadeN);
                usuarioNuevo.setP_genero(genero);
                usuarioNuevo.setP_nacionalidad(nacionalidad);
                usuarioNuevo.setP_alias(alias);
                usuarioNuevo.setP_telefono(telefono);
                usuarioNuevo.setP_rol(rol);
                usuarioNuevo.setFoto(foto);
                usuarioNuevo.setP_idKiosko(idkiosko);

                usuario.setEditArrayPersonas(usuarioNuevo,id);


                usuarios = usuario.getArrayPersonas();
                for (M_Usuario p : usuarios) {
                    System.out.println(p.getP_id()+"--"+p.getP_correo()+"--"+p.getP_password()+"--"+p.getP_idKiosko()+"--"+p.getP_rol());
                }

                usuario.setArrayCerrarSesión();


            }



        }else if(!validadorContraseña(password).equals("true")){

            exito= validadorContraseña(password) +System.lineSeparator()+System.lineSeparator();

            if(!validadorCorreo(correo).equals("true")){
                exito =exito+ validadorCorreo(correo)+System.lineSeparator()+System.lineSeparator();

            }
            if(!validadorFecha(fechadeN).equals("true")){
                exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();
            }


        }else if(!validadorCorreo(correo).equals("true")){
            exito = validadorCorreo(correo)+System.lineSeparator()+System.lineSeparator();

            if(!validadorFecha(fechadeN).equals("true")){
                exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();
            }

        }else{
            exito = exito+validadorFecha(fechadeN)+System.lineSeparator()+System.lineSeparator();


        }


        return exito;
    }

    //funciones support
    public static String validadorContraseña(String pass){
        String respuesta = "Error en la contraseña: ";
        boolean mayus = false;
        boolean minus = false;
        boolean num = false;
        boolean cEspecial = false;

        //convertir la contraseña a un arreglo de caracteres

        char[] password = pass.toCharArray();

        //recorrer el arreglo
        for (char caracter : password){
            if(Character.isUpperCase(caracter)){
                mayus = true;
            }
            if(Character.isLowerCase(caracter)){
                minus = true;
            }
            if(Character.isDigit(caracter)){
                num = true;
            }
            if(!Character.isLetterOrDigit(caracter)){
                cEspecial = true;
            }


        }

        if(!mayus){
            respuesta = respuesta +System.lineSeparator()+ "No hay Mayúsculas. ";
        }
        if(!minus){
            respuesta = respuesta +System.lineSeparator()+ "No hay minuscula. ";
        }
        if(!num){
            respuesta = respuesta +System.lineSeparator()+ "No hay numero. ";
        }
        if(!cEspecial){
            respuesta = respuesta +System.lineSeparator()+ "No hay Caracter especial. ";
        }

        if (respuesta.equals("Error en la contraseña: ")){
            respuesta = "true";
        }


        return respuesta;
    }

    public static String validadorCorreo(String correo){
        String respuesta = "Error en el correo: "+System.lineSeparator()+ "No es un correo valido";



        int arrobaIndex = correo.indexOf('@');
        int puntoIndex = correo.lastIndexOf('.');
        if(arrobaIndex > 0 && puntoIndex > arrobaIndex  && puntoIndex < correo.length() - 1) {
            respuesta = "true";
        }

        return  respuesta;




    }

    public static String validadorFecha(String fecha){
        String exito = "Error en la fecha:";
        Date fechaHoy= new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        formato.setLenient(false);

        try{

            Date CaptadoreFecha = formato.parse(fecha);
            if(CaptadoreFecha.before(fechaHoy)){
                exito = "true";

            }else{
                exito = exito+System.lineSeparator()+"La fecha debe ser menor a la de hoy";
            }

            return exito    ;

        }catch (ParseException e){
            exito =exito+System.lineSeparator()+"La fecha que ingreso no es valida";
            return  exito;
        }

    }


}
