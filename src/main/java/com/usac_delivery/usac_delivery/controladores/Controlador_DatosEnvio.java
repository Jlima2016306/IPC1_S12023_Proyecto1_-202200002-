package com.usac_delivery.usac_delivery.controladores;

import com.usac_delivery.usac_delivery.modelos.M_DatosEnvio;
import com.usac_delivery.usac_delivery.modelos.M_reporteR;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Controlador_DatosEnvio {
    public static ArrayList<M_DatosEnvio> envi = new ArrayList<>();
    public static ArrayList<M_DatosEnvio> Misenvi = new ArrayList<>();

    public static  ArrayList<M_DatosEnvio> enviActual = new ArrayList<>();
    //dadores
    public ArrayList getEnvi(){
        return envi;
    }

    public ArrayList getEnviActual(){
        return  enviActual;
    }

    public ArrayList getMisenvios(String iDUser){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();

        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();

        Misenvi.removeAll(Misenvi);

        for(M_DatosEnvio p:Visualizador){
            if(p.getIdUsuario().equals(iDUser)){
                Misenvi.add(p);
            }
        }


        return  Misenvi;
    }

    //obtenedores
    public void setEnvi(M_DatosEnvio envis){



        envi.add(envis);

    }

    public void setEnviActual(M_DatosEnvio enviU){
        enviActual.add(enviU);
    }


    public void setAdiosEnviActual(){
        enviActual.remove(0);
    }


    //funciones crear

    public String RegistrarEnvio(
            String OrigenDepName,
            String OrigenMunName,
            String OrigenDirecion,
            String OrigenIDRegion,
            String DestinoDepName,
            String DestinoMunName,
            String DestinoDirecion,
            String DestinoIDRegion,
            int NumeroDEPAquetes,
            String peso,
            String tipoDEPAGO,
            String idDatosFac,
            String idUser,
            String DestinatarioName,
            String Nit,
            String destinatarioDIc,
            String fechaEnvio,
            Double total


    ){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();
        String codigo ="IPC1E"+enviControl.generarid();

        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();
        if(!Visualizador.isEmpty()){
            while (Exito != "true"){
                codigo = "IPC1E"+enviControl.generarid();

                for(M_DatosEnvio p:Visualizador){
                    if(!p.getCodigoGuia().equals(codigo)){
                        Exito ="true";
                    }else{
                        Exito = "flase";
                    }
                }

            }


        }


        String[] Origen = new String[4];
        String[] Destino = new String[4];




        Origen[0] = OrigenDepName;
        Origen[1] = OrigenMunName;
        Origen[2] = OrigenDirecion;
        Origen[3] = OrigenIDRegion;

        Destino[0] = DestinoDepName;
        Destino[1] = DestinoMunName;
        Destino[2] = DestinoDirecion;
        Destino[3] = DestinoIDRegion;

        enviNuevo.setCodigoGuia(codigo);
        enviNuevo.setOrigen(Origen);
        enviNuevo.setDestino(Destino);
        enviNuevo.setNumeroDePaquetes(NumeroDEPAquetes);
        enviNuevo.setPeso(peso);
        enviNuevo.setTipoDePago(tipoDEPAGO);
        enviNuevo.setIdDatosFacturación(idDatosFac);
        enviNuevo.setIdUsuario(idUser);
        enviNuevo.setDestinatarioName(DestinatarioName);
        enviNuevo.setNIT(Nit);
        enviNuevo.setDestinatario(destinatarioDIc);
        enviNuevo.setFechaEnvio(fechaEnvio);
        enviNuevo.setTotal(total);

        enviControl.setEnvi(enviNuevo);
        enviControl.setEnviActual(enviNuevo);







        return Exito;

    }


    public static void Crearhtml(){
        M_DatosEnvio envioAc = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();

        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnviActual();
        envioAc = Visualizador.get(0);

        int codigoNub;
        String Origen;
        String Destino;

        Origen = envioAc.getOrigen()[0]+","+envioAc.getOrigen()[1]+","+envioAc.getOrigen()[2];
        Destino = envioAc.getDestino()[0]+","+envioAc.getDestino()[1]+","+envioAc.getDestino()[2];
        codigoNub= contador(envioAc.getIdUsuario(),envioAc.getCodigoGuia())+1;

        try {
            String rutaDescargas = System.getProperty("user.home") + "\\Downloads\\Factura"+ Visualizador.get(0).getFechaEnvio()+"_"+Visualizador.get(0).getDestinatarioName()+".html";
            FileWriter archivoHTML = new FileWriter(rutaDescargas);

            archivoHTML.write("<html>\n");
            archivoHTML.write("<head>\n");
            archivoHTML.write("<title> Factura</title>\n");
            archivoHTML.write("</head>\n");
            archivoHTML.write("<body>\n");
            archivoHTML.write("<h1>Factura</h1>\n");
            archivoHTML.write("<p>No."+codigoNub+"</p>\n");
            archivoHTML.write("<p>Codigo:"+envioAc.getCodigoGuia()+"</p>\n");
            archivoHTML.write("<p>Origen:"+Origen+"</p>\n");
            archivoHTML.write("<p>Destino:"+Destino+"</p>\n");
            archivoHTML.write("<p>Nit:"+envioAc.getNIT()+"</p>\n");
            archivoHTML.write("<p>Tipo de pago:"+envioAc.getTipoDePago()+"</p>\n");
            archivoHTML.write("<p>Tamaño del paquete:"+envioAc.getPeso()+"</p>\n");

            archivoHTML.write("<p>-----------------------------------------------</p>\n");
            archivoHTML.write("\n" +
                    "<table BORDER CELLPADDING=10 CELLSPACING=0 class=\"default\">\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td> <b>Numero de Paquetes </b></td>\n" +
                    "\n" +
                    "    <td>  <b>Tamaño de Paquete </b></td>\n" +
                    "\n" +
                    "    <td> <b>Total </b></td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "  <tr>\n" +
                    "\n" +
                    "    <td>"+envioAc.getNumeroDePaquetes()+"</td>\n" +
                    "\n" +
                    "    <td>"+envioAc.getPeso()+"</td>\n" +
                    "\n" +
                    "    <td>"+"Q"+envioAc.getTotal()+"</td>\n" +
                    "\n" +
                    "  </tr>\n" +
                    "\n" +
                    "</table>");


            archivoHTML.write("</body>\n");
            archivoHTML.write("</html>\n");

            archivoHTML.close();
            System.out.println("Archivo HTML creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo HTML.");
            e.printStackTrace();
        }
    }


    public static void CrearhtmlGuia(){
        M_DatosEnvio envioAc = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();

        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnviActual();
        envioAc = Visualizador.get(0);

        int codigoNub;
        String Origen;
        String Destino;

        Origen = envioAc.getOrigen()[0]+","+envioAc.getOrigen()[1]+","+envioAc.getOrigen()[2];
        Destino = envioAc.getDestino()[0]+","+envioAc.getDestino()[1]+","+envioAc.getDestino()[2];
        codigoNub= contador(envioAc.getIdUsuario(),envioAc.getCodigoGuia())+1;

        try {
            String rutaDescargas = System.getProperty("user.home") + "\\Downloads\\Guia"+ Visualizador.get(0).getFechaEnvio()+"_"+Visualizador.get(0).getDestinatarioName()+".html";
            FileWriter archivoHTML = new FileWriter(rutaDescargas);

            archivoHTML.write("<html>\n");
            archivoHTML.write("<head>\n");
            archivoHTML.write("<title> Guia</title>\n");
            archivoHTML.write("</head>\n");
            archivoHTML.write("<body>\n");
            archivoHTML.write("<h1>Guia</h1>\n");
            archivoHTML.write("<p>Origen:"+Origen+"</p>\n");
            archivoHTML.write("<p>Destino:"+Destino+"</p>\n");
            archivoHTML.write("<p>Tipo de pago:"+envioAc.getTipoDePago()+"</p>\n");
            archivoHTML.write("<p>Tamaño del paquete:"+envioAc.getPeso()+"</p>\n");

            archivoHTML.write("<p>-----------------------------------------------</p>\n");
            archivoHTML.write("<br>\n");

            archivoHTML.write("<p>Codigo de paqueta:"+envioAc.getCodigoGuia()+"</p>\n");

            archivoHTML.write("<img src=\"barra.png\" height=\"100\" >\n");
            archivoHTML.write("<p>Fecha de envio:"+envioAc.getFechaEnvio()+"   Numero de paquetes:"+envioAc.getNumeroDePaquetes() +"</p>\n");

            archivoHTML.write("<h3>total:"+"Q"+envioAc.getTotal()+"</h3>\n");


            archivoHTML.write("</body>\n");
            archivoHTML.write("</html>\n");

            archivoHTML.close();
            System.out.println("Archivo HTML creado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo HTML.");
            e.printStackTrace();
        }
    }


    public static String RegionesMoreEnvios(){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();
        Controlador_Region regiControl = new Controlador_Region();


        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();


        ArrayList<M_reporteR> Regiones1 = new ArrayList<>();

        for(M_DatosEnvio p:Visualizador){
            boolean nombreEncontrado = false;
           for(M_reporteR m: Regiones1){
               if(m.getNombre().equals(p.getDestino()[3])){
                   m.setContador(m.getContador()+1);
                   nombreEncontrado = true;
                   break;
               }


           }

            if(!nombreEncontrado){
                M_reporteR nuevoItem = new M_reporteR();
                nuevoItem.setNombre(p.getDestino()[3]);
                nuevoItem.setContador(1);
                Regiones1.add(nuevoItem);
            }





        }

        for (M_reporteR item : Regiones1) {
            item.setNombre(regiControl.obtenerRegionCodigo(item.getNombre()).getD_nombre());
        }




        // Ordenar los elementos del ArrayList por su contador
        M_reporteR[] arregloR = Regiones1.toArray(new M_reporteR[0]);
        int n = arregloR.length;
        M_reporteR temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arregloR[j].getContador() < arregloR[j + 1].getContador()) {
                    temp = arregloR[j];
                    arregloR[j] = arregloR[j + 1];
                    arregloR[j + 1] = temp;
                }
            }
        }
        Regiones1.clear();
        for (M_reporteR item : arregloR) {
            Regiones1.add(item);
        }

        int intex=0;
        int id=0;
        for (M_reporteR item : Regiones1) {
            id=intex+1;
            Exito = Exito+System.lineSeparator()+ (id+". "+ item.getNombre() + " tiene " + item.getContador() + " envios");
            intex++;
        }

        if(Exito==""){
            Exito="Sin envios";
        }
        return  Exito;



    }

    public static String UsuariosConmásenvios(){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();
        Controlador_Usuario userControl = new Controlador_Usuario();


        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();


        ArrayList<M_reporteR> Usuarios1 = new ArrayList<>();

        for(M_DatosEnvio p:Visualizador){
            boolean nombreEncontrado = false;
            for(M_reporteR m: Usuarios1){
                if(m.getNombre().equals(p.getIdUsuario())){
                    m.setContador(m.getContador()+p.getNumeroDePaquetes());
                    nombreEncontrado = true;
                    break;
                }


            }

            if(!nombreEncontrado){
                M_reporteR nuevoItem = new M_reporteR();
                nuevoItem.setNombre(p.getIdUsuario());
                nuevoItem.setContador(p.getNumeroDePaquetes());
                Usuarios1.add(nuevoItem);
            }





        }

        for (M_reporteR item : Usuarios1) {
            item.setNombre(userControl.obtenerUserID(Integer.parseInt(item.getNombre()) ).getP_correo());
        }




        // Ordenar los elementos del ArrayList por su contador
        M_reporteR[] arregloR = Usuarios1.toArray(new M_reporteR[0]);
        int n = arregloR.length;
        M_reporteR temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arregloR[j].getContador() < arregloR[j + 1].getContador()) {
                    temp = arregloR[j];
                    arregloR[j] = arregloR[j + 1];
                    arregloR[j + 1] = temp;
                }
            }
        }
        Usuarios1.clear();
        for (M_reporteR item : arregloR) {
            Usuarios1.add(item);
        }

        int intex=0;
        int id=0;
        for (M_reporteR item : Usuarios1) {
            id=intex+1;
            Exito = Exito+System.lineSeparator()+ (id+". "+ item.getNombre() + " tiene " + item.getContador() + " paquetes enviados");
            intex++;
        }

        if(Exito==""){
            Exito="Sin envios";
        }
        return  Exito;



    }



    public static String TotalDineroEnvios(){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();
        Controlador_Usuario userControl = new Controlador_Usuario();


        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();
        Double totales = 0.0;

        for(M_DatosEnvio p:Visualizador){
            totales= totales+p.getTotal();
        }

        Exito = "Total dinero recaudado: Q"+totales+"";

        return Exito;


    }


    public static String TotalPaquetesEnvios(){
        String Exito = "";
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();
        Controlador_Usuario userControl = new Controlador_Usuario();


        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getEnvi();
        int totales = 0;

        for(M_DatosEnvio p:Visualizador){
            totales= totales+p.getNumeroDePaquetes();
        }

        Exito = "Total paquetes enviados:"+totales+"";

        return Exito;


    }

    //supports



    public static int contador(String id,String idENVIO){
        int ido=0;
        M_DatosEnvio enviNuevo = new M_DatosEnvio();
        Controlador_DatosEnvio enviControl = new Controlador_DatosEnvio();

        ArrayList<M_DatosEnvio> Visualizador = new ArrayList<>();
        Visualizador = enviControl.getMisenvios(id);
        int index =0;
        for(M_DatosEnvio p: Visualizador){
            if(p.getCodigoGuia().equals(idENVIO)){
                ido = index;
            }
            index++;
        }

        return ido ;
    }



    public String generarid(){
        UUID uuid = UUID.randomUUID();

        String idAleatoria = uuid.toString().replaceAll("[^a-zA-Z0-9]", "_").substring(0, 5);

        return idAleatoria;
    }

}
