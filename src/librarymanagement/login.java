/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import librarymanagement.signup;

import librarymanagement.home;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static librarymanagement.home.hello;



/**
 *
 * @author khush
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        setSize(592, 300);
        setResizable(false);
        
        this.setLocationRelativeTo(null);
        
       
        
    }
    public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        juser = new javax.swing.JTextField();
        jpass = new javax.swing.JPasswordField();
        forget = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LIBRARY MANGEMENT SYSTEM - LOGIN");
        setMinimumSize(new java.awt.Dimension(610, 330));
        setSize(new java.awt.Dimension(510, 300));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 90, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 130, 80, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Login");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 20, 140, 40);

        juser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juserActionPerformed(evt);
            }
        });
        getContentPane().add(juser);
        juser.setBounds(410, 80, 170, 30);
        getContentPane().add(jpass);
        jpass.setBounds(410, 130, 170, 30);

        forget.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/lock.png"))); // NOI18N
        forget.setText("Forget Password");
        forget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgetActionPerformed(evt);
            }
        });
        getContentPane().add(forget);
        forget.setBounds(400, 200, 160, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/login1.png"))); // NOI18N
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 200, 110, 30);

        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/adduser.png"))); // NOI18N
        signup.setText("Sign Up");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(240, 200, 100, 30);

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarymanagement/lms11.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 590, 300);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 600, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void juserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_juserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username=juser.getText();
        String password=jpass.getText();
        if(username.equals(""))
        {
               JOptionPane.showMessageDialog(rootPane,"Please Input some valid credentials");
        }
        else{
        try{
             Class.forName("java.sql.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/school","root","root");
            Statement stmt=con.createStatement();
                    
                    String query="select password from login where user_name='"+username+"'";
                    ResultSet rs=stmt.executeQuery(query);
                    String ps="";
                    while(rs.next()){
                     ps=rs.getString(1);
                    }
                    System.out.println(ps);
                    if(ps.equals(password))
                    {
                         home Info = new home();
                    Info.setVisible(true);
                    this.setVisible(false);
                    String user=login.juser.getText();
                                    hello.setText("Hello "+user);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane, "Please Enter your Valid Credentials");
                    }
                    
                    
            }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void forgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgetActionPerformed
        // TODO add your handling code here:
        forgetpass Info = new forgetpass();
        Info.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forgetActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
           new librarymanagement.signup().setVisible(true);
           this.setVisible(false);
    }//GEN-LAST:event_signupActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forget;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jpass;
    public static javax.swing.JTextField juser;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables

    static class signup {

        public signup() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    
}
