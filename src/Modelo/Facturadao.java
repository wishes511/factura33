/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Persistencia.Cfdi;
import dao.facturas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gateway1
 */
public class Facturadao extends Cfdi implements facturas {

    @Override
    public boolean nuevo(ArrayList<String> lista) {
       boolean clave=false;
        try {
            clave=nuevafact(lista);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return clave;
    }

    @Override
    public ArrayList<String> buscar(String f1,String f2, String extra,int visto) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            lista=busca_facts(f1,f2,extra,visto);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public ArrayList<String> buscardet(int clave) {
        ArrayList<String> lista = new ArrayList<>();
        try {
            lista=busca_detfacts(clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void actualizar_fact(int clave, int valor) {
        try {
            update_estado(clave,valor);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar_fact_texto(int clave, String obs) {
        try {
            update_estado_obs(clave,obs);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getconect() {
        try {
            abrir();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Facturadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getConexion();
    }

    
}
