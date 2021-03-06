/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Opcion;
import modelo.PersistenciaPregunta;
import modelo.Pregunta;

/**
 *
 * @author celes
 */
public class TestAplicacion extends javax.swing.JFrame {
int numero = 0;
int tiempo=0;
    /**
     * Creates new form TestAplicacion
     */
    public TestAplicacion() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(300, 400);
        mostrarPregunta(numero++);
        Thread t1 = new Thread(new Runnable(){
        @Override
        public void run(){
        while (true){
        tiempo++;
        try{
        Thread.sleep(1000);
        EtiquetaTiempo.setText(""+tiempo);
        if(tiempo>=30)mostrarPregunta(numero++);
        }catch(InterruptedException ex){
        }
        }
        }
        
    });
    
    t1.start();
    }
   public void mostrarPregunta(int numero){
       tiempo =0;
        try {
            //primero sacamos la pregunta del numero dado
            ArrayList<Pregunta> preguntas=PersistenciaPregunta.leer();
            Pregunta p= preguntas.get(numero);
            //ahora ajustamos los valores
            //primero ajustamos el titulo
            EtiquetaPregunta.setText(p.getTitulo());
            //Ahora las opciones
            ArrayList<Opcion> opciones = p.getOpciones();
            //aplicamos el algoritmo random
            opciones =   PersistenciaPregunta.opcionesAleatorias(opciones);
            rb1.setText(opciones.get(0).getTitulo());
            rb2.setText(opciones.get(1).getTitulo());
            rb3.setText(opciones.get(2).getTitulo());
            rb4.setText(opciones.get(3).getTitulo());
        } catch (Exception ex) {
            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        EtiquetaTiempo = new javax.swing.JLabel();
        EtiquetaPregunta = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText("Contestar Test");
        getContentPane().add(jLabel1);

        EtiquetaTiempo.setText("TIEMPO");
        getContentPane().add(EtiquetaTiempo);

        EtiquetaPregunta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EtiquetaPregunta.setText("Aqui ira la pregunta");
        getContentPane().add(EtiquetaPregunta);

        buttonGroup1.add(rb1);
        rb1.setText("jRadioButton1");
        getContentPane().add(rb1);

        buttonGroup1.add(rb2);
        rb2.setText("jRadioButton2");
        getContentPane().add(rb2);

        buttonGroup1.add(rb3);
        rb3.setText("jRadioButton3");
        getContentPane().add(rb3);

        buttonGroup1.add(rb4);
        rb4.setText("jRadioButton4");
        getContentPane().add(rb4);

        jButton1.setText("sigueinte pregunta>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarPregunta(numero++);
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
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestAplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EtiquetaPregunta;
    private javax.swing.JLabel EtiquetaTiempo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    // End of variables declaration//GEN-END:variables
}
