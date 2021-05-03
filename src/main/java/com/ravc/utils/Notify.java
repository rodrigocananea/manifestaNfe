/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.utils;

import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public final class Notify extends javax.swing.JDialog {

    private static final Point point = new Point();
    // ACTIONS
    final public static int CLOSE = -1;
    final public static int OK = 0;
    final public static int NOT = 2;
    final public static int YES = 1;
    
    // ACTIONS OPTIONS
    final public static int YES_OPTION = 10;
    final public static int YES_NO_OPTION = 11;
    final public static int OK_OPTION = 12;
    final public static int CLOSE_OPTION = 13;
    final public static int OPEN_DIRECTORY_OPTION = 14;

    // ICONS
    final public static String ICON_DEFAULT = "icons8_notification_110px.png";
    final public static String ICON_MORE_DETAILS = "icons8_more_details_110px.png";
    final public static String ICON_EMAIL = "icons8_email_110px_1.png";
    final public static String ICON_ASK_QUESTION = "icons8_ask_question_110px.png";
    final public static String ICON_NOTIFY = "icons8_notification_110px.png";
    final public static String ICON_HAPPY = "icons8_happy_110px.png";
    final public static String ICON_NEUTRAL = "icons8_neutral_110px.png";
    final public static String ICON_NOT_FOUND = "icons8_nothing_found_110px.png";
    final public static String ICON_PUZZLED = "icons8_puzzled_110px.png";
    final public static String ICON_SAD = "icons8_sad_110px.png";
    final public static String ICON_SLEEPING = "icons8_sleeping_110px.png";
    final public static String ICON_CRYING = "icons8_crying_110px.png";
    final public static String ICON_ANIME_EMOJI = "icons8_anime_emoji_110px.png";
    final public static String ICON_ANGRY = "icons8_angry_110px.png";
    final public static String ICON_ANGEL = "icons8_angel_110px.png";
    final public static String ICON_ERROR = "icons8_error_110px.png";

    private String message = "Oops!\nAcredito que algo deu errado...";
    private String description = "Por favor verifique as informações antes de realizar o envio";
    private String icon;
    private String directory;

    private int response = -1;
    private int type = 13;

    public Notify(java.awt.Frame parent, boolean modal, boolean content) {
        super(parent, modal);
        initComponents();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });

        if (!content) {
            jpContent.removeAll();
            jpMain.remove(jpContent);
            jpMain.setSize(459, 220);
            setSize(459, 220);
            jpMain.revalidate();
            jpMain.repaint();
            revalidate();
            repaint();
        }
    }

    public static Notify open() {
        return new Notify(null, true, false);
    }

    public static Notify open(boolean content) {
        return new Notify(null, true, content);
    }

    public static Notify open(Frame parent) {
        return new Notify(parent, true, true);
    }

    public static Notify open(Frame parent, boolean content) {
        return new Notify(parent, true, content);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpHeader = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpMessage = new javax.swing.JTextPane();
        jpContent = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jsDescription = new javax.swing.JSeparator();
        jspDescription = new javax.swing.JScrollPane();
        jtpDescription = new javax.swing.JTextPane();
        jpFooter = new javax.swing.JPanel();
        jbOpenDirectory = new javax.swing.JButton();
        jbYes = new javax.swing.JButton();
        jbNo = new javax.swing.JButton();
        jbOk = new javax.swing.JButton();
        jbClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModal(true);
        setName("Notify"); // NOI18N
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpMain.setBackground(new java.awt.Color(250, 250, 250));
        jpMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(174, 186, 213), 2));
        jpMain.setMaximumSize(new java.awt.Dimension(459, 350));
        jpMain.setPreferredSize(new java.awt.Dimension(459, 350));
        jpMain.setLayout(new java.awt.BorderLayout());

        jpHeader.setBackground(new java.awt.Color(250, 250, 250));
        jpHeader.setPreferredSize(new java.awt.Dimension(528, 170));
        jpHeader.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setPreferredSize(new java.awt.Dimension(150, 170));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jlImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_angel_110px.png"))); // NOI18N
        jPanel4.add(jlImage, java.awt.BorderLayout.CENTER);

        jpHeader.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jtpMessage.setEditable(false);
        jtpMessage.setBorder(null);
        jtpMessage.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jtpMessage.setForeground(new java.awt.Color(114, 157, 224));
        jtpMessage.setText("Ooops!\nTivemos um problema ao enviar o documento, porfavor verifique:");
        jScrollPane1.setViewportView(jtpMessage);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpHeader.add(jPanel5, java.awt.BorderLayout.CENTER);

        jpMain.add(jpHeader, java.awt.BorderLayout.NORTH);

        jpContent.setBackground(new java.awt.Color(250, 250, 250));
        jpContent.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(618, 10));

        jsDescription.setForeground(new java.awt.Color(204, 204, 204));
        jsDescription.setMaximumSize(new java.awt.Dimension(460, 10));
        jsDescription.setMinimumSize(new java.awt.Dimension(460, 10));
        jsDescription.setPreferredSize(new java.awt.Dimension(460, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jsDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jsDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jpContent.add(jPanel1, java.awt.BorderLayout.NORTH);

        jspDescription.setBorder(null);

        jtpDescription.setEditable(false);
        jtpDescription.setBackground(new java.awt.Color(250, 250, 250));
        jtpDescription.setBorder(null);
        jtpDescription.setContentType("text/html"); // NOI18N
        jtpDescription.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jtpDescription.setForeground(new java.awt.Color(102, 102, 102));
        jtpDescription.setText("<html>\r\n  <head>\r\n\r\n  </head>\r\n  <body>\r\n    <p style=\"margin: 0px 8px;font-family: 'Calibri Light';font-size: 11px;font-weight: normal\">\r\n      Agora vai\r\n    </p>\r\n  </body>\r\n</html>\r\n");
        jtpDescription.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jtpDescription.setMaximumSize(null);
        jspDescription.setViewportView(jtpDescription);

        jpContent.add(jspDescription, java.awt.BorderLayout.CENTER);

        jpMain.add(jpContent, java.awt.BorderLayout.CENTER);

        jpFooter.setBackground(new java.awt.Color(245, 245, 245));
        jpFooter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 223, 243)));
        jpFooter.setPreferredSize(new java.awt.Dimension(455, 45));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        jpFooter.setLayout(flowLayout1);

        jbOpenDirectory.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbOpenDirectory.setForeground(new java.awt.Color(114, 157, 224));
        jbOpenDirectory.setText("Abrir diretório");
        jbOpenDirectory.setContentAreaFilled(false);
        jbOpenDirectory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbOpenDirectory.setMaximumSize(new java.awt.Dimension(75, 35));
        jbOpenDirectory.setMinimumSize(new java.awt.Dimension(75, 35));
        jbOpenDirectory.setPreferredSize(new java.awt.Dimension(120, 35));
        jbOpenDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpenDirectoryActionPerformed(evt);
            }
        });
        jpFooter.add(jbOpenDirectory);

        jbYes.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbYes.setForeground(new java.awt.Color(114, 157, 224));
        jbYes.setText("Sim");
        jbYes.setContentAreaFilled(false);
        jbYes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbYes.setMaximumSize(new java.awt.Dimension(75, 35));
        jbYes.setMinimumSize(new java.awt.Dimension(75, 35));
        jbYes.setPreferredSize(new java.awt.Dimension(75, 35));
        jbYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbYesActionPerformed(evt);
            }
        });
        jpFooter.add(jbYes);

        jbNo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbNo.setForeground(new java.awt.Color(247, 98, 98));
        jbNo.setText("Não");
        jbNo.setContentAreaFilled(false);
        jbNo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNo.setMaximumSize(new java.awt.Dimension(75, 35));
        jbNo.setMinimumSize(new java.awt.Dimension(75, 35));
        jbNo.setPreferredSize(new java.awt.Dimension(75, 35));
        jbNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNoActionPerformed(evt);
            }
        });
        jpFooter.add(jbNo);

        jbOk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbOk.setForeground(new java.awt.Color(114, 157, 224));
        jbOk.setText("Ok");
        jbOk.setContentAreaFilled(false);
        jbOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbOk.setMaximumSize(new java.awt.Dimension(75, 35));
        jbOk.setMinimumSize(new java.awt.Dimension(75, 35));
        jbOk.setPreferredSize(new java.awt.Dimension(75, 35));
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jpFooter.add(jbOk);

        jbClose.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbClose.setForeground(new java.awt.Color(247, 98, 98));
        jbClose.setText("Fechar");
        jbClose.setContentAreaFilled(false);
        jbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbClose.setMaximumSize(new java.awt.Dimension(75, 35));
        jbClose.setMinimumSize(new java.awt.Dimension(75, 35));
        jbClose.setPreferredSize(new java.awt.Dimension(75, 35));
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCloseActionPerformed(evt);
            }
        });
        jpFooter.add(jbClose);

        jpMain.add(jpFooter, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jpMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        this.response = this.OK;
        dispose();
    }//GEN-LAST:event_jbOkActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseActionPerformed
        this.response = this.CLOSE;
        dispose();
    }//GEN-LAST:event_jbCloseActionPerformed

    private void jbNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNoActionPerformed
        this.response = this.NOT;
        dispose();
    }//GEN-LAST:event_jbNoActionPerformed

    private void jbYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbYesActionPerformed
        this.response = this.YES;
        dispose();
    }//GEN-LAST:event_jbYesActionPerformed

    private void jbOpenDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpenDirectoryActionPerformed
        try {
            if (this.directory == null) {
                this.directory = System.getProperty("user.dir");
            }
            Runtime.getRuntime().exec("cmd.exe /c start " + this.directory);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Problemas ao abrir diretório: \n" 
                    + this.directory + "\n\nMotivo:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_jbOpenDirectoryActionPerformed

    public Notify setDirectory(String directory) {
        this.directory = directory;
        return this;
    }
    
    public Notify setMessage(String message) {
        this.message = message;
        return this;
    }

    public Notify setDescription(String description) {
        this.description = description;
        return this;
    }

    public Notify setType(int type) {
        this.type = type;
        return this;
    }

    public Notify setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public int get() {

        if (this.icon == null || this.icon.equals("")) {
            this.icon = Notify.ICON_DEFAULT;
        }
        jlImage.setIcon(new ImageIcon(getClass().getResource("/icons/" + this.icon)));
        jtpMessage.setText(this.message);

        if (this.description == null || "".equals(this.description)) {
            this.description = "Nenhum detalhe foi informado!";
        }
        StringBuilder html = new StringBuilder();
        html.append("<html>");
        html.append("<head>");
        html.append("</head>");
        html.append("<body>");
        html.append("<p style=\"margin: 0px 8px 10px 8px;font-family: 'Calibri Light';");
        html.append("font-size: 11px;font-weight: normal\">");
        html.append(this.description.replaceAll("(\r\n|\n)", "<br/>"));
        html.append("<br/>");
        html.append("</p>");
        html.append("</body>");
        html.append("</html>");
        
        jtpDescription.setText(html.toString());

        switch (type) {
            case YES_OPTION: {
                jbNo.setVisible(false);
                jbOk.setVisible(false);
                jbOpenDirectory.setVisible(false);
                break;
            }
            case YES_NO_OPTION: {
                jbOk.setVisible(false);
                jbClose.setVisible(false);
                jbOpenDirectory.setVisible(false);
                break;
            }
            case OK_OPTION: {
                jbYes.setVisible(false);
                jbNo.setVisible(false);
                jbOpenDirectory.setVisible(false);
                break;
            }
            case OPEN_DIRECTORY_OPTION: {
                jbOk.setVisible(false);
                jbYes.setVisible(false);
                jbNo.setVisible(false);
                break;
            }
            default: {
                jbOpenDirectory.setVisible(false);
                jbYes.setVisible(false);
                jbNo.setVisible(false);
                jbOk.setVisible(false);
                break;
            }
        }

        setVisible(true);

        return response;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Notify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Notify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Notify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Notify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        EventQueue.invokeLater(() -> {
//            int res = Notify.open()
//                    .setType(Notify.YES_NO_OPTION)
//                    .setMessage("Testando outros avisos, para não ter nenhum problema com isso")
//                    .get();
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbNo;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbOpenDirectory;
    private javax.swing.JButton jbYes;
    public static javax.swing.JLabel jlImage;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpFooter;
    private javax.swing.JPanel jpHeader;
    private javax.swing.JPanel jpMain;
    private javax.swing.JSeparator jsDescription;
    private javax.swing.JScrollPane jspDescription;
    private javax.swing.JTextPane jtpDescription;
    private javax.swing.JTextPane jtpMessage;
    // End of variables declaration//GEN-END:variables
}
