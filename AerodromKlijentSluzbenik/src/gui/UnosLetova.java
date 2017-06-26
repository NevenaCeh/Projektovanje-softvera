/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.AvioKompanijaPartner;
import domen.Avion;
import domen.Let;
import domen.Mesto;
import domen.Putnik;
import domen.Rezervacija;
import domen.Sluzbenik;
import dto.ServerTransferObjekat;
import gui.komponente.TblModelRezervacije;
import java.util.*;
import javax.swing.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import util.Util;

/**
 *
 * @author Nevena
 */
public class UnosLetova extends javax.swing.JDialog {

    /**
     * Creates new form UnosLetova
     */
    public UnosLetova(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        popuniComboBoxove();
        postaviLabelu();
        jTabbedPane1.removeTabAt(1);
    }
    Let let;

    public UnosLetova(java.awt.Frame parent, boolean modal, Let l) {
        super(parent, modal);
        initComponents();
        let = l;
        popuniZaPrikaz();
//        postaviLabeluZaIzmene();
        popuniComboPutnici();
        zabraniIzmene();
        jbtnSacuvaj.setVisible(false);
        jpnlDodajRezervaciju.setVisible(false);
        jlbObavestenje.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnlLet = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rbLeta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcbAvioKompanije = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jcbDestinacija = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcbAvion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jtfDatum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfSatnica = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbtnSacuvaj = new javax.swing.JButton();
        jpnlRezervacija = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRezervacije = new javax.swing.JTable();
        jbtnDodaj = new javax.swing.JButton();
        jpnlDodajRezervaciju = new javax.swing.JPanel();
        jtfDatumRezervacije = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcbPutnik = new javax.swing.JComboBox<>();
        jbtnDodajPutnika = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jrbNijePotvrdjena = new javax.swing.JRadioButton();
        jrbPotvrdjena = new javax.swing.JRadioButton();
        jbtnSacuvajRezervaciju = new javax.swing.JButton();
        jtfBrojPasosa = new javax.swing.JTextField();
        jlbObavestenjeOPutniku = new javax.swing.JLabel();
        jlbObavestenje = new javax.swing.JLabel();
        jbtnObrisi = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel7.setText("Ovo je let pod rednim brojem: ");

        rbLeta.setText("jLabel8");

        jLabel1.setText("Organizuje");

        jcbAvioKompanije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Destinacija:");

        jcbDestinacija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Avion: ");

        jcbAvion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Datum: ");

        jtfDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDatumActionPerformed(evt);
            }
        });

        jLabel6.setText("dd.MM.yyyy.");

        jLabel8.setText("Satnica:");

        jLabel9.setText("h:min");

        jbtnSacuvaj.setText("Sacuvaj");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlLetLayout = new javax.swing.GroupLayout(jpnlLet);
        jpnlLet.setLayout(jpnlLetLayout);
        jpnlLetLayout.setHorizontalGroup(
            jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLetLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnlLetLayout.createSequentialGroup()
                        .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnlLetLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(rbLeta))
                            .addGroup(jpnlLetLayout.createSequentialGroup()
                                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbAvioKompanije, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbAvion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbDestinacija, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDatum)
                                    .addGroup(jpnlLetLayout.createSequentialGroup()
                                        .addComponent(jtfSatnica, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(0, 201, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnlLetLayout.setVerticalGroup(
            jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlLetLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbLeta))
                .addGap(18, 18, 18)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbAvioKompanije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbDestinacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jpnlLetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfSatnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(56, 56, 56)
                .addComponent(jbtnSacuvaj)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Let", jpnlLet);

        jLabel10.setText("Rezervisano:");

        jtblRezervacije.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblRezervacije.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRezervacijeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRezervacije);

        jbtnDodaj.setText("Dodaj rezervaciju");
        jbtnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajActionPerformed(evt);
            }
        });

        jLabel11.setText("Datum rezervacije:");

        jLabel12.setText("Putnik:");

        jcbPutnik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnDodajPutnika.setText("Dodaj putnika");
        jbtnDodajPutnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajPutnikaActionPerformed(evt);
            }
        });

        jLabel13.setText("Status");

        buttonGroup1.add(jrbNijePotvrdjena);
        jrbNijePotvrdjena.setSelected(true);
        jrbNijePotvrdjena.setText("Nije potvrdjena");

        buttonGroup1.add(jrbPotvrdjena);
        jrbPotvrdjena.setText("Potvrdjena");

        jbtnSacuvajRezervaciju.setText("Sacuvaj rezervaciju");
        jbtnSacuvajRezervaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajRezervacijuActionPerformed(evt);
            }
        });

        jtfBrojPasosa.setText("broj pasosa");
        jtfBrojPasosa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfBrojPasosaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBrojPasosaFocusLost(evt);
            }
        });
        jtfBrojPasosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBrojPasosaKeyReleased(evt);
            }
        });

        jlbObavestenjeOPutniku.setText("Ne mozemo pronaci podatke o putniku!!!");

        javax.swing.GroupLayout jpnlDodajRezervacijuLayout = new javax.swing.GroupLayout(jpnlDodajRezervaciju);
        jpnlDodajRezervaciju.setLayout(jpnlDodajRezervacijuLayout);
        jpnlDodajRezervacijuLayout.setHorizontalGroup(
            jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                        .addComponent(jbtnSacuvajRezervaciju)
                        .addGap(21, 21, 21))
                    .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                        .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                                        .addComponent(jrbNijePotvrdjena)
                                        .addGap(45, 45, 45)
                                        .addComponent(jrbPotvrdjena)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                                        .addComponent(jtfDatumRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jlbObavestenjeOPutniku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlDodajRezervacijuLayout.createSequentialGroup()
                                        .addComponent(jtfBrojPasosa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbtnDodajPutnika)))
                                .addContainerGap())))))
        );
        jpnlDodajRezervacijuLayout.setVerticalGroup(
            jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDodajRezervacijuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDatumRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jlbObavestenjeOPutniku)
                .addGap(8, 8, 8)
                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBrojPasosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDodajPutnika)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jcbPutnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnlDodajRezervacijuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jrbNijePotvrdjena)
                    .addComponent(jrbPotvrdjena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jbtnSacuvajRezervaciju)
                .addContainerGap())
        );

        jlbObavestenje.setText("Nema rezervacija za ovaj let!");

        jbtnObrisi.setText("Obrisi rezervaciju");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmeni");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlRezervacijaLayout = new javax.swing.GroupLayout(jpnlRezervacija);
        jpnlRezervacija.setLayout(jpnlRezervacijaLayout);
        jpnlRezervacijaLayout.setHorizontalGroup(
            jpnlRezervacijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlRezervacijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlRezervacijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnlRezervacijaLayout.createSequentialGroup()
                        .addComponent(jbtnDodaj)
                        .addGap(61, 61, 61)
                        .addComponent(jbtnObrisi)
                        .addGap(83, 83, 83)
                        .addComponent(jbtnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlRezervacijaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(48, 48, 48)
                        .addComponent(jlbObavestenje))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jpnlDodajRezervaciju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jpnlRezervacijaLayout.setVerticalGroup(
            jpnlRezervacijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlRezervacijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlRezervacijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlbObavestenje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlRezervacijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodaj)
                    .addComponent(jbtnObrisi)
                    .addComponent(jbtnIzmeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlDodajRezervaciju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rezervacija", jpnlRezervacija);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDatumActionPerformed
    }//GEN-LAST:event_jtfDatumActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        // TODO add your handling code here:
        int odluka = JOptionPane.showConfirmDialog(this, "Da li zelite da sacuvate ovaj let?");
        if (odluka == JOptionPane.YES_OPTION) {
            try {
                Let let = kreirajLet();
                Kontroler.getInstance().sacuvajLet(let);
                ServerTransferObjekat sto = (ServerTransferObjekat) Kontroler.getInstance().getMapa().get("sacuvanLet");
                if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                    JOptionPane.showMessageDialog(this, sto.getRezultat().toString());
                } else {
                    JOptionPane.showMessageDialog(this, sto.getGreska());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }//GEN-LAST:event_jbtnSacuvajActionPerformed
    boolean otvoreno = false;
    private void jbtnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajActionPerformed
        if (otvoreno) {
            jpnlDodajRezervaciju.setVisible(false);
            otvoreno = false;
        } else {
            jpnlDodajRezervaciju.setVisible(true);
            otvoreno = true;
        }

    }//GEN-LAST:event_jbtnDodajActionPerformed

    private void jbtnDodajPutnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajPutnikaActionPerformed
        UnosPutnika unos = new UnosPutnika(new PocetnaUlogovana(), true, this);
        unos.setVisible(true);
    }//GEN-LAST:event_jbtnDodajPutnikaActionPerformed


    private void jbtnSacuvajRezervacijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajRezervacijuActionPerformed
        // TODO add your handling code here:
        try {
            int odluka = JOptionPane.showConfirmDialog(this, "Da li zelite da sacuvate ovu rezervaciju?");
            if (odluka == JOptionPane.YES_OPTION) {
                try {
                    Rezervacija reserve = kreirajRezervacija();
                    Kontroler.getInstance().sacuvajRezervaciju(reserve);
                    ServerTransferObjekat sto = (ServerTransferObjekat) Kontroler.getInstance().getMapa().get("sacuvanaRezervacija");
                    if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                        JOptionPane.showMessageDialog(this, sto.getRezultat().toString());
                        postaviTabelu();
                    } else {
                        JOptionPane.showMessageDialog(this, sto.getGreska());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jbtnSacuvajRezervacijuActionPerformed

    private void jtblRezervacijeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRezervacijeMouseClicked
        // TODO add your handling code here:
        jbtnIzmeni.setVisible(true);
        jbtnObrisi.setVisible(true);
    }//GEN-LAST:event_jtblRezervacijeMouseClicked

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        // TODO add your handling code here:
        int odluka = JOptionPane.showConfirmDialog(this, "Da li zelite da obrisete ovu rezervaciju?");
        if (odluka == JOptionPane.YES_OPTION) {
            int red = jtblRezervacije.getSelectedRow();
            if (red >= 0) {
                try {
                    TblModelRezervacije tml = (TblModelRezervacije) jtblRezervacije.getModel();
                    Rezervacija r = tml.getRezervacija(red);
                    Kontroler.getInstance().obrisiRezervaciju(r);
                    ServerTransferObjekat sto = (ServerTransferObjekat) Kontroler.getInstance().getMapa().get("statusObrisaneRez");
                    if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                        JOptionPane.showMessageDialog(this, "Rezervacija je uspesno obrisana!!!");
                        postaviTabelu();
                    } else {
                        JOptionPane.showMessageDialog(this, sto.getGreska());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed
        // TODO add your handling code here:
        int odluka = JOptionPane.showConfirmDialog(this, "Da li zelite da izmenite ovu rezervaciju?");
        if (odluka == JOptionPane.YES_OPTION) {
            int red = jtblRezervacije.getSelectedRow();
            if (red >= 0) {
                try {
                    TblModelRezervacije tml = (TblModelRezervacije) jtblRezervacije.getModel();
                    Rezervacija r = tml.getRezervacija(red);
                    Kontroler.getInstance().izmeniRezervaciju(r);
                    ServerTransferObjekat sto = (ServerTransferObjekat) Kontroler.getInstance().getMapa().get("statusIzmene");
                    if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                        JOptionPane.showMessageDialog(this, "Rezervacija je uspesno izmenjena!!!");
                        postaviTabelu();
                    } else {
                        JOptionPane.showMessageDialog(this, sto.getGreska());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jtfBrojPasosaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBrojPasosaFocusGained
        // TODO add your handling code here:
        jtfBrojPasosa.setText("");
    }//GEN-LAST:event_jtfBrojPasosaFocusGained

    private void jtfBrojPasosaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBrojPasosaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBrojPasosaFocusLost

    private void jtfBrojPasosaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBrojPasosaKeyReleased
        // TODO add your handling code here:
        try {
            String text = jtfBrojPasosa.getText().trim();
            Putnik putnik = Kontroler.getInstance().pronadjiPutnika(text);
            if (text.isEmpty()) {
                jlbObavestenjeOPutniku.setVisible(false);
            }
            if (putnik != null) {
                jcbPutnik.setSelectedItem(putnik);
                jlbObavestenjeOPutniku.setVisible(false);
            } else {
                jlbObavestenjeOPutniku.setVisible(true);
            }
        } catch (Exception ex) {
            jlbObavestenjeOPutniku.setVisible(true);
        }
    }//GEN-LAST:event_jtfBrojPasosaKeyReleased

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnDodaj;
    private javax.swing.JButton jbtnDodajPutnika;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JButton jbtnSacuvajRezervaciju;
    private javax.swing.JComboBox jcbAvioKompanije;
    private javax.swing.JComboBox jcbAvion;
    private javax.swing.JComboBox jcbDestinacija;
    private javax.swing.JComboBox<String> jcbPutnik;
    private javax.swing.JLabel jlbObavestenje;
    private javax.swing.JLabel jlbObavestenjeOPutniku;
    private javax.swing.JPanel jpnlDodajRezervaciju;
    private javax.swing.JPanel jpnlLet;
    private javax.swing.JPanel jpnlRezervacija;
    private javax.swing.JRadioButton jrbNijePotvrdjena;
    private javax.swing.JRadioButton jrbPotvrdjena;
    private javax.swing.JTable jtblRezervacije;
    private javax.swing.JTextField jtfBrojPasosa;
    private javax.swing.JTextField jtfDatum;
    private javax.swing.JTextField jtfDatumRezervacije;
    private javax.swing.JTextField jtfSatnica;
    private javax.swing.JLabel rbLeta;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxove() {
        try {
            List<Mesto> mesta = Kontroler.getInstance().vratiListuMesta();
            jcbDestinacija.setModel(new DefaultComboBoxModel(mesta.toArray()));

            List<Avion> avioni = Kontroler.getInstance().vratiListuAviona();
            jcbAvion.setModel(new DefaultComboBoxModel(avioni.toArray()));

            List<AvioKompanijaPartner> partneri = Kontroler.getInstance().vratiListuPartnera();
            jcbAvioKompanije.setModel(new DefaultComboBoxModel(partneri.toArray()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private Let kreirajLet() throws Exception {
        Let let = new Let();

        int rb = Integer.parseInt(rbLeta.getText().trim());
        let.setRbLeta(rb);

        Mesto destinacija = (Mesto) jcbDestinacija.getSelectedItem();

        let.setDestinacija(destinacija);
        try {
            AvioKompanijaPartner p = (AvioKompanijaPartner) jcbAvioKompanije.getSelectedItem();
            let.setPartner(p);
        } catch (Exception e) {
            Logger.getLogger(UnosLetova.class.getName()).log(Level.SEVERE, null, e);
        }
        Avion avion = (Avion) jcbAvion.getSelectedItem();
        let.setAvion(avion);

        String sDatum = jtfDatum.getText().trim();
        if (sDatum == null || sDatum.isEmpty()) {
            throw new Exception("Datum nije unet!!!");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            Date dst = sdf.parse(sDatum);
            Date danas = new Date();
            if (dst.before(danas)) {
                throw new Exception("Uneti datum posle danasnjeg datuma!!!");
            }
            let.setDatumPolaska(dst);
        } catch (ParseException e) {
            throw new Exception("Datum unet u pogresnom formatu!!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        String sat = jtfSatnica.getText().trim();
        if (sat == null || sat.isEmpty()) {
            throw new Exception("Sat poletanja nije unet!!!");
        }
        if (sat.length() != 5) {
            throw new Exception("Sat poletanja treba uneti u formatu hh:mm");
        }
        if (sat.charAt(2) != ':') {
            throw new Exception("Sat poletanja treba uneti u formatu hh:mm");
        }
        String hour = sat.substring(0, 2);
        String min = sat.substring(3, 5);
        try {
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(min);
        } catch (NumberFormatException e) {
            throw new Exception("Sate i minute treba uneti u ciframa!!!");
        }
        let.setSat(sat);
        return let;
    }

    private void postaviLabelu() {
        try {
            int brojUBazi;
            Kontroler.getInstance().vratiKolikoImaLetovaUBazi();
            brojUBazi = (int) Kontroler.getInstance().getMapa().get("brojLeta");
            rbLeta.setText(brojUBazi + "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

//    private void postaviLabeluZaIzmene() {
//        rbLeta.setText(let.getRbLeta() + "");
//    }
    private void zabraniIzmene() {
        jcbAvioKompanije.setEnabled(false);
        jcbAvion.setEnabled(false);
        jcbDestinacija.setEnabled(false);
        jtfDatum.setEditable(false);
        jtfSatnica.setEditable(false);
    }

    private void popuniComboBoxoveLetom(Let l) {
        popuniComboBoxove();
        AvioKompanijaPartner partner = let.getPartner();
        jcbAvioKompanije.setSelectedItem(let);
        Avion a = let.getAvion();
        jcbAvion.setSelectedItem(a);
        Mesto m = let.getDestinacija();
        jcbDestinacija.setSelectedItem(m);
        jtfSatnica.setText(l.getSat());
    }

    private void popuniZaPrikaz() {
        try {
            rbLeta.setText(let.getRbLeta() + "");
            jlbObavestenjeOPutniku.setVisible(false);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
            jtfDatum.setText(sdf.format(let.getDatumPolaska()));

            jtfSatnica.setText(let.getSat());

            jtfDatumRezervacije.setText(sdf.format(new Date()));
            jtfDatumRezervacije.setEditable(false);

            List<Avion> avioni = Kontroler.getInstance().vratiListuAviona();
            jcbAvion.setModel(new DefaultComboBoxModel(avioni.toArray()));
            jcbAvion.setSelectedItem(let.getAvion());

            List<AvioKompanijaPartner> partneri = Kontroler.getInstance().vratiListuPartnera();
            jcbAvioKompanije.setModel(new DefaultComboBoxModel(partneri.toArray()));
            jcbAvioKompanije.setSelectedItem(let.getPartner());

            List<Mesto> mesta = Kontroler.getInstance().vratiListuMesta();
            jcbDestinacija.setModel(new DefaultComboBoxModel(mesta.toArray()));
            jcbDestinacija.setSelectedItem(let.getDestinacija());

            jbtnIzmeni.setVisible(false);
            jbtnObrisi.setVisible(false);

            postaviTabelu();
        } catch (Exception ex) {
            Logger.getLogger(UnosLetova.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void popuniComboPutnici() {
        List<Putnik> putnici = Kontroler.getInstance().vratiListuPutnika();
        jcbPutnik.setModel(new DefaultComboBoxModel(putnici.toArray()));
    }

    private void postaviTabelu() throws Exception {
        TblModelRezervacije tmr = null;
        List<Rezervacija> rezervacije = Kontroler.getInstance().vratiRezervacijeZaOvajLet(let);
        if (rezervacije == null || rezervacije.isEmpty()) {
            jlbObavestenje.setVisible(true);
            List<Rezervacija> daSredi = new ArrayList<>();
            tmr = new TblModelRezervacije(daSredi);
        } else {
            tmr = new TblModelRezervacije(rezervacije);
        }
        jtblRezervacije.setModel(tmr);
    }

    private Rezervacija kreirajRezervacija() throws Exception {
        Rezervacija reserve = new Rezervacija();
        reserve.setRbLeta(let);
        Putnik p = (Putnik) jcbPutnik.getSelectedItem();
        reserve.setPutnik(p);
        String dat = jtfDatumRezervacije.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            Date d = sdf.parse(dat);
            reserve.setDatumRezervacije(d);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        if (jrbNijePotvrdjena.isSelected()) {
            reserve.setStatus("nije potvrdjena");
        } else {
            reserve.setStatus("potvrdjena");
        }
        int brojUBazi;
        Kontroler.getInstance().vratiKolikoImaRezervacijaUBazi();
        brojUBazi = (int) Kontroler.getInstance().getMapa().get("brojRezervacije");
        reserve.setBrojRezervacije(brojUBazi);
        Sluzbenik s = (Sluzbenik) Kontroler.getInstance().getMapa().get("ulogovaniSluzbenik");
        reserve.setZapisao(s);
        return reserve;
    }

}
