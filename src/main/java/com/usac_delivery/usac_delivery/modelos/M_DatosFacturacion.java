package com.usac_delivery.usac_delivery.modelos;

public class M_DatosFacturacion extends M_manejodeDatos{
    String DF_dirección;
    String DF_idUsuario;
    String DF_nit;

    public M_DatosFacturacion() {
    }

    public String getDF_dirección() {
        return DF_dirección;
    }

    public void setDF_dirección(String DF_dirección) {
        this.DF_dirección = DF_dirección;
    }

    public String getDF_idUsuario() {
        return DF_idUsuario;
    }

    public void setDF_idUsuario(String DF_idUsuario) {
        this.DF_idUsuario = DF_idUsuario;
    }

    public String getDF_nit() {
        return DF_nit;
    }

    public void setDF_nit(String DF_nit) {
        this.DF_nit = DF_nit;
    }
}
