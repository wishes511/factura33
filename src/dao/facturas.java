/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author gateway1
 */
public interface facturas {
    public boolean nuevo(ArrayList<String> lista);
    public ArrayList<String> buscar(String f1,String f2, String extra,int visto);
    public ArrayList<String> buscardet(int clave);
    public void actualizar_fact(int check, int valor); 
    public void actualizar_fact_texto(int clave,String obs);
    public Connection getconect();
}
