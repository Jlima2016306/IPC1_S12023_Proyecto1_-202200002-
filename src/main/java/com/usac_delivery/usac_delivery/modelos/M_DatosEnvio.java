package com.usac_delivery.usac_delivery.modelos;

import java.util.ArrayList;

public class M_DatosEnvio {
    String codigoGuia;
    String[] Origen = new String[4];
    String[] Destino = new String[4];
    int numeroDePaquetes;
    String peso;
    String tipoDePago;
    String idDatosFacturación;
    String idUsuario;
    String DestinatarioName;
    String NIT;
    String Destinatario;
    String fechaEnvio;
    Double total;


    public M_DatosEnvio() {
    }

    public String getCodigoGuia() {
        return codigoGuia;
    }

    public void setCodigoGuia(String codigoGuia) {
        this.codigoGuia = codigoGuia;
    }

    public String[] getOrigen() {
        return Origen;
    }

    public void setOrigen(String[] origen) {
        Origen = origen;
    }

    public String[] getDestino() {
        return Destino;
    }

    public void setDestino(String[] destino) {
        Destino = destino;
    }

    public int getNumeroDePaquetes() {
        return numeroDePaquetes;
    }

    public void setNumeroDePaquetes(int numeroDePaquetes) {
        this.numeroDePaquetes = numeroDePaquetes;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public String getIdDatosFacturación() {
        return idDatosFacturación;
    }

    public void setIdDatosFacturación(String idDatosFacturación) {
        this.idDatosFacturación = idDatosFacturación;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDestinatarioName() {
        return DestinatarioName;
    }

    public void setDestinatarioName(String destinatarioName) {
        DestinatarioName = destinatarioName;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String destinatario) {
        Destinatario = destinatario;
    }
}
