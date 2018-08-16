/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura_xml;

import Modelo.Facturadao;
import java.awt.Checkbox;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gateway1
 */
public class Extra_xml_ver extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    private JFileChooser filechooser = new JFileChooser();
    private JButton boton;
    private Checkbox check;
    JPanel panel;
    private TextField texto;
    private Label fila;
    private JScrollPane elsp;
    private int check_visto=2;
    Calendar fecha = Calendar.getInstance();
    int año = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH) + 1;
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechac = dia + "-" + mes + "-" + año;
    String fechaca = año + "-" + (mes) + "-" + (dia);

    /**
     * Creates new form Extra_xml
     */
    public Extra_xml_ver() {
        super("Ver elementos");
        initComponents();
        f1.setText(fechac);
        f2.setText(fechac);

//int y=0;
//int x=50;
//
//for(int i =0; i <10 ;i++){
// panelo.add(boton=new JButton("OK"));
// boton.setVisible(true);
//  boton.setBounds(300,10,50,20);
//boton.setLocation(300, y); 
//boton.addActionListener(new Botones_actions(i));
// panelo.add(check=new Checkbox(""));
// check.setVisible(true);
//  check.setBounds(300,10,50,20);
//check.setLocation(350, y); 
//check.addItemListener(new check_actions(i));
//check.setName("check"+i);
//check.setState(true);
//panelo.add(texto=new TextField(i));
//texto.setBounds(300, 10, 100, 20);
//texto.setLocation(410,y);
//texto.addActionListener(new Botones_actions1(i,texto.getText()));
//texto.setName("t"+i);
//y+=50;
////x+=50;
//}     
    }

    private class Botones_actions implements ActionListener {

        private int clave;

        public Botones_actions(int clave) {
            this.clave = clave;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(clave);
        }

    }

    private class Botones_actions1 implements ActionListener {

        private int clave;
        private String x;

        public Botones_actions1(int clave, String x) {
            this.clave = clave;
            this.x = x;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(clave + "-" + x + "-" + e.getActionCommand());
            Facturadao fac = new Facturadao();
            fac.actualizar_fact_texto(clave, e.getActionCommand());
            ver_regs();
        }

    }

    private class labelaction implements MouseListener {
        private int clave;
        private String x;
        public labelaction(int clave, String x) {
            this.clave = clave;
            this.x = x;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(clave + "-" + x + "-");
            Facturadao fac = new Facturadao();
            ArrayList<String> lista = new ArrayList<>();
            lista = fac.buscardet(clave);
            int cont = 0;
            String filas = "";
            for (int i = 0; i < lista.size(); i++) {
                if (cont == 6) {
                    filas += lista.get(i - 6) + "   " + lista.get(i - 5) + "   " + lista.get(i - 4) + "   " + lista.get(i - 3) + "   " + lista.get(i - 2) + "   " + lista.get(i - 1) + "   " + lista.get(i) + "\n";
                    cont = 0;
                } else {
                    cont++;
                }
            }
            JOptionPane.showMessageDialog(null, filas);
            filas = "";
            cont = 0;
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class check_actions implements ItemListener {
        private int clave;
        public check_actions(int clave) {
            this.clave = clave;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            System.out.println(clave + "-" + e.getStateChange());
            Facturadao fac = new Facturadao();
            fac.actualizar_fact(clave, e.getStateChange());
            ver_regs();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        panelo = new javax.swing.JPanel();
        f1 = new javax.swing.JFormattedTextField();
        f2 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        filtrado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        vistos = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1300, 720));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1200, 700));

        panelo.setBackground(new java.awt.Color(255, 255, 255));
        panelo.setAutoscrolls(true);
        panelo.setName(""); // NOI18N

        javax.swing.GroupLayout paneloLayout = new javax.swing.GroupLayout(panelo);
        panelo.setLayout(paneloLayout);
        paneloLayout.setHorizontalGroup(
            paneloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1262, Short.MAX_VALUE)
        );
        paneloLayout.setVerticalGroup(
            paneloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelo);

        f1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1ActionPerformed(evt);
            }
        });

        f2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        filtrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtradoMouseClicked(evt);
            }
        });
        filtrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtradoActionPerformed(evt);
            }
        });

        jLabel1.setText("Busqueda externa");

        vistos.setText("Mostrar vistos");
        vistos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vistosItemStateChanged(evt);
            }
        });
        vistos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vistosStateChanged(evt);
            }
        });
        vistos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vistosActionPerformed(evt);
            }
        });

        jButton2.setText("Exportar reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vistos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(vistos)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1ActionPerformed
        ver_regs();
    }//GEN-LAST:event_f1ActionPerformed

    private void f2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2ActionPerformed
        ver_regs();
    }//GEN-LAST:event_f2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ver_regs();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filtradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtradoActionPerformed
        ver_regs();
    }//GEN-LAST:event_filtradoActionPerformed

    private void filtradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtradoMouseClicked
        filtrado.setText("");
    }//GEN-LAST:event_filtradoMouseClicked

    private void vistosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vistosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vistosActionPerformed

    private void vistosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vistosStateChanged
    
    }//GEN-LAST:event_vistosStateChanged

    private void vistosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vistosItemStateChanged
       check_visto= evt.getStateChange();
       ver_regs();
    }//GEN-LAST:event_vistosItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                      try 
{ 
    Facturadao db = new Facturadao();
        Map parametros  = new HashMap();
        parametros.put("f1",f1.getText());
        parametros.put("f2",f2.getText());
        parametros.put("filtrado",filtrado.getText().toUpperCase());
        parametros.put("status",check_visto);
        JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("reporte.jasper"));
        db.abrir();
        JasperPrint print = JasperFillManager.fillReport(jasper, parametros, db.getConexion());
        JasperViewer ver = new JasperViewer(print,false);
        ver.setTitle("XML");
        ver.setVisible(true);
} 
catch(Exception e) 
{
    JOptionPane.showMessageDialog(null,e.getCause());
    e.printStackTrace(); 
}  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ver_regs() {
        Facturadao fac = new Facturadao();
        ArrayList<String> lista = new ArrayList<>();
        lista = fac.buscar(f1.getText(), f2.getText(), filtrado.getText().toUpperCase(),check_visto);

        String labels = "";
        int cont = 0;
        int y = 0;

        panelo.removeAll();
        for (int i = 0; i < lista.size(); i++) {
            if (cont == 10) {
                lista.get(i-5);
                //System.out.println(lista.get(i-5).length());
                String aux="";
                if(lista.get(i-5).length()>26){
                for(int h =0;h<26;h++){
                    aux+=lista.get(i-5).charAt(h);
                }
                }else{
                for(int h =0;h<27;h++){
                    if(h<lista.get(i-5).length()){
                    aux+=lista.get(i-5).charAt(h);
                    }else
                    aux+="   ";
                }
                }
                String folioaux="";
                if(lista.get(i).length()>9){
                for(int h =0;h<9;h++){
                    folioaux+=lista.get(i).charAt(h);
                }
                }else{
                for(int h =0;h<9;h++){
                    if(h<lista.get(i).length()){
                    folioaux+=lista.get(i).charAt(h);
                    }else
                    folioaux+="  ";
                }
                }
                System.out.println(lista.get(i-5).length()+" - "+aux.length());
                System.out.println(lista.get(i).length()+" - "+folioaux.length());
                labels += lista.get(i - 9) + "   FOLIO: " + folioaux + "      " + lista.get(i - 8) + "     " + lista.get(i - 7) + "    EMISOR: " + aux + "      SUBTOTAL: " + lista.get(i - 4) + "  IVA: "+lista.get(i-6)+"  TOTAL: " + lista.get(i - 3) + "     " + lista.get(i - 1) + " \n\n";

                panelo.add(fila = new Label(labels));
                fila.setVisible(true);
                fila.setBounds(0, 10, 1100, 15);
                fila.setLocation(0, y);
                fila.addMouseListener(new labelaction(Integer.parseInt(lista.get(i - 10)), ""));
                panelo.add(texto = new TextField(i));
                texto.setText(lista.get(i - 1));
                texto.setBounds(1120, 10, 70, 20);
                texto.setLocation(1120, y);
                texto.addActionListener(new Botones_actions1(Integer.parseInt(lista.get(i - 10)), texto.getText().toUpperCase()));
                texto.setName("t" + i);
                panelo.add(check = new Checkbox(""));
                check.setVisible(true);
                check.setBounds(1200, 10, 50, 20);
                check.setLocation(1200, y);
                check.addItemListener(new check_actions(Integer.parseInt(lista.get(i - 10))));
                check.setName("check" + i);
                if (lista.get(i - 2).equals("1")) {
                    check.setState(true);
                } else {
                    check.setState(false);
                }

                labels = "";
                y += 30;
                cont = 0;
            } else {
                cont++;
            }

            // panelo.add(boton=new JButton("OK"));
// boton.setVisible(true);
//  boton.setBounds(300,10,50,20);
//boton.setLocation(300, y); 
//boton.addActionListener(new Botones_actions(i));
        }
    }

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
            java.util.logging.Logger.getLogger(Extra_xml_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Extra_xml_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Extra_xml_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Extra_xml_ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Extra_xml_ver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField f1;
    private javax.swing.JFormattedTextField f2;
    private javax.swing.JTextField filtrado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelo;
    private javax.swing.JCheckBox vistos;
    // End of variables declaration//GEN-END:variables
}
