/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura_xml;

import Modelo.Facturadao;
import Persistencia.Cfdi;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gateway1
 */
public class Extra_xml extends javax.swing.JInternalFrame {
DefaultTableModel model = new DefaultTableModel();
private JFileChooser filechooser = new JFileChooser();
private JButton boton;
JPanel panel;
private JScrollPane elsp;
    /**
     * Creates new form Extra_xml
     */
    public Extra_xml() {
        super("Carga masiva de archivos");
        initComponents();        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Factura", "XML");
        filechooser.setFileFilter(filtro);
        this.getContentPane().add(filechooser,BorderLayout.CENTER);
        jButton1.requestFocus();
//int y=0;
//int x=50;
//for(int i =0; i <10 ;i++){
// panel.add(boton=new JButton("OK"));
// boton.setVisible(true);
//  boton.setBounds(300,10,50,20);
//boton.setLocation(300, y); 
//boton.addActionListener(new Botones_actions(i));
//y+=50;
////x+=50;
//}     
 
        
        
    }

    private class Botones_actions implements ActionListener{
        private int clave;
        public Botones_actions(int clave){
            this.clave=clave;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(clave);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resp = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1300, 600));

        jButton1.setText("Elegir Archivos ...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resp.setColumns(20);
        resp.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        resp.setRows(5);
        jScrollPane1.setViewportView(resp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int returnval = filechooser.showOpenDialog(this);
        try{
           
         String files="";
         String files_doc="";
         if (returnval == JFileChooser.APPROVE_OPTION) {
             
             ArrayList<String> arr = new ArrayList<>();
             ArrayList<String> arr1 = new ArrayList<>();
            
           // File file = filechooser.getSelectedFile();
            File file = filechooser.getCurrentDirectory();
            //System.out.println(file.getAbsolutePath());
           files=file.getAbsolutePath() + "/* "+file.exists()+" solo file "+filechooser.getCurrentDirectory();
            //prod.setText(file.getAbsolutePath());  
            File[] archivos=file.listFiles();
            
            Factura_xml fact = new Factura_xml();
            int conta=0;

            for(int i =0;i<archivos.length;i++){
                
                String xmp=archivos[i]+"";
                if(xmp.charAt(xmp.length()-1) =='l'){
                    System.out.println(i+"-"+conta);
                files+=archivos[i]+"\n";
                arr1.add(archivos[i].toString());
                arr = fact.cargar_xml(archivos[i].toString());
                Facturadao fdao = new Facturadao();
                fdao.nuevo(arr);
                files_doc+="Folio: "+arr.get(3)+" Fecha: "+arr.get(2)+"\n"+"Metodo pago: "+arr.get(6)+" Forma Pago: "+arr.get(4)+"\n"+"Emisor: "+
                        arr.get(15)+"\n";
                int j;
                int cont=0;
            for ( j = 22; j < arr.size(); j++) {
               if(cont ==6){
                    files_doc+="       Cantidad: "+arr.get(j-6)+"   Clave Producto: "+arr.get(j-5)+"   Clave Unidad: "+arr.get(j-4)+"   Descripcion "+arr.get(j-3)+
                            "   Valor Unitario: "+arr.get(j-1)+"   Impuestos: "+arr.get(j)+"   Importe: "+arr.get(j-2)+"\n";
                   cont=0;
               }else{
                   cont++;
               }
            }
                arr.clear();
                File dile=archivos[i];
                dile.delete();
                }
                files_doc+="\n";
            //System.out.println(archivos[i]);
            }
           resp.setText(files_doc);
//          this.model.getDataVector().clear();
//        final Class[] tiposColumnas = new Class[]{
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            java.lang.String.class,
//            JButton.class,
//            JButton.class // <- noten que aquí se especifica que la última columna es un botón
//        };
//                String[] columnas = new String[]{
//            "Activo",
//            "Nombre",
//            "Dirección",
//            "Fecha de nacimiento",
//            "Hijos",
//            "Botón",
//            "Botón",
//            "Botón",
//            "Botón",
//            "Botón",
//            "Botón"};
//        
//        Object[][] datos = new Object[][]{
//            { "Víctor", "Su casa", "", "","","","","","",new JButton("Clic aquí"), new JButton("Clic aquí")},
//            { "Fernanda", "calle", "", "","","","","","",new JButton("Clic aquí"), new JButton("Clic aquí")},
//            { "Julian", "Orilla ", "" ,"","","","","","",new JButton("Clic aquí"), new JButton("Clic aquí")}
//        };
//        tabla.setModel(new javax.swing.table.DefaultTableModel(datos,columnas){
//            Class[] tipos = tiposColumnas;
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
//                // observen que estamos retornando la clase que definimos de antemano.
//                return tipos[columnIndex];
//            }@Override
//            public boolean isCellEditable(int row, int column) {
//                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
//                return !(this.getColumnClass(column).equals(JButton.class));
//            }
//        });
//        tabla.setDefaultRenderer(JButton.class, new TableCellRenderer() {
//            @Override
//            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
//                
//                return (Component) objeto;
//            }
//
//                 
//        });

       // model.addRow(rowss);
            //resp.setText(files + " array "+files.length());
         }
        }catch(Exception e){
            Logger.getLogger(Cfdi.class.getName()).log(Level.SEVERE, null, e);
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Extra_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Extra_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Extra_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extra_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Extra_xml().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resp;
    // End of variables declaration//GEN-END:variables
}
