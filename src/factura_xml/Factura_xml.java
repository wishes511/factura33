/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura_xml;

/**
 *
 * @author gateway1
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
public class Factura_xml {
    ArrayList<String> arr = new ArrayList<>();
    ArrayList<String> array = new ArrayList<>();
     SAXBuilder builder = new SAXBuilder();
     String cadena;
    
//    lectura_factura().setVisible(true);
    public ArrayList<String> cargar_xml(String ruta){
    File xmlFile = new File( ruta );
    try
    {
        Document document = (Document) builder.build( xmlFile );
        Element rootNode= document.getRootElement();
        String nombrexml=(rootNode.getName());
        String strFolio= rootNode.getAttributeValue("Folio");
        String strFolio1= rootNode.getAttributeValue("folio");
       arr= Inicio(arr,rootNode);// primeros componentes de la factura
        List list = rootNode.getChildren();
        //System.out.println(list.size());
        boolean emisor=false;
        boolean receptor=false;
        
        for(int i=0;i< list.size();i++){
            Element elementcfdi=(Element)list.get(i);
            String valor= elementcfdi.getName();
            
            if(valor.equals("Emisor") || valor.equals("emisor")){
                arr.add(elementcfdi.getAttributeValue("Nombre"));
                arr.add(elementcfdi.getAttributeValue("Rfc"));
                arr.add(elementcfdi.getAttributeValue("RegimenFiscal"));
                }
            if(valor.equals("Receptor") || valor.equals("receptor")){
                arr.add(elementcfdi.getAttributeValue("Nombre"));
                arr.add(elementcfdi.getAttributeValue("Rfc"));
                arr.add(elementcfdi.getAttributeValue("UsoCFDI"));
                arr.add("");
            }
             if(valor.equals("Conceptos") || valor.equals("conceptos")){
                List list1= elementcfdi.getChildren();
                for(int j=0;j<list1.size();j++){
                Element elementcfdi1=(Element)list1.get(j);
                arr.add(elementcfdi1.getAttributeValue("Cantidad"));
                arr.add(elementcfdi1.getAttributeValue("ClaveProdServ"));
                arr.add(elementcfdi1.getAttributeValue("ClaveUnidad"));
                arr.add(elementcfdi1.getAttributeValue("Descripcion"));
                arr.add(elementcfdi1.getAttributeValue("Importe"));
                arr.add(elementcfdi1.getAttributeValue("ValorUnitario"));
                // impuestos
                List list2= elementcfdi1.getChildren();
                Element elementcfdi2=(Element)list2.get(0);
 List list3= elementcfdi2.getChildren();
                Element elementcfdi3=(Element)list3.get(0);
             List list4= elementcfdi3.getChildren();
                Element elementcfdi4=(Element)list4.get(0);
//                arr.add("Impuestos");
                arr.add(elementcfdi4.getAttributeValue("Impuesto")+" - IVA  "+elementcfdi4.getAttributeValue("Importe"));

                }
                }if(valor.equals("Impuestos") || valor.equals("impuestos")){
                arr.add(elementcfdi.getAttributeValue("TotalImpuestosTrasladados"));
                 List list1= elementcfdi.getChildren();
                Element elementcfdi1=(Element)list1.get(0);
                 List list2= elementcfdi1.getChildren();
                Element elementcfdi2=(Element)list2.get(0);
                arr.add(elementcfdi2.getAttributeValue("Importe"));
                //System.out.println("Importe="+elementcfdi2.getAttributeValue("Importe")+list2.size()+list2.get(0));
            }
            if(valor.equals("Complemento")|| valor.equals("complemento")){
            
                List list1= elementcfdi.getChildren();
                Element elementcfdi1=(Element)list1.get(0);
                arr.add(elementcfdi1.getAttributeValue("NoCertificadoSAT"));
                arr.add(elementcfdi1.getAttributeValue("SelloSAT"));
                arr.add(elementcfdi1.getAttributeValue("RfcProvCertif"));
            }
        }
    }catch ( IOException io ) {
        System.out.println( io.getMessage() );
    }   catch (JDOMException ex) {
            Logger.getLogger(Factura_xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    return arr;
    }
    public void cargacfdi() throws FileNotFoundException, IOException{
       // FileInputStream file = new FileInputStream(new File("cfdi.xls")); //ruta del archivo xls o xlsx
  }
    public ArrayList<String> Inicio(ArrayList<String> arr,Element rootNode){
               ArrayList<String> linicio= lista_inicio();
        int z=0;
        while(z<linicio.size()){
            String data= rootNode.getAttributeValue(linicio.get(z));
           // System.out.println(rootNode.getAttributeValue(linicio.get(z))+"*"+data+"*"+linicio.get(z));
            if(data==(null)){
                arr.add(rootNode.getAttributeValue(linicio.get(z).toLowerCase()));
                
            }else{
                arr.add(data); 
                
            }
            z++;
        }
        return arr;
    }
    public ArrayList<String> lista_inicio(){
        ArrayList<String> arri = new ArrayList<>();
        arri.add("Certificado");
        arri.add("Descuento");
        arri.add("Fecha");
        arri.add("Folio");
        arri.add("FormaPago");
        arri.add("LugarExpedicion");
        arri.add("MetodoPago");
        arri.add("Moneda");
        arri.add("NoCertificado");
        arri.add("Sello");
        arri.add("SubTotal");
        arri.add("TipoCambio");
        arri.add("TipoDeComprobante");
        arri.add("Total");
        arri.add("Version");
       return arri; 
    }
    

    public ArrayList<String> Emisor(){
        ArrayList<String> emi = new ArrayList<>();
        emi.add("Nombre");
        emi.add("RegimenFiscal");
        emi.add("Rfc");
        return emi;
    }
    public ArrayList<String> Receptor(){
        ArrayList<String> emi = new ArrayList<>();
        emi.add("Nombre");
        emi.add("Rfc");
        emi.add("UsoCFDI");
        return emi;
    }
    public ArrayList<String> Concepto(){
        ArrayList<String> con = new ArrayList<>();
        con.add("Cantidad");
        con.add("ClaveProdServ");
        con.add("ClaveUnidad");
        con.add("Descripcion");
        con.add("Importe");
        con.add("ValorUnitario");
        return con;
    }
    public ArrayList<String> Impuestos(){
        ArrayList<String> imp = new ArrayList<>();
        imp.add("TotalImpuestosTraslados");
        return imp;
    }
    public ArrayList<String> Traslados(){
        ArrayList<String> con = new ArrayList<>();
        con.add("TotalImpuestosTraslados");
        return con;
    }
    
   public static void main(String [] args){
   lectura_factura lf= new lectura_factura();
   lf.setVisible(true);
   }
 
    
}
