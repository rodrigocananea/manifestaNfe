/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravc.utils;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

/**
 *
 * @author Rodrigo
 */
public class FinalizarSistema extends javax.swing.JDialog {

    public final static int SAIR_BACKUP = 0;
    public final static int SAIR = 1;
    public final static int NAO = -1;

    private static final Point pointMove = new Point();
    private static Retorno retorno;

    /**
     * Creates new form FrmSair
     */
    public FinalizarSistema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pointMove.x = e.getX();
                pointMove.y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - pointMove.x, p.y + e.getY() - pointMove.y);
            }
        });
        retorno = new Retorno();
        jbSair.requestFocus();
    }

    public static FinalizarSistema open(JFrame frame) {
        return new FinalizarSistema(frame, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jbSair = new javax.swing.JButton();
        jbNao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar sistema");
        setUndecorated(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(250, 250, 250));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(102, 153, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setTabSize(0);
        jTextArea1.setText("Deseja realmente finalizar o sistema?");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        jTextArea1.setMargin(new java.awt.Insets(25, 15, 10, 10));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setPreferredSize(new java.awt.Dimension(362, 45));

        jbSair.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbSair.setForeground(new java.awt.Color(102, 153, 255));
        jbSair.setText("Sim (Enter)");
        jbSair.setBorderPainted(false);
        jbSair.setContentAreaFilled(false);
        jbSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSair.setMaximumSize(new java.awt.Dimension(75, 35));
        jbSair.setMinimumSize(new java.awt.Dimension(75, 35));
        jbSair.setPreferredSize(new java.awt.Dimension(120, 35));
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });
        jbSair.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbSairKeyPressed(evt);
            }
        });
        jPanel2.add(jbSair);

        jbNao.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jbNao.setForeground(new java.awt.Color(247, 98, 98));
        jbNao.setText("Não (Esc)");
        jbNao.setBorderPainted(false);
        jbNao.setContentAreaFilled(false);
        jbNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbNao.setMaximumSize(new java.awt.Dimension(75, 35));
        jbNao.setMinimumSize(new java.awt.Dimension(75, 35));
        jbNao.setPreferredSize(new java.awt.Dimension(120, 35));
        jbNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNaoActionPerformed(evt);
            }
        });
        jbNao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbNaoKeyPressed(evt);
            }
        });
        jPanel2.add(jbNao);

        jPanel3.add(jPanel2, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        retorno.setSair(this.SAIR);
        dispose();
    }//GEN-LAST:event_jbSairActionPerformed

    private void jbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNaoActionPerformed
        retorno.setSair(this.NAO);
        dispose();
    }//GEN-LAST:event_jbNaoActionPerformed

    private void jbSairKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbSairKeyPressed
        events(evt);
    }//GEN-LAST:event_jbSairKeyPressed

    private void jbNaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbNaoKeyPressed
        events(evt);
    }//GEN-LAST:event_jbNaoKeyPressed

    private void events(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            retorno.setSair(this.NAO);
            dispose();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retorno.setSair(this.SAIR);
            dispose();
        }
    }

    public int get() {
        setVisible(true);
        return retorno.getSair();
    }

    class Retorno {

        int sair;

        public Retorno() {

        }

        public int getSair() {
            return sair;
        }

        public void setSair(int sair) {
            this.sair = sair;
        }
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
//            java.util.logging.Logger.getLogger(FinalizarSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FinalizarSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FinalizarSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FinalizarSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                FinalizarSistema dialog = new FinalizarSistema(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    };

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbNao;
    private javax.swing.JButton jbSair;
    // End of variables declaration//GEN-END:variables
}