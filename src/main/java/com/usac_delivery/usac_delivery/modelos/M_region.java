package com.usac_delivery.usac_delivery.modelos;

public class M_region extends M_manejodeDatos{
    private  double precioNormal;
    private double precioEspecial;

    public M_region() {
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPrecioEspecial() {
        return precioEspecial;
    }

    public void setPrecioEspecial(double precioEspecial) {
        this.precioEspecial = precioEspecial;
    }
}
