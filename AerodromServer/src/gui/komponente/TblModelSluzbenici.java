/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nevena
 */
public class TblModelSluzbenici extends AbstractTableModel{

    List<OpstiDomenskiObjekat> sluzbenici;

    public TblModelSluzbenici(List<OpstiDomenskiObjekat> sluzbenici) {
        this.sluzbenici = sluzbenici;
    }
    
    @Override
    public int getRowCount() {
        return sluzbenici.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        OpstiDomenskiObjekat odo = sluzbenici.get(i);
        Sluzbenik s = (Sluzbenik) odo;
        switch(i1){
            case 0: return s.getSluzbenikId();
            case 1: return s.getIme();
            case 2: return s.getPrezime();
            case 3: return s.getKorisnickoIme();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch(i){
            case 0: return "Id";
            case 1: return "Ime";
            case 2: return "Prezime";
            case 3: return "Username";
            default: return "N/A";
        }
    }

    public void osveziTabelu() {
        fireTableDataChanged();
    }
    
    
    
}
