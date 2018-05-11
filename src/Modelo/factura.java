/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author gateway1
 */
public class factura {
    private String fecha,formap,cfdi,receptor,emisor,observaciones;
    private int cantidad,statuo;
    float subtotal,impuestos,total;

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFormap() {
        return this.formap;
    }

    public void setFormap(String formap) {
        this.formap = formap;
    }

    public String getCfdi() {
        return this.cfdi;
    }

    public void setCfdi(String cfdi) {
        this.cfdi = cfdi;
    }

    public String getReceptor() {
        return this.receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getEmisor() {
        return this.emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getObservaciones() {
        return this.observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStatuo() {
        return this.statuo;
    }

    public void setStatuo(int statuo) {
        this.statuo = statuo;
    }

    public float getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getImpuestos() {
        return this.impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
