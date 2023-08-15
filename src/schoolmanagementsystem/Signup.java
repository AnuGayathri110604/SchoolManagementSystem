/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolmanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Signup extends javax.swing.JFrame {
    public Signup() {
        initComponents();
        
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        cpass = new javax.swing.JPasswordField();
        login = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText(" SCHOOL MANAGEMENT SYSTEM");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 21, 403, 42));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("SIGN UP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 75, -1, -1));

        jLabel3.setText("NAME:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 170, -1, -1));

        jLabel4.setText("EMAIL:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 224, -1, -1));

        jLabel5.setText("PASSWORD:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 280, -1, -1));

        jLabel6.setText("CONFIRM PASSWORD:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 337, -1, -1));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 170, 298, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 224, 298, -1));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 280, 298, -1));
        getContentPane().add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 337, 298, -1));

        login.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        login.setForeground(new java.awt.Color(255, 51, 102));
        login.setText("Already have an accout? Login?");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, 30));

        jButton1.setText("Sign up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked

    JFrame loginFrame = new JFrame("Login"); 
    Login1 loginPanel = new Login1(loginFrame);
    loginFrame.add(loginPanel);
    loginFrame.pack();
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_loginMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String n = name.getText();   
    String e = email.getText(); 
    String pa = pass.getText();
    String cpa = cpass.getText();
    boolean isStrong = checkStrength(pa);
    if (!isStrong) {
        return;
    }
    if (!pa.equals(cpa)) {
        JOptionPane.showMessageDialog(null, "Passwords do not match.");
        return;
    }
    try {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "");
        int pin = generateRandomPIN();
        String sql = "INSERT INTO signup (name, email, password1, confirm_password, pin) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, n);
        pstmt.setString(2, e);
        pstmt.setString(3, pa);
        pstmt.setString(4, cpa);
        pstmt.setInt(5, pin); 
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Sign up successful.");
            dispose();
            welcome welcomePage = new welcome();
            welcomePage.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to sign up.");
        }
        pstmt.close();
        conn.close();
    } catch (SQLException a) {
        a.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error while establishing the connection");
    }
    }//GEN-LAST:event_jButton1ActionPerformed
private boolean checkStrength(String input) {
    int n = input.length();
    boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;
    String specialCharacters = "!@#$%^&*()_-+=|{}[]:;<>,.?/";
    for (char i : input.toCharArray()) {
        if (Character.isLowerCase(i)) {
            hasLower = true;
        }
        if (Character.isUpperCase(i)) {
            hasUpper = true;
        }
        if (Character.isDigit(i)) {
            hasDigit = true;
        }
        if (specialCharacters.indexOf(i) != -1) {
            specialChar = true;
        }
    }

    System.out.print("Strength of password: ");
    if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8)) {
        System.out.println("Strong");
        return true;
    } else if ((hasLower && hasUpper && specialChar) && (n >= 6)) {
        System.out.println("Moderate");
        JOptionPane.showMessageDialog(null,"Password should be at least 8 characters long.\n");
        return false;
    } else {
        System.out.println("Weak");

        StringBuilder feedback = new StringBuilder("Password is not strong enough.\n");
        if (!hasDigit) {
            feedback.append("- Add at least one digit.\n");
        }
        if (!hasLower) {
            feedback.append("- Add at least one lowercase letter.\n");
        }
        if (!hasUpper) {
            feedback.append("- Add at least one uppercase letter.\n");
        }
        if (!specialChar) {
            feedback.append("- Add at least one special character.\n");
        }
        if (n < 8) {
            feedback.append("- Password should be at least 8 characters long.\n");
        }
        JOptionPane.showMessageDialog(null, feedback.toString());
        return false;
    }
}
    private int generateRandomPIN() {
    return (int) (Math.random() * 9000) + 1000;
}
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cpass;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel login;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
