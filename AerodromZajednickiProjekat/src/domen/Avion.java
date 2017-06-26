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
public class Avion extends OpstiDomenskiObjekat implements Serializable{
    
    private int sifraAviona;
    private String naziv;

    public Avion() {
    }

    public Avion(int sifraAviona, String naziv) {
        this.sifraAviona = sifraAviona;
        this.naziv = naziv;
    }

    public int getSifraAviona() {
        return sifraAviona;
    }

    public void setSifraAviona(int sifraAviona) {
        this.sifraAviona = sifraAviona;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeKlase() {
        return "Avion";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "avion";
    }

//    @Override
//    public String vratiINSERT() {
//        return "";
//    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sifraAviona";
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("sifraAviona");
                String ime = rs.getString("nazivAviona");
                Avion a = new Avion(id, ime);
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String vratiFrom() {
        return vratiImeTabeleUBazi();
    }

    @Override
    public String vratiWhereUSELECT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        final Avion other = (Avion) obj;
        if (this.sifraAviona != other.sifraAviona) {
            return false;
        }
        return true;
    }
    
    
        
}
