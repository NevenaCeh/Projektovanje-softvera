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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public class Putnik extends OpstiDomenskiObjekat implements Serializable{
    
    private String brojPasosa;
    private String ime;
    private String prezime;
    private String jmbg;
    private String email;
    private String telefon;

    public Putnik() {
    }

    public Putnik(String brojPasosa, String ime, String prezime, String jmbg, String email, String telefon) {
        this.brojPasosa = brojPasosa;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.email = email;
        this.telefon = telefon;
    }

    public String getBrojPasosa() {
        return brojPasosa;
    }

    public void setBrojPasosa(String brojPasosa) {
        this.brojPasosa = brojPasosa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " "+brojPasosa;
    }

    @Override
    public String vratiImeKlase() {
        return "Putnik";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "putnik";
    }

    @Override
    public String vratiPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        List<String> vr = new ArrayList<>();
        vr.add("brojPasosa");
        return vr;
    }

    @Override
    public String vratiINSERT() {
        return "('"+brojPasosa+"','"+ime+"','"+prezime+"','"+jmbg+"','"+email+"','"+telefon+"')";
    }

    @Override
    public String vratiFrom() {
        return vratiImeTabeleUBazi();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                String pasos = rs.getString("brojPasosa");
                String ime = rs.getString("ime");
                String pre = rs.getString("prezime");
                String mat = rs.getString("jmbg");
                String mejl = rs.getString("email");
                String fon = rs.getString("telefon");
                Putnik p = new Putnik(pasos, ime, pre, mat, mejl, fon);
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
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
        final Putnik other = (Putnik) obj;
        if (!Objects.equals(this.brojPasosa, other.brojPasosa)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
