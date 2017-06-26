/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public class Let extends OpstiDomenskiObjekat implements Serializable {

    private int rbLeta;
    private Date datumPolaska;
    private Mesto destinacija;
    private AvioKompanijaPartner partner;
    private Avion avion;
    private String sat;

    public Let() {
    }

    public Let(int rbLeta, Date datumPolaska, Mesto destinacija, String sat) {
        this.rbLeta = rbLeta;
        this.datumPolaska = datumPolaska;
        this.destinacija = destinacija;
        this.sat = sat;
    }
    
    

    public Let(int rbLeta, Date datumPolaska, Mesto destinacija, AvioKompanijaPartner partner, Avion avion, String sat) {
        this.rbLeta = rbLeta;
        this.datumPolaska = datumPolaska;
        this.destinacija = destinacija;
        this.partner = partner;
        this.avion = avion;
        this.sat = sat;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public int getRbLeta() {
        return rbLeta;
    }

    public void setRbLeta(int rbLeta) {
        this.rbLeta = rbLeta;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Mesto getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(Mesto destinacija) {
        this.destinacija = destinacija;
    }

    public AvioKompanijaPartner getPartner() {
        return partner;
    }

    public void setPartner(AvioKompanijaPartner partner) {
        this.partner = partner;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Let broj " + rbLeta + " " + datumPolaska + " za " + destinacija + " prevozi " + partner + " " + avion;
    }

    @Override
    public String vratiImeKlase() {
        return "Let";
    }

    @Override
    public String vratiFrom() {
        return "let l join mesto d on l.mestoIdDestinacija = d.mestoId join partner p on l.sifraAVK = p.sifraAVK join avion a on l.sifraAviona = a.sifraAviona";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "let";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "rbLeta";
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        List<String> vr = new ArrayList<>();
        vr.add("rbLeta");
        vr.add("naziv");
        vr.add("nazivAVK");
        vr.add("nazivAviona");
        vr.add("sat");
        return vr;
    }

    @Override
    public String vratiINSERT() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumPolaska);
        String maticniBroj;

        return "(" + "'" + rbLeta + "'," + "'" + datum + "','" + destinacija.getMestoId() + "','" + partner.getSifraAVK() + "','" + avion.getSifraAviona() + "','" + sat + "'" + ")";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("rbLeta");
                Date datum = rs.getDate("datumPolaska");
                String sat = rs.getString("sat");
                
                int idDest = rs.getInt("mestoIdDestinacija");
                long pttDest = rs.getLong("ptt");
                String nazivDest = rs.getString("naziv");
                Mesto dest = new Mesto(idDest, pttDest, nazivDest);
                
                int sifraAVK = rs.getInt("sifraAVK");
                String ime = rs.getString("nazivAVK");
                String zr = rs.getString("ziroRacun");
                Date dat = rs.getDate("datumSklapanjaPartnerstva");
                String mejl = rs.getString("email");
                String fon = rs.getString("telefon");
                String ul = rs.getString("ulica");
                String br = rs.getString("broj");
                int mId = rs.getInt("mestoId");
                long ptt = rs.getLong("ptt");
                String naz = rs.getString("naziv");
                Mesto m = new Mesto(mId, ptt, naz);
                AvioKompanijaPartner avk = new AvioKompanijaPartner(sifraAVK, ime, zr, dat, mejl, fon, ul, br, m);
                
                int idAviona = rs.getInt("sifraAviona");
                String imeAviona = rs.getString("nazivAviona");
                Avion a = new Avion(idAviona, imeAviona);
                
                Let let = new Let(id, datum, dest, avk, a, sat);
                        
                lista.add(let);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String vratiWHEREUDELETE() {
        return "rbLeta = '"+rbLeta+"'";
    }

    @Override
    public Map<String, Object> vratiMapu() {
        mapa.put("rbLeta", rbLeta);
        return mapa;
    }

    @Override
    public String vratiWhereUSELECT() {
        return "l.rbLeta = "+rbLeta;
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
        final Let other = (Let) obj;
        if (this.rbLeta != other.rbLeta) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiOrderBy() {
        return "order by "+vratiPrimarniKljuc()+" DESC";
    }

    
    
}
