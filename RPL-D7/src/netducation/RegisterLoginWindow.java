/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import com.alee.laf.WebLookAndFeel;
import javax.swing.JOptionPane;

/**
 *
 * @author yoelt
 */
public class RegisterLoginWindow extends javax.swing.JFrame {

    /**
     * @return the loginPasswordField
     */
    public String getLoginPasswordField() {
        return String.valueOf(loginPasswordField.getPassword());
    }

    /**
     * @return the loginUsernameField
     */
    public String getLoginUsernameField() {
        return loginUsernameField.getText();
    }


    /**
     * Creates new form RegisterLoginWindow
     */
    public RegisterLoginWindow() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        loginUsernameField = new javax.swing.JTextField();
        loginNameLabel = new javax.swing.JLabel();
        loginPassLabel = new javax.swing.JLabel();
        registerEmailLabel = new javax.swing.JLabel();
        registerUserLabel = new javax.swing.JLabel();
        registerPassLabel = new javax.swing.JLabel();
        registerCheckPassLabel = new javax.swing.JLabel();
        registerEmailField = new javax.swing.JTextField();
        registerUsernameField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        loginImgLabel = new javax.swing.JLabel();
        loginConfirmationLabel = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();
        registerPasswordField = new javax.swing.JPasswordField();
        registerRetypePasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setForeground(java.awt.Color.gray);
        setResizable(false);

        loginLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginLabel.setText("Masuk");

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerLabel.setText("Daftar Baru");

        loginUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameFieldActionPerformed(evt);
            }
        });

        loginNameLabel.setText("Username:");

        loginPassLabel.setText("Password:");

        registerEmailLabel.setText("Email:");

        registerUserLabel.setText("Username:");

        registerPassLabel.setText("Password:");

        registerCheckPassLabel.setText("Retype Password:");

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPackage/Login Icon.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPackage/Register Icon.png"))); // NOI18N
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPackage/Banner Login Window.png"))); // NOI18N

        loginConfirmationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginConfirmationLabel.setText("SELAMAT DATANG DI NETDUCATION");

        loginPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(loginConfirmationLabel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(loginPassLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(loginNameLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(88, 88, 88)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(registerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(108, 108, 108)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(registerUsernameField, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(registerPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(registerCheckPassLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(registerRetypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(342, 342, 342)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(registerEmailLabel)
                                            .addComponent(registerLabel)
                                            .addComponent(registerUserLabel)
                                            .addComponent(registerPassLabel))
                                        .addGap(142, 142, 142)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(loginImgLabel))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginPassLabel))
                        .addGap(18, 18, 18)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(registerEmailLabel)
                                    .addComponent(registerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(loginLabel)
                                    .addComponent(registerLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(loginNameLabel)
                                    .addComponent(loginUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerUserLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerPassLabel)
                            .addComponent(registerPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerCheckPassLabel)
                            .addComponent(registerRetypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(loginConfirmationLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String user = registerUsernameField.getText();
        String pass = String.valueOf(registerPasswordField.getPassword());
        String rePass = String.valueOf(registerRetypePasswordField.getPassword());
        String email = registerEmailField.getText();
        int res = LoginLogicClass.registerValidation(user, pass, rePass, email);
        switch (res) {
            case 0: JOptionPane.showMessageDialog(rootPane, "SELAMAT " + user + ", AKUN ANDA BERHASIL DIBUAT. SILAHKAN LOGIN", "Registration Success", JOptionPane.INFORMATION_MESSAGE); clearText(); break;
            case 1: JOptionPane.showMessageDialog(rootPane, "EMAIL YANG ANDA MASUKKAN TIDAK VALID, SILAHKAN COBA LAGI", "Registration Failed", JOptionPane.ERROR_MESSAGE);break;
            case 2: JOptionPane.showMessageDialog(rootPane, "PASSWORD YANG ANDA MASUKKAN TIDAK COCOK, SILAHKAN COBA LAGI", "Registration Failed", JOptionPane.ERROR_MESSAGE);break;
            case 3: JOptionPane.showMessageDialog(rootPane, "USERNAME SUDAH DIGUNAKAN, MASUKKAN USERNAME LAIN", "Registration Failed", JOptionPane.ERROR_MESSAGE); break;
            case 4: JOptionPane.showMessageDialog(rootPane, "EMAIL SUDAH TERDAFTAR, SILAHKAN COBA LAGI", "Registration Failed", JOptionPane.ERROR_MESSAGE); break;
            case 5: JOptionPane.showMessageDialog(rootPane, "SELAMAT ADMIN " + user + ", AKUN BERHASIL DIBUAT. SILAHKAN LOGIN", "Admin Account Created", JOptionPane.INFORMATION_MESSAGE); clearText(); break;
            default: JOptionPane.showMessageDialog(rootPane, "SILAHKAN COBA LAGI", "Registration Failed", JOptionPane.ERROR_MESSAGE); clearText(); break;
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordFieldActionPerformed
        this.loginButtonActionPerformed(evt);
    }//GEN-LAST:event_loginPasswordFieldActionPerformed

    private void loginUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameFieldActionPerformed
        this.loginButtonActionPerformed(evt);
    }//GEN-LAST:event_loginUsernameFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        HomeWindow hw = new HomeWindow();
        Users dataToSend = DatabaseClass.selectQueryUsersSingular(loginUsernameField.getText());
        Boolean res = LoginLogicClass.userValidation(loginUsernameField.getText(), String.valueOf(loginPasswordField.getPassword()));
        if (res) {
            hw.setVisible(true);
            hw.setTitle("NETDUCATION");
            hw.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(false);
            hw.x = dataToSend;
            hw.setUserLogin();
            //hw.setCourseTable(CourseLogicClass.showAllCourseData());
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "USER TERDETEKSI TIDAK VALID! SILAHKAN COBA LAGI", "Login Failed", JOptionPane.ERROR_MESSAGE);
            //loginConfirmationLabel.setText("USER TERDETEKSI TIDAK VALID! SILAHKAN COBA LAGI");
        }
        clearText();
    }//GEN-LAST:event_loginButtonActionPerformed
    
    public void clearText() {
        loginPasswordField.setText("");
        loginUsernameField.setText("");
        registerEmailField.setText("");
        registerUsernameField.setText("");
        registerPasswordField.setText("");
        registerRetypePasswordField.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        NativeInterface.initialize();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterLoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //WebLookAndFeel.install();
                RegisterLoginWindow myFrame = new RegisterLoginWindow();
                myFrame.setTitle("NETDucation Login Page");
                myFrame.setVisible(true);
                
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginConfirmationLabel;
    private javax.swing.JLabel loginImgLabel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel loginNameLabel;
    private javax.swing.JLabel loginPassLabel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JTextField loginUsernameField;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerCheckPassLabel;
    private javax.swing.JTextField registerEmailField;
    private javax.swing.JLabel registerEmailLabel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel registerPassLabel;
    private javax.swing.JPasswordField registerPasswordField;
    private javax.swing.JPasswordField registerRetypePasswordField;
    private javax.swing.JLabel registerUserLabel;
    private javax.swing.JTextField registerUsernameField;
    // End of variables declaration//GEN-END:variables
}
