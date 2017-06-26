/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Let;
import domen.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nevena
 */
public class TblModelRezervacije extends AbstractTableModel {

    List<Rezervacija> rezervacije;

    public TblModelRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public int getRowCount() {
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Rezervacija r = rezervacije.get(i);
        switch (i1) {
            case 0:
                return r.getBrojRezervacije();
            case 1:
                return r.getRbLeta().getDestinacija().getNaziv();
            case 2:
                return r.getPutnik().getBrojPasosa();
            case 3:
                return r.getPutnik().getPrezime() + " " + r.getPutnik().getIme();
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                return sdf.format(r.getDatumRezervacije());
            case 5:
                return r.getStatus();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Br rezervacije";
            case 1:
                return "Destinacija";
            case 2:
                return "Broj pasosa";
            case 3:
                return "Putnik";
            case 4:
                return "Datum";
            case 5:
                return "Status";
            default:
                return "N/A";
        }
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }
    
        public Rezervacija getRezervacija(int red) {
        return rezervacije.get(red);
    }   

    public void osveziTabelu() {
        fireTableDataChanged();
    }

}
