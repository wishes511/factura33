/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.factura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mich
 */
public class Cfdi {
    //servidor local de pruebas

    String url = "jdbc:sqlserver://192.168.6.75\\SQLEXPRESS:9205;" + "databaseName=CFDI33;user=mich; password=mich;";
//    String url = "jdbc:sqlserver://192.168.6.75:9205;"
//            + "databaseName=avances;user=mich; password=mich;";
//    jdbc:sqlserver://192.168.6.75\SQLEXPRESS:9205;databaseName=avances
//   String url ="jdbc:sqlserver://192.168.6.8\\datos65:9205;databaseName=Avances;";
    String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // Declaramos los sioguientes objetos
    Connection conexion = null;
    Statement stmt = null;
    ResultSet rs = null;

    public Connection getConexion() {
        return this.conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void abrir() throws ClassNotFoundException, SQLException {
        Class.forName(drive);
        conexion = DriverManager.getConnection(url, "mich", "mich");
//        conexion = DriverManager.getConnection(url, "sa", "Prok2001");
        // System.out.println("hecho :]");
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    // Busquedas--------------
    public ArrayList<String> searchclv_uni(String unidad, ArrayList<String> arr) throws ClassNotFoundException, SQLException {
        boolean flag = true;
        String query = "SELECT distinct claveuni, nombre, descrip, nota, fecha, fechafin, simbolo\n"
                + "FROM         clavesu$\n"
                + "WHERE     (nombre LIKE '" + unidad + "%') or (nombre LIKE '%" + unidad + "') order by nombre";
        Statement smt;
        ResultSet df;
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            arr.add(df.getString("claveuni"));
            arr.add(df.getString("nombre"));
            arr.add(df.getString("descrip"));
            flag = false;
        }
        if (flag) {
            query = "SELECT distinct claveuni, nombre, descrip\n"
                    + "FROM         clavesu$\n"
                    + "WHERE     (claveuni LIKE '" + unidad + "%') or (claveuni LIKE '%" + unidad + "') order by nombre";
            abrir();
            smt = conexion.createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                arr.add(df.getString("claveuni"));
                arr.add(df.getString("nombre"));
                arr.add(df.getString("descrip"));

            }
        }
        df.close();
        smt.close();
        return arr;
    }

