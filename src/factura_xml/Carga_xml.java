/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura_xml;

import Persistencia.Cfdi;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mich
 */
public class Carga_xml extends javax.swing.JInternalFrame {
DefaultTableModel model = new DefaultTableModel();
private JFileChooser filechooser = new JFileChooser();
    /**
     * Creates new form clv_prod
     */
    public Carga_xml() {
        super("Carga masiva de archivos");
        initComponents();        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Factura", "XML");
        filechooser.setFileFilter(filtro);
        this.getContentPane().add(filechooser,BorderLayout.CENTER);
        jButton1.requestFocus();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        scrollPane1 = new java.awt.ScrollPane();
        resp = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Carga masiva de archivos");
        setPreferredSize(new java.awt.Dimension(500, 500));

        prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodActionPerformed(evt);
            }
        });
        prod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prodKeyPressed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave Prod", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
        }

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        resp.setColumns(20);
        resp.setRows(5);
        scrollPane1.add(resp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodActionPerformed
        
    }//GEN-LAST:event_prodActionPerformed

    private void prodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prodKeyPressed
    
       
    }//GEN-LAST:event_prodKeyPressed

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
            for(int i =0;i<archivos.length;i++){
                String xmp=archivos[i]+"";
                if(xmp.charAt(xmp.length()-1) =='l'){
                files+=archivos[i]+"\n";
                arr1.add(archivos[i].toString());
                arr = fact.cargar_xml(archivos[i].toString());
                files_doc+="Folio: "+arr.get(3)+" Fecha: "+arr.get(2)+"\n"+"Metodo pago: "+arr.get(6)+" Forma Pago: "+arr.get(4)+"\n"+"Emisor: "+arr.get(15)+"\n";
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
                }
                files_doc+="\n";
            //System.out.println(archivos[i]);
            }
           resp.setText(files_doc);
            //resp.setText(files + " array "+files.length());
         }
        }catch(Exception e){
            System.out.println(e);
        }
           
    }//GEN-LAST:event_jButton1ActionPerformed
    public void busca(){
     model = new DefaultTableModel();
       model = (DefaultTableModel) jTable1.getModel();
       this.model.getDataVector().clear();
        Cfdi cfd = new Cfdi();
       int cont=0;
       ArrayList<String> arr= new ArrayList<>();
       try{
          arr=cfd.searchclv_prod(prod.getText(),arr);
          if(arr.size()==0){
              this.model.getDataVector().clear();
              model.fireTableDataChanged();
              jTable1.updateUI();
          }else{
           //System.out.println("total "+arr.size());
          for(int i =0;i<arr.size();i++){
              if(cont==1){
                  String[] rowss = { arr.get(i-1),arr.get(i)};
                   model.addRow(rowss);
                   cont=0; 
                 //System.out.println(arr.get(i-2)+"-"+arr.get(i-1)+"-"+arr.get(i)); 
              }else{
                  cont++;
              }
          }
          }
         
       }catch(Exception e){
          // System.out.println(e+"*"+e.getMessage());
       }
    }
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
            java.util.logging.Logger.getLogger(Cfdi_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cfdi_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cfdi_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cfdi_xml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carga_xml().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField prod;
    private javax.swing.JTextArea resp;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
