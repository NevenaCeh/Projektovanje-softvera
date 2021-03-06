/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Sluzbenik;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author Nevena
 */
public class PocetnaUlogovana extends javax.swing.JFrame {

    /**
     * Creates new form PocetnaUlogovana
     */
    public PocetnaUlogovana() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        postaviLabelu();
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
        jlbUlogovani = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiUnosPartnera = new javax.swing.JMenuItem();
        jmiUnosLetova = new javax.swing.JMenuItem();
        jmiPretragaLetova = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiOdjava = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Zdravo");

        jlbUlogovani.setText("jLabel2");

        jMenu1.setText("Rad sa letovima");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmiUnosPartnera.setText("Unos partnera");
        jmiUnosPartnera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosPartneraActionPerformed(evt);
            }
        });
        jMenu1.add(jmiUnosPartnera);

        jmiUnosLetova.setText("Unos leta");
        jmiUnosLetova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUnosLetovaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiUnosLetova);

        jmiPretragaLetova.setText("Pretraga letova");
        jmiPretragaLetova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPretragaLetovaActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPretragaLetova);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Odjava");

        jmiOdjava.setText("Odjavi se");
        jmiOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOdjavaActionPerformed(evt);
            }
        });
        jMenu3.add(jmiOdjava);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(695, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlbUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlbUlogovani))
                .addContainerGap(493, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jmiUnosPartneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosPartneraActionPerformed
        // TODO add your handling code here:
        try {
            UnosAvioKompanija unos = new UnosAvioKompanija(this, true);
            unos.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jmiUnosPartneraActionPerformed

    private void jmiUnosLetovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUnosLetovaActionPerformed
        // TODO add your handling code here:
        try {
            UnosLetova unos = new UnosLetova(this, true);
            unos.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jmiUnosLetovaActionPerformed

    private void jmiPretragaLetovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPretragaLetovaActionPerformed
        // TODO add your handling code here:
        try {
            PretragaLetova pl = new PretragaLetova(this, true);
            pl.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jmiPretragaLetovaActionPerformed

    private void jmiOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOdjavaActionPerformed
        // TODO add your handling code here:
        int odluka = JOptionPane.showConfirmDialog(this, "Da li zaista zelite da se odjavite?");
        if (odluka == JOptionPane.YES_OPTION) {
            try {
                Kontroler.getInstance().odjava();
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jmiOdjavaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Sluzbenik s = (Sluzbenik) Kontroler.getInstance().getMapa().get("ulogovaniSluzbenik");
        if (s != null) {
            JOptionPane.showMessageDialog(this, "Ne mozete zatvoriti aplikaciju ako se ne odjavite prvo!!!");
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jlbUlogovani;
    private javax.swing.JMenuItem jmiOdjava;
    private javax.swing.JMenuItem jmiPretragaLetova;
    private javax.swing.JMenuItem jmiUnosLetova;
    private javax.swing.JMenuItem jmiUnosPartnera;
    // End of variables declaration//GEN-END:variables

    private void postaviLabelu() {
        Sluzbenik sl = (Sluzbenik) Kontroler.getInstance().getMapa().get("ulogovaniSluzbenik");
        String ime = sl.getIme();
        String prezime = sl.getPrezime();
        jlbUlogovani.setText(ime + " " + prezime);
    }
}