    public ArrayList<String> searchclv_prod(String unidad, ArrayList<String> arr) throws ClassNotFoundException, SQLException {
        boolean flag = true;
        String query = "SELECT clave, descrip\n"
                + "FROM         clavep$\n"
                + "WHERE     (descrip LIKE '" + unidad + "%') or (descrip LIKE '%" + unidad + "') or (descrip LIKE '%" + unidad + "%') order by descrip";
        Statement smt;
        ResultSet df;
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            arr.add(df.getString("clave"));
            arr.add(df.getString("descrip"));
            flag = false;
        }
        if (flag) {
            query = "SELECT distinct clave, descrip\n"
                    + "FROM         clavep$\n"
                    + "WHERE     (clave LIKE '" + unidad + "%') or (clave LIKE '%" + unidad + "') order by descrip";
            abrir();
            smt = conexion.createStatement();
            df = smt.executeQuery(query);
            while (df.next()) {
                arr.add(df.getString("clave"));
                arr.add(df.getString("descrip"));
                //System.out.println(query);
            }
        }
        df.close();
        smt.close();
        return arr;
    }

    public String autosearchunidad(String campo) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Statement smt;
        ResultSet df;
        String query = null;
        query = "SELECT nombre\n"
                + "FROM         clavesu$\n"
                + "WHERE     (claveuni = '" + campo + "')";
        //System.out.println(query);
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);

        while (df.next()) {
            campo = df.getString("nombre");
            flag = true;
        }
        if (!flag) {
            campo = "No se encontro";
        }
        df.close();
        smt.close();
        return campo;
    }

        public boolean buscaxmlrepetido(String folio, String emisor) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Statement smt;
        ResultSet df;
        String query = null;
        query = "SELECT clave_factura\n"
                + "FROM factura\n"
                + "WHERE folio='"+folio+"' and emisor ='"+emisor+"'";
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            flag = true;
        }
        df.close();
        smt.close();
        return flag;
    }
    
    public String autosearchprod(String campo) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Statement smt;
        ResultSet df;
        String query = null;
        query = "SELECT descrip\n"
                + "FROM      clavep$\n"
                + "WHERE     (clave = '" + campo + "')";
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            campo = df.getString("descrip");
            flag = true;
        }
        if (!flag) {
            campo = "No se encontro";
        }
        df.close();
        smt.close();
        return campo;
    }

    public String autosearchforma_pago(String campo) throws ClassNotFoundException, SQLException {
        boolean flag = false;
        Statement smt;
        ResultSet df;
        String query = null;
        query = "SELECT nombre\n"
                + "FROM         formapago$\n"
                + "WHERE     (clve = '" + campo + "')";
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            campo = df.getString("nombre");
            flag = true;
        }
        if (!flag) {
            campo = "No se encontro";
        }
        df.close();
        smt.close();
        return campo;
    }

    public String searchuso_cfdi(String campo) throws ClassNotFoundException, SQLException {
        boolean flag = true;
        String query = "SELECT descrip\n"
                + "FROM         usocfdi$\n"
                + "WHERE     clave='" + campo + "'";
        Statement smt;
        ResultSet df;
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            campo = (df.getString("descrip"));
            flag = true;
        }
        if (!flag) {
            campo = "No se encontro";
        }
        df.close();
        smt.close();
        return campo;
    }

    public ArrayList<String> busca_facts(String f1, String f2, String extra,int visto) throws ClassNotFoundException, SQLException {
        ArrayList<String> lista = new ArrayList<>();
        String query = "SELECT *  \n"
                + "FROM         factura\n"
                + "WHERE  (emisor like '%"+extra+"%' or receptor like '%"+extra+"%' or folio like '%"+extra+"%') and statuo="+visto+" and fecha > '" + f1 + "' and fecha < '" + f2 + "' order by fecha desc";
        Statement smt;
        ResultSet df;
        //System.out.println(query);
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            lista.add(df.getString("clave_factura"));
            lista.add(df.getString("fecha"));
            lista.add(df.getString("formap"));
            lista.add(df.getString("u_cfdi"));
            lista.add(df.getString("impuestos"));
            lista.add(df.getString("emisor"));
            lista.add(df.getString("subtotal"));
            lista.add(df.getString("total"));
            lista.add(df.getString("statuo"));
            lista.add(df.getString("observaciones"));
            lista.add(df.getString("folio"));

        }
        df.close();
        smt.close();
        return lista;
    }

    public ArrayList<String> busca_detfacts(int clave) throws ClassNotFoundException, SQLException {
        ArrayList<String> lista = new ArrayList<>();
        String query = "select * from dfactura where clave_factura=" + clave;
        Statement smt;
        ResultSet df;
        //System.out.println(query);
        abrir();
        smt = conexion.createStatement();
        df = smt.executeQuery(query);
        while (df.next()) {
            lista.add(df.getString("cantidad"));
            lista.add(df.getString("clave_prod"));
            lista.add(df.getString("clave_unidad"));
            lista.add(df.getString("descripcion"));
            lista.add(df.getString("precio_u"));
            lista.add(df.getString("impuestos"));
            lista.add(df.getString("importe"));
            
        }
        df.close();
        smt.close();
        return lista;
    }
    //insercion de datos a la bd

    public boolean nuevafact(ArrayList<String> lista) throws ClassNotFoundException, SQLException {
        PreparedStatement st = null;
        boolean b = false;
        int a = 0;
        try {
            abrir();
            conexion.setAutoCommit(false);
            String s = "insert into factura values('" + lista.get(2) + "','" + lista.get(4) + "','" + lista.get(20) + "','" + lista.get(18) + "','" + lista.get(15)
                    + "',0," + lista.get(10) + ","+lista.get(lista.size()-4)+"," + lista.get(13) + ",2,'','" + lista.get(3) + "')";
            //System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            //-----------------------------------
            Statement sts;
            ResultSet rs;
            String query = "select MAX(clave_factura) as clave_factura from factura";
            //System.out.println(query);
            sts = conexion.createStatement();
            rs = sts.executeQuery(query);
            while (rs.next()) {
                b = true;
                a = rs.getInt("clave_factura");
            }
            int j;
            int cont = 0;
            for (j = 22; j < lista.size(); j++) {
                if (cont == 6) {
                    s = "insert into dfactura values(" + a + "," + lista.get(j - 6) + "," + lista.get(j - 5) + ",'" + lista.get(j - 4) + "','" + lista.get(j - 3) + "'," + lista.get(j - 1) + ",'" + lista.get(j) + "'," + lista.get(j - 2) + ")";
                    //System.out.println(s);
                    st = conexion.prepareStatement(s);
                    st.executeUpdate();
                    cont = 0;
                } else {
                    cont++;
                }
            }
            conexion.commit();
        } catch (Exception e) {
            Logger.getLogger(Cfdi.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }

        st.close();
        return b;
    }
    //Actualizaciones o avances

    public void update_estado(int clave, int valor) throws SQLException {
        PreparedStatement st = null;
        try {// realizar avances
            abrir();
            conexion.setAutoCommit(false);
            String s = "update factura set statuo=" + valor + " where clave_factura=" + clave;
            //System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            conexion.commit();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Cfdi.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }
    }

    public void update_estado_obs(int clave, String valor) throws SQLException {
        PreparedStatement st = null;
        try {// realizar avances
            abrir();
            conexion.setAutoCommit(false);
            String s = "update factura set observaciones='" + valor + "' where clave_factura=" + clave;
           // System.out.println(s);
            st = conexion.prepareStatement(s);
            st.executeUpdate();
            conexion.commit();
            st.close();
        } catch (Exception e) {
            Logger.getLogger(Cfdi.class.getName()).log(Level.SEVERE, null, e);
            try {
                conexion.rollback();
            } catch (Exception o) {
                System.out.println(o.getMessage());
            }
        }
    }
}
