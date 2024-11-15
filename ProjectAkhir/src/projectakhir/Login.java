
package projectakhir;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends javax.swing.JFrame {

   
    public Login() {
        initComponents();
    }
    
    // Fungsi untuk memverifikasi login
private void verifyLogin() {
    String username = Tusername.getText();
    String password = new String(Tpassword.getPassword());
 
    // Menggunakan koneksi database untuk memeriksa login
    try (Connection conn = Koneksi.getConnection()) {
        String query = "SELECT role FROM logindaftar WHERE username = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String role = rs.getString("role");
            if ("admin".equals(role)) {
                JOptionPane.showMessageDialog(this, "Login berhasil sebagai Admin");
                new DesainAdmin().setVisible(true);
            } else if ("users".equals(role)) {
                JOptionPane.showMessageDialog(this, "Login berhasil sebagai User!");
                new DesainUser().setVisible(true);
            } 
            this.dispose(); // Tutup frame login
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah!");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e.getMessage());
    }
}

// Fungsi untuk membuka form buat akun
private void openCreateAccountFrame() {
    // Membuka frame buat akun
    new Register().setVisible(true);
    this.dispose(); // Menutup login frame
}

    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Tusername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Bregister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Blogout1 = new javax.swing.JButton();
        Blogin1 = new javax.swing.JButton();
        Tpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password    :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));
        jPanel1.add(Tusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 210, -1));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("LOGIN DULS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        Bregister.setBackground(new java.awt.Color(204, 255, 255));
        Bregister.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Bregister.setText("Register");
        Bregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BregisterActionPerformed(evt);
            }
        });
        jPanel1.add(Bregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username   :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        Blogout1.setBackground(new java.awt.Color(204, 255, 255));
        Blogout1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Blogout1.setText("Log out");
        Blogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Blogout1ActionPerformed(evt);
            }
        });
        jPanel1.add(Blogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 100, 30));

        Blogin1.setBackground(new java.awt.Color(204, 255, 255));
        Blogin1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Blogin1.setText("Login");
        Blogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Blogin1ActionPerformed(evt);
            }
        });
        jPanel1.add(Blogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 100, 30));

        Tpassword.setText("jPasswordField1");
        jPanel1.add(Tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BregisterActionPerformed
        // TODO add your handling code here:
        openCreateAccountFrame();
    }//GEN-LAST:event_BregisterActionPerformed

    private void Blogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Blogout1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Blogout1ActionPerformed

    private void Blogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Blogin1ActionPerformed
        // TODO add your handling code here:
        verifyLogin();
    }//GEN-LAST:event_Blogin1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Blogin1;
    private javax.swing.JButton Blogout1;
    private javax.swing.JButton Bregister;
    private javax.swing.JPasswordField Tpassword;
    private javax.swing.JTextField Tusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
