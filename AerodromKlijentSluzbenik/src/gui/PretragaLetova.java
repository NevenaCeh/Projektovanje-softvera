/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Let;
import dto.ServerTransferObjekat;
import gui.komponente.TblModelLetovi;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import util.Util;

/**
 *
 * @author Nevena
 */
public class PretragaLetova extends javax.swing.JDialog {

    /**
     * Creates new form PretragaLetova
     */
    public PretragaLetova(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        srediTabelu();
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
        jtfKriterijumPretrage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblLetovi = new javax.swing.JTable();
        jbtnObrisi = new javax.swing.JButton();
        jlbObavestenje = new javax.swing.JLabel();
        jbtnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga letova:");

        jtfKriterijumPretrage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfKriterijumPretrageKeyReleased(evt);
            }
        });

        jLabel2.setText("Letovi");

        jtblLetovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblLetovi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblLetoviMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblLetovi);

        jbtnObrisi.setText("Obrisi");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jlbObavestenje.setText("jLabel3");

        jbtnDetalji.setText("Detalji");
        jbtnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnDetalji, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(jbtnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfKriterijumPretrage, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jlbObavestenje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 358, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnDetalji)
                        .addGap(44, 44, 44)
                        .addComponent(jbtnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfKriterijumPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jlbObavestenje))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfKriterijumPretrageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfKriterijumPretrageKeyReleased
        TblModelLetovi tml = (TblModelLetovi) jtblLetovi.getModel();
        try {
            String text = jtfKriterijumPretrage.getText().trim();
            jlbObavestenje.setVisible(true);
            List<Let> lletova = Kontroler.getInstance().pretraziLetove(text);
            if (text == null || text.isEmpty()) {
                jlbObavestenje.setVisible(false);
            }
            if (lletova != null || !lletova.isEmpty()) {
                jlbObavestenje.setText("Pronadjeni letovi po unetoj vrednosti!!!");
            } else {
                jlbObavestenje.setText("Sistem ne može da nađe letove po zadatim vrednostima!!!");
            }
            tml.setListaLetova(lletova);
        } catch (Exception ex) {
            jlbObavestenje.setText("Sistem ne može da nađe letove po zadatim vrednostima!!!");
            tml.setListaLetova(new ArrayList<>());
        }

    }//GEN-LAST:event_jtfKriterijumPretrageKeyReleased

    private void jtblLetoviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblLetoviMouseClicked
        // TODO add your handling code here:
        jbtnObrisi.setVisible(true);
        jbtnDetalji.setVisible(true);
    }//GEN-LAST:event_jtblLetoviMouseClicked

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        int odluka = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete ovaj let?");
        if (odluka == JOptionPane.YES_OPTION) {
            int red = jtblLetovi.getSelectedRow();
            if (red >= 0) {
                try {
                    TblModelLetovi tml = (TblModelLetovi) jtblLetovi.getModel();
                    Let let = tml.getLet(red);
                    Kontroler.getInstance().obrisiLet(let);
                    ServerTransferObjekat sto = (ServerTransferObjekat) Kontroler.getInstance().getMapa().get("statusObrisanogLeta");
                    if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                        JOptionPane.showMessageDialog(this, "Sistem je obrisao let!!!");
                        srediTabelu();
                    } else {
                        JOptionPane.showMessageDialog(this, sto.getGreska());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jbtnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDetaljiActionPerformed
        // TODO add your handling code here:
        int red = jtblLetovi.getSelectedRow();
        if (red >= 0) {
            TblModelLetovi tml = (TblModelLetovi) jtblLetovi.getModel();
            Let let = tml.getLet(red);
            Let l;
            try {
                l = Kontroler.getInstance().vratiLet(let);
                UnosLetova detalji = new UnosLetova(new PocetnaUlogovana(), true, l);
                detalji.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        }
    }//GEN-LAST:event_jbtnDetaljiActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDetalji;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JLabel jlbObavestenje;
    private javax.swing.JTable jtblLetovi;
    private javax.swing.JTextField jtfKriterijumPretrage;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try {
            List<Let> letovi = Kontroler.getInstance().vratiLetoveIzBaze();
            TblModelLetovi tml = new TblModelLetovi(letovi);
            jtblLetovi.setModel(tml);
            jbtnObrisi.setVisible(false);
            jlbObavestenje.setVisible(false);
            jbtnDetalji.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(PretragaLetova.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
