/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netducation;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yoelt
 */
public class HomeWindow extends javax.swing.JFrame {

    public Users x = new Users();
    String namaLogin;
    int poinLogin;
    List<Course> lc = CourseDatabaseClass.selectQueryCourse();
    /**
     * Creates new form HomeWindow
     */
    public HomeWindow() {
        initComponents();
    }
    
    public void setData(Users u) {
        x = u;
    }
    
    public int selectedColumnHeaderIndex;
    
    private Boolean asc = true;
    private String criteria = "";
    
    public void setUserLogin() {
        namaLogin=x.getUsername();
        poinLogin=x.getPoint();
        
        if (x.getRole() == 1) {
            this.homeImgLabel.setText("<html>WELCOME ADMIN, <br><br>" + x.getUsername() + "</html>");
            this.deleteCourseButton.setEnabled(true);
            this.editCourseButton.setEnabled(true);
            this.tambahCourseButton.setEnabled(true);
            this.tambahTestButton.setEnabled(true);
            this.ambilCourseButton.setEnabled(false);
            this.homeLaporanButton.setEnabled(false);
            this.homeTestButton.setEnabled(false);
        }
        else {
            this.homeImgLabel.setText("<html>WELCOME, " + x.getUsername() + "<br><br>Poin saat ini : " + x.getPoint() + "</html>");
            this.deleteCourseButton.setEnabled(false);
            this.editCourseButton.setEnabled(false);
            this.tambahCourseButton.setEnabled(false);
            this.tambahTestButton.setEnabled(false);
            this.ambilCourseButton.setEnabled(true);
            this.homeLaporanButton.setEnabled(true);
            this.homeTestButton.setEnabled(true);
        }
    }
    
