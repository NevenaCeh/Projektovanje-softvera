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
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public class Sluzbenik extends OpstiDomenskiObjekat implements Serializable {

    private int sluzbenikId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public Sluzbenik() {
    }

    public Sluzbenik(String korisnickoIme, String korisnickaSifra) {
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public Sluzbenik(int sluzbenikId, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.sluzbenikId = sluzbenikId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public int getSluzbenikId() {
        return sluzbenikId;
    }

    public void setSluzbenikId(int sluzbenikId) {
        this.sluzbenikId = sluzbenikId;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiImeKlase() {
        return "Sluzbenik";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "sluzbenik";
    }

//    @Override
//    public String vratiINSERT() {
//        return null;
//    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sluzbenikId";
    }

    @Override
    public String vratiWhereUSELECT() {
        return "korisnickoIme = '"+korisnickoIme+"' and korisnickaSifra = '"+korisnickaSifra+"'";
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
                int id = rs.getInt("sluzbenikId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String us = rs.getString("korisnickoIme");
                String pass = rs.getString("korisnickaSifra");
                Sluzbenik sl = new Sluzbenik(id, ime, prezime, us, pass);
                lista.add(sl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public Map<String, Object> vratiMapu() {
        mapa.put("sluzbenikId", sluzbenikId);
        mapa.put("ime", ime);
        mapa.put("prezime", prezime);
        mapa.put("korisnickoIme", korisnickoIme);
        mapa.put("korisnickaSifra", korisnickaSifra);
        return mapa;
    }

    @Override
    public String vratiFrom() {
        return "sluzbenik";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final Sluzbenik other = (Sluzbenik) obj;
        if (this.sluzbenikId != other.sluzbenikId) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.korisnickaSifra, other.korisnickaSifra)) {
            return false;
        }
        return true;
    }

    
    
}
