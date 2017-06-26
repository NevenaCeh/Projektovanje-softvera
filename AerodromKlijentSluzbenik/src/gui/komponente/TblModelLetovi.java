/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;
import domen.Let;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.text.*;

/**
 *
 * @author Nevena
 */
public class TblModelLetovi extends AbstractTableModel{

    List<Let> letovi;

    public TblModelLetovi(List<Let> letovi) {
        this.letovi = letovi;
    }
    
    
    @Override
    public int getRowCount() {
        return letovi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Let let = letovi.get(i);
        switch(i1){
            case 0: return let.getPartner();
            case 1: return let.getDestinacija();
            case 2:  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                     String zaVracanje = sdf.format(let.getDatumPolaska());
                return zaVracanje;
            case 3: return let.getSat();
            case 4: return let.getAvion();
                default: return "That's all folks ;)";
        }
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0: return "Organizuje";
            case 1: return "Destinacija";
            case 2: return "Datum polaska";
            case 3: return "Sat";
            case 4: return "Avion";
            default: return "That's all folks ;)";
        }
    }

    public void setListaLetova(List<Let> ll) {
        this.letovi = ll;
        fireTableDataChanged();
    
    }

    public Let getLet(int red) {
        return letovi.get(red);
    }   

    public void osveziTabelu() {
        fireTableDataChanged();
    }
    
    
}