    public void clearText() {
        editUsernameField.setText("");
        editEmailField.setText("");
        editPasswordField.setText("");
        editRetypePasswordField.setText("");
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomeEditProfilWindow = new javax.swing.JFrame();
        editEmailLabel = new javax.swing.JLabel();
        editUsernameLabel = new javax.swing.JLabel();
        editPasswordLabel = new javax.swing.JLabel();
        editRetypePasswordLabel = new javax.swing.JLabel();
        editEmailField = new javax.swing.JTextField();
        editUsernameField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        editPasswordField = new javax.swing.JPasswordField();
        editRetypePasswordField = new javax.swing.JPasswordField();
        editProfilLabel = new javax.swing.JLabel();
        editClearButton = new javax.swing.JButton();
        editStatusLabel = new javax.swing.JLabel();
        TerminateAccount = new javax.swing.JFrame();
        terminateRetypePasswordField1 = new javax.swing.JPasswordField();
        terminateButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        terminatePasswordField1 = new javax.swing.JPasswordField();
        homeTerminateButton = new javax.swing.JButton();
        homeImgLabel = new javax.swing.JLabel();
        homeEditProfileButton = new javax.swing.JButton();
        homeTestButton = new javax.swing.JButton();
        homeLaporanButton = new javax.swing.JButton();
        homeLogoutButton = new javax.swing.JButton();
        tambahCourseButton = new javax.swing.JButton();
        editCourseButton = new javax.swing.JButton();
        deleteCourseButton = new javax.swing.JButton();
        ambilCourseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchCourseButton = new javax.swing.JButton();
        tambahTestButton = new javax.swing.JButton();

        HomeEditProfilWindow.setSize(new java.awt.Dimension(650, 500));

        editEmailLabel.setText("Email:");

        editUsernameLabel.setText("Username:");

        editPasswordLabel.setText("Password:");

        editRetypePasswordLabel.setText("Retype Password:");

        editEmailField.setText(x.getEmail());

        editButton.setText("Edit my profile...");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        editProfilLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        editProfilLabel.setText("Edit Profil");

        editClearButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        editClearButton.setText("Clear");
        editClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClearButtonActionPerformed(evt);
            }
        });

        editStatusLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editStatusLabel.setText("...");

        javax.swing.GroupLayout HomeEditProfilWindowLayout = new javax.swing.GroupLayout(HomeEditProfilWindow.getContentPane());
        HomeEditProfilWindow.getContentPane().setLayout(HomeEditProfilWindowLayout);
        HomeEditProfilWindowLayout.setHorizontalGroup(
            HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                        .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editProfilLabel)
                            .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                                        .addComponent(editClearButton)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HomeEditProfilWindowLayout.createSequentialGroup()
                                        .addComponent(editRetypePasswordLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(editRetypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editEmailLabel)
                                    .addComponent(editPasswordLabel)
                                    .addComponent(editUsernameLabel))
                                .addGap(49, 49, 49)
                                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(editPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 101, Short.MAX_VALUE)))
                .addContainerGap(516, Short.MAX_VALUE))
        );
        HomeEditProfilWindowLayout.setVerticalGroup(
            HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(editProfilLabel)
                .addGap(18, 18, 18)
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEmailLabel)
                    .addComponent(editEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editUsernameLabel)
                    .addComponent(editUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPasswordLabel)
                    .addComponent(editPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editRetypePasswordLabel)
                    .addComponent(editRetypePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomeEditProfilWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton)
                    .addGroup(HomeEditProfilWindowLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(editClearButton)))
                .addGap(32, 32, 32)
                .addComponent(editStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TerminateAccount.setSize(new java.awt.Dimension(400, 400));

        terminateButton1.setText("HAPUS AKUN :(");
        terminateButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminateButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Anda yakin ingin menghapus akun???");

        jLabel5.setText("Password:");

        jLabel6.setText("Retype Password:");

        javax.swing.GroupLayout TerminateAccountLayout = new javax.swing.GroupLayout(TerminateAccount.getContentPane());
        TerminateAccount.getContentPane().setLayout(TerminateAccountLayout);
        TerminateAccountLayout.setHorizontalGroup(
            TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerminateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addGroup(TerminateAccountLayout.createSequentialGroup()
                        .addGroup(TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(terminatePasswordField1)
                            .addComponent(terminateRetypePasswordField1)
                            .addComponent(terminateButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TerminateAccountLayout.setVerticalGroup(
            TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TerminateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(terminatePasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TerminateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(terminateRetypePasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(terminateButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeTerminateButton.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        homeTerminateButton.setForeground(new java.awt.Color(255, 0, 0));
        homeTerminateButton.setText("TERMINATE ACCOUNT");
        homeTerminateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeTerminateButtonActionPerformed(evt);
            }
        });

        homeImgLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        homeEditProfileButton.setText("Edit Profil");
        homeEditProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeEditProfileButtonActionPerformed(evt);
            }
        });

        homeTestButton.setText("Test");
        if (x.getRole() == 1) homeTestButton.setEnabled(false);
        else homeTestButton.setEnabled(true);

        homeLaporanButton.setText("Laporan");
        if (x.getRole() == 1) homeLaporanButton.setEnabled(false);
        else homeLaporanButton.setEnabled(true);

        homeLogoutButton.setForeground(new java.awt.Color(255, 0, 0));
        homeLogoutButton.setText("Log Out");
        homeLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeLogoutButtonActionPerformed(evt);
            }
        });

        if (x.getRole() == 1) tambahCourseButton.setEnabled(true);
        else tambahCourseButton.setEnabled(false);
        tambahCourseButton.setText("TAMBAH COURSE");
        tambahCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahCourseButtonActionPerformed(evt);
            }
        });

        if (x.getRole() == 1) editCourseButton.setEnabled(true);
        else editCourseButton.setEnabled(false);
        editCourseButton.setText("EDIT");
        editCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseButtonActionPerformed(evt);
            }
        });

        if (x.getRole() == 1) deleteCourseButton.setEnabled(true);
        else deleteCourseButton.setEnabled(false);
        deleteCourseButton.setText("DELETE");
        deleteCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseButtonActionPerformed(evt);
            }
        });

        ambilCourseButton.setText("AMBIL COURSE");
        if (x.getRole() == 1) ambilCourseButton.setEnabled(false);

        courseTable.setModel(CourseLogicClass.showAllCourseData(x));
        courseTable.getTableHeader().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String head = "";
                String order = "";
                selectedColumnHeaderIndex = courseTable.columnAtPoint(e.getPoint());
                if (asc) {
                    order = "ASC";
                    asc = false;
                }
                else {
                    order = "DESC";
                    asc = true;
                }
                switch(selectedColumnHeaderIndex) {
                    case 0: head = "courseID"; break;
                    case 1: head = "nama"; break;
                    case 2: head = "minimumPoin"; break;
                    case 3: head = "poinDapat"; break;
                }
                courseTable.setModel(CourseLogicClass.sortTableCourse(x, criteria, head, order));
                System.out.println(x.getUsername() + " " + criteria + " " + head + " " + order);
            }
        });
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(courseTable);

        searchCourseButton.setText("SEARCH");
        searchCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCourseButtonActionPerformed(evt);
            }
        });

        if (x.getRole() == 1) tambahTestButton.setEnabled(true);
        else tambahTestButton.setEnabled(false);
        tambahTestButton.setText("TAMBAH TEST");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(deleteCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ambilCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tambahCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tambahTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(homeTerminateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(homeImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(homeEditProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(homeTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(homeLaporanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(homeLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchField)
                                .addGap(18, 18, 18)
                                .addComponent(searchCourseButton)))))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homeEditProfileButton)
                            .addComponent(homeTestButton))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homeLaporanButton)
                            .addComponent(homeLogoutButton)))
                    .addComponent(homeImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCourseButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteCourseButton)
                    .addComponent(editCourseButton)
                    .addComponent(ambilCourseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeTerminateButton)
                    .addComponent(tambahCourseButton)
                    .addComponent(tambahTestButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int res;
        String user = editUsernameField.getText();
        String pass = String.valueOf(editPasswordField.getPassword());
        String rePass = String.valueOf(editRetypePasswordField.getPassword());
        String email = editEmailField.getText();
        if (user.equals(x.getUsername()) && email.equals(x.getEmail())) {
            res = LoginLogicClass.editDataValidationPassword(user, pass, rePass);
        }
        else if (user.equals(x.getUsername())) {
            res = LoginLogicClass.editDataValidationEmail(user, pass, rePass, email);
        }
        else if (email.equals(x.getEmail())) {
            res = LoginLogicClass.editDataValidationUsername(user, pass, rePass, email);
        }
        else {
            res = LoginLogicClass.editDataValidationAll(user, pass, rePass, email);
        }
        switch (res) {
            case 0: editStatusLabel.setText("DATA BERHASIL DI UPDATE"); clearText(); this.HomeEditProfilWindow.setVisible(false); this.HomeEditProfilWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE); break;
            case 1: editStatusLabel.setText("EMAIL YANG ANDA MASUKKAN TIDAK VALID, SILAHKAN COBA LAGI"); break;
            case 2: editStatusLabel.setText("PASSWORD YANG ANDA MASUKKAN TIDAK COCOK, SILAHKAN COBA LAGI"); break;
            case 3: editStatusLabel.setText("USERNAME SUDAH DIGUNAKAN, MASUKKAN USERNAME LAIN"); break;
            case 4: editStatusLabel.setText("EMAIL SUDAH TERDAFTAR, SILAHKAN COBA LAGI"); break;
            default: editStatusLabel.setText("SILAHKAN COBA LAGI"); break;
        }
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void homeEditProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeEditProfileButtonActionPerformed
        this.HomeEditProfilWindow.setVisible(true);
        this.HomeEditProfilWindow.setAlwaysOnTop(true);
        this.editEmailField.setText(x.getEmail());
        this.editUsernameField.setText(x.getUsername());
    }//GEN-LAST:event_homeEditProfileButtonActionPerformed

    private void homeLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeLogoutButtonActionPerformed
        RegisterLoginWindow f1 = new RegisterLoginWindow();
        this.setVisible(false);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//GEN-LAST:event_homeLogoutButtonActionPerformed

    private void editClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClearButtonActionPerformed
        clearText();
    }//GEN-LAST:event_editClearButtonActionPerformed

    private void homeTerminateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeTerminateButtonActionPerformed
        HomeWindow h = new HomeWindow();
        this.TerminateAccount.setVisible(true);
        this.TerminateAccount.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_homeTerminateButtonActionPerformed
   
    private void terminateButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminateButton1ActionPerformed
        RegisterLoginWindow f1 = new RegisterLoginWindow();
        String pass = String.valueOf(terminatePasswordField1.getPassword());
        String rePass = String.valueOf(terminateRetypePasswordField1.getPassword());
        if (pass.equals(rePass)) {
            if (x.getPassword().equals(String.valueOf(terminatePasswordField1.getPassword()))) {
                DatabaseClass.deleteQuery(x.getUsername());
                this.TerminateAccount.setVisible(false);
                JOptionPane.showMessageDialog(rootPane, "YOUR ACCOUNT HAS BEEN TERMINATED", "Termination Complete", JOptionPane.OK_OPTION);
                this.setVisible(false);
                f1.setVisible(true);
                f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "PASSWORD INVALID, SILAHKAN COBA LAGI", "Password Invalid", JOptionPane.ERROR_MESSAGE);
                terminatePasswordField1.setText("");
                terminateRetypePasswordField1.setText("");
            }
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "PASSWORD TIDAK COCOK, SILAHKAN COBA LAGI", "Password Not Match", JOptionPane.ERROR_MESSAGE);
            terminatePasswordField1.setText("");
            terminateRetypePasswordField1.setText("");
        }
    }//GEN-LAST:event_terminateButton1ActionPerformed

    private void deleteCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseButtonActionPerformed
        String id = (String) this.courseTable.getModel().getValueAt(this.courseTable.getSelectedRow(), 0);
        int x = JOptionPane.showConfirmDialog(rootPane, "Yakin ingin menghapus course??", "Delete Course", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            CourseLogicClass.deleteCourse(id);
        }
        else {
            
        }
    }//GEN-LAST:event_deleteCourseButtonActionPerformed

    private void tambahCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahCourseButtonActionPerformed
        TambahCourseWindow tc = new TambahCourseWindow();
        tc.setVisible(true);
        tc.setCourseLabel("Data Course Baru");
    }//GEN-LAST:event_tambahCourseButtonActionPerformed

    private void editCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseButtonActionPerformed
        TambahCourseWindow tc = new TambahCourseWindow();
        tc.courseID = (String) getCourseTable().getModel().getValueAt(this.getCourseTable().getSelectedRow(), 0);
        tc.setVisible(true);
        tc.setCourseLabel("Edit Data Course");
        tc.setAlwaysOnTop(true);
        System.out.println(tc.courseID);
        
    }//GEN-LAST:event_editCourseButtonActionPerformed

    private void searchCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCourseButtonActionPerformed
        criteria = searchField.getText();
        if (searchField.getText().isEmpty() || searchField.getText().equals("")) {
            this.courseTable.setModel(CourseLogicClass.showAllCourseData(x));
        }
        else {
            this.courseTable.setModel(CourseLogicClass.searchCourse(x, criteria));
        }
        this.courseTable.repaint();
    }//GEN-LAST:event_searchCourseButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeWindow hw = new HomeWindow();
                hw.setVisible(true);
                hw.setUserLogin();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame HomeEditProfilWindow;
    private javax.swing.JFrame TerminateAccount;
    private javax.swing.JButton ambilCourseButton;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton deleteCourseButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editClearButton;
    private javax.swing.JButton editCourseButton;
    private javax.swing.JTextField editEmailField;
    private javax.swing.JLabel editEmailLabel;
    private javax.swing.JPasswordField editPasswordField;
    private javax.swing.JLabel editPasswordLabel;
    private javax.swing.JLabel editProfilLabel;
    private javax.swing.JPasswordField editRetypePasswordField;
    private javax.swing.JLabel editRetypePasswordLabel;
    private javax.swing.JLabel editStatusLabel;
    private javax.swing.JTextField editUsernameField;
    private javax.swing.JLabel editUsernameLabel;
    private javax.swing.JButton homeEditProfileButton;
    private javax.swing.JLabel homeImgLabel;
    private javax.swing.JButton homeLaporanButton;
    private javax.swing.JButton homeLogoutButton;
    private javax.swing.JButton homeTerminateButton;
    private javax.swing.JButton homeTestButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton searchCourseButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton tambahCourseButton;
    private javax.swing.JButton tambahTestButton;
    private javax.swing.JButton terminateButton1;
    private javax.swing.JPasswordField terminatePasswordField1;
    private javax.swing.JPasswordField terminateRetypePasswordField1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the courseTable
     */
    public javax.swing.JTable getCourseTable() {
        return courseTable;
    }

    void setCourseTable(DefaultTableModel d) {
        this.courseTable.setModel(d);
    }
}
