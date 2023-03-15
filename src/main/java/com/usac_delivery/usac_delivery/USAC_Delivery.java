/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.usac_delivery.usac_delivery;
import com.usac_delivery.usac_delivery.controladores.Controlador_Region;
import com.usac_delivery.usac_delivery.controladores.Controlador_Usuario;
import com.usac_delivery.usac_delivery.graficos.g_autenticacion_usuario;
/**
 *
 * @author Julio Lima
 */
public class USAC_Delivery {

    public static void main(String[] args) {
        Controlador_Usuario.CrearAdmin();
        Controlador_Region.CrearListaDeRegiones();

        g_autenticacion_usuario Autenticar = new g_autenticacion_usuario();
        Autenticar.setVisible(true);
    }
}
