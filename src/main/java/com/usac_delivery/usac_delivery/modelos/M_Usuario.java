package com.usac_delivery.usac_delivery.modelos;

public class M_Usuario {
    private int p_id;
    private String p_correo;
    private String p_nombre;
    private String p_apellido;
    private String p_password;
    private String p_DPI;
    private String p_fechaDeNacimiento;
    private String p_genero;
    private String p_nacionalidad;
    private String p_alias;
    private int p_telefono;
    private int p_rol;
    //0 = usuario individual, 1 = usuario Empresarial o kiosko, 2=ADMIN
    private String foto;
    private int p_idKiosko;

    public M_Usuario(int p_id, String p_correo, String p_nombre, String p_apellido, String p_password, String p_DPI, String p_fechaDeNacimiento, String p_genero, String p_nacionalidad, String p_alias, int p_telefono, int p_rol, String foto, int p_idKiosko) {
        this.p_id = p_id;
        this.p_correo = p_correo;
        this.p_nombre = p_nombre;
        this.p_apellido = p_apellido;
        this.p_password = p_password;
        this.p_DPI = p_DPI;
        this.p_fechaDeNacimiento = p_fechaDeNacimiento;
        this.p_genero = p_genero;
        this.p_nacionalidad = p_nacionalidad;
        this.p_alias = p_alias;
        this.p_telefono = p_telefono;
        this.p_rol = p_rol;
        this.foto = foto;
        this.p_idKiosko = p_idKiosko;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_correo() {
        return p_correo;
    }

    public void setP_correo(String p_correo) {
        this.p_correo = p_correo;
    }

    public String getP_nombre() {
        return p_nombre;
    }

    public void setP_nombre(String p_nombre) {
        this.p_nombre = p_nombre;
    }

    public String getP_apellido() {
        return p_apellido;
    }

    public void setP_apellido(String p_apellido) {
        this.p_apellido = p_apellido;
    }

    public String getP_password() {
        return p_password;
    }

    public void setP_password(String p_password) {
        this.p_password = p_password;
    }

    public String getP_DPI() {
        return p_DPI;
    }

    public void setP_DPI(String p_DPI) {
        this.p_DPI = p_DPI;
    }

    public String getP_fechaDeNacimiento() {
        return p_fechaDeNacimiento;
    }

    public void setP_fechaDeNacimiento(String p_fechaDeNacimiento) {
        this.p_fechaDeNacimiento = p_fechaDeNacimiento;
    }

    public String getP_genero() {
        return p_genero;
    }

    public void setP_genero(String p_genero) {
        this.p_genero = p_genero;
    }

    public String getP_nacionalidad() {
        return p_nacionalidad;
    }

    public void setP_nacionalidad(String p_nacionalidad) {
        this.p_nacionalidad = p_nacionalidad;
    }

    public String getP_alias() {
        return p_alias;
    }

    public void setP_alias(String p_alias) {
        this.p_alias = p_alias;
    }

    public int getP_telefono() {
        return p_telefono;
    }

    public void setP_telefono(int p_telefono) {
        this.p_telefono = p_telefono;
    }

    public int getP_rol() {
        return p_rol;
    }

    public void setP_rol(int p_rol) {
        this.p_rol = p_rol;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getP_idKiosko() {
        return p_idKiosko;
    }

    public void setP_idKiosko(int p_idKiosko) {
        this.p_idKiosko = p_idKiosko;
    }

    public M_Usuario(){

    }


}
