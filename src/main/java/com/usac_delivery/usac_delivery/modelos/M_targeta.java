package com.usac_delivery.usac_delivery.modelos;

public class M_targeta extends M_manejodeDatos{
    String fecha_de_vencimiento="";
    String idUsuario="";
    String idTargeta;

    public M_targeta() {
    }

    public String getFecha_de_vencimiento() {
        return fecha_de_vencimiento;
    }

    public void setFecha_de_vencimiento(String fecha_de_vencimiento) {
        this.fecha_de_vencimiento = fecha_de_vencimiento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTargeta() {
        return idTargeta;
    }

    public void setIdTargeta(String idTargeta) {
        this.idTargeta = idTargeta;
    }
}
