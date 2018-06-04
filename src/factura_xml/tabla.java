/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura_xml;

import Modelo.Facturadao;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.control.CheckBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gateway1
 */
public class tabla extends javax.swing.JInternalFrame {
DefaultTableModel model = new DefaultTableModel();
JButton boton;          
JCheckBox check;
JTextField texto;
        final Class[] tiposColumnas = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JCheckBox.class,
            JTextField.class // <- noten que aquí se especifica que la última columna es un botón
        };
                String[] columnas = new String[]{
            "Activo",
            "Nombre",
            "Dirección",
            "Fecha de nacimiento",
            "Hijos",
            "Botón",
            "Botón",
            "Botón",
            "Botón",
            "Botón",
            "Botón"};
        
        Object[][] datos = new Object[][]{
            { "Víctor", "Su casa", "a", "a","a","A","A","A","a",new JButton("Clic aquí"), new JButton("Clic aquí")},
            { "Fernanda", "calle", "b", "","","","","","",new JButton("Clic aquí"), new JButton("Clic aquí")},
            { "Julian", "Orilla ", "c" ,"","","","","","",new JButton("Clic aquí"), new JButton("Clic aquí")}
        };
        
    /**
     * Creates new form tabla
     */
    public tabla() {
        initComponents();
        Object[][] datos1=new Object[1][11];
        int cont =0;
        for(int k=0;k<11;k++){
            System.out.println(cont);
            if(cont <9){
            datos1[0][k]=k+"-";    
                cont++;
            }else if(cont ==9 ){
                
                check=new JCheckBox();
                check.addItemListener(new check_actions(1));
                check.setSelected(true);
             datos1[0][k]=check;
             
             System.out.println("aver asi");
             cont++;
            }else if( cont==10){
                texto=new JTextField("eeeh we");
             datos1[0][k]=texto;
            }
            
        }
        for(int i =0;i<11;i++){
            System.out.println(datos1[0][i]);
        }
        this.model.getDataVector().clear();
        tablon.setModel(new javax.swing.table.DefaultTableModel(datos1,columnas){
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }@Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JTextField.class));
            }
        });
        tablon.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                
                return (Component) objeto;
            }
                 
        });
        
                tablon.setDefaultRenderer(JTextField.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                
                return (Component) objeto;
            }
                 
        });
                tablon.setDefaultRenderer(JCheckBox.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                
                return (Component) objeto;
            }
                 
        });
                        tablon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tablon.rowAtPoint(e.getPoint());
                int columna = tablon.columnAtPoint(e.getPoint());

                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el botón, si tuviéramos más de un botón 
                 * por fila tendríamos que además preguntar por el contenido del botón o el nombre de la columna
                 */
                if (tablon.getModel().getColumnClass(columna).equals(JCheckBox.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tablon.getModel().getColumnCount(); i++) {
                        
                    }
                    JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila );
                }
                if (tablon.getModel().getColumnClass(columna).equals(String.class)) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este ejemplo, voy a mostrar
                     * en un cuadro de dialogo todos los campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < tablon.getModel().getColumnCount(); i++) {
                        
                    }
                    JOptionPane.showMessageDialog(null, "para el exto prro " + fila );
                }
            }
        });
       
    }    
    private class check_actions implements ItemListener {
        private int clave;
        public check_actions(int clave) {
            this.clave = clave;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(clave + "-" + e.getStateChange());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablon = new javax.swing.JTable();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("aver :V");

        tablon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "title5", "title 6", "title7", "title 8"
            }
        ));
        jScrollPane1.setViewportView(tablon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablon;
    // End of variables declaration//GEN-END:variables
}

