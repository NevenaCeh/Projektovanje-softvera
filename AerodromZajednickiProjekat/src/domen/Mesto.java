/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public class Mesto extends OpstiDomenskiObjekat implements Serializable{
    
    private int mestoId;
    private long ptt;
    private String naziv;

    public int getMestoId() {
        return mestoId;
    }

    public long getPtt() {
        return ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setMestoId(int mestoId) {
        this.mestoId = mestoId;
    }

    public void setPtt(long ptt) {
        this.ptt = ptt;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Mesto() {
    }

    public Mesto(int mestoId, long ptt, String naziv) {
        this.mestoId = mestoId;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeKlase() {
        return "Mesto";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "mesto";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "mestoId";
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();        
        try {
            
            while(rs.next()){
                int id = rs.getInt("mestoId");
                long ptt = rs.getLong("ptt");
                String naziv = rs.getString("naziv");
                Mesto m = new Mesto(id, ptt, naziv);
                lista.add(m);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

//    @Override
//    public String vratiINSERT() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String vratiFrom() {
        return vratiImeTabeleUBazi();
    }

//    @Override
//    public String vratiWhereUSELECT() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.mestoId != other.mestoId) {
            return false;
        }
        return true;
    }
    
    
    
}
