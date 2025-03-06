
package base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class FormLogin extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int xx, xy;
    private String loggedInUsername;

    public String getLoggedInUsername() {
        return loggedInUsername;
    }

    public FormLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        Sign = new javax.swing.JButton();
        baseLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 492, 267, 40));

        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 370, 260, 40));

        Sign.setBackground(new java.awt.Color(176, 57, 57));
        Sign.setFont(new java.awt.Font("Swis721 BlkCn BT", 0, 18)); // NOI18N
        Sign.setText("SIGN IN");
        Sign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(176, 57, 57)));
        Sign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignActionPerformed(evt);
            }
        });
        getContentPane().add(Sign, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 240, 40));

        baseLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/page login (7).png"))); // NOI18N
        getContentPane().add(baseLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_usernameMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void SignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignActionPerformed
        conn = Koneksi.getkoneksi();
        String sql = "SELECT * FROM login WHERE username=? and password=?";
        try {
            loggedInUsername = username.getText();
            pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                loggedInUsername = username.getText();
                dashboard start = new dashboard(this);
                start.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah", "pesan", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SignActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sign;
    private javax.swing.JLabel baseLogin;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
