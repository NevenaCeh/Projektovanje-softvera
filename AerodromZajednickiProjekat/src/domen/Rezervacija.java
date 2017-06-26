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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public class Rezervacija extends OpstiDomenskiObjekat implements Serializable {

    private int brojRezervacije;
    private Let rbLeta;
    private Putnik putnik;
    private Date datumRezervacije;
    private String status;
    private Sluzbenik zapisao;

    public Rezervacija() {
    }

    public Rezervacija(Let let) {
        this.rbLeta = let;
    }

    public Rezervacija(int brojRezervacije, Let let, Putnik putnik, Date datumRezervacije, String status, Sluzbenik zapisao) {
        this.brojRezervacije = brojRezervacije;
        this.rbLeta = let;
        this.putnik = putnik;
        this.datumRezervacije = datumRezervacije;
        this.status = status;
        this.zapisao = zapisao;
    }

    public int getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }

    public Let getRbLeta() {
        return rbLeta;
    }

    public void setRbLeta(Let rbLeta) {
        this.rbLeta = rbLeta;
    }

    public Putnik getPutnik() {
        return putnik;
    }

    public void setPutnik(Putnik putnik) {
        this.putnik = putnik;
    }

    public Date getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Date datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sluzbenik getZapisao() {
        return zapisao;
    }

    public void setZapisao(Sluzbenik zapisao) {
        this.zapisao = zapisao;
    }

    @Override
    public String toString() {
        return "Rezervacija za let " + rbLeta + " za putnika " + putnik + " je status " + status;
    }

    @Override
    public String vratiImeKlase() {
        return "Rezervacija";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "rezervacija";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "brojRezervacije";
    }

    @Override
    public String vratiWhereUSELECT() {
        return "l.rbLeta = '" + rbLeta.getRbLeta() + "'";
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        List<String> vr = new ArrayList<>();
        vr.add("r.brojRezervacije");
        vr.add("r.rbLeta");
        vr.add("m.naziv");
        vr.add("p.brojPasosa");
        vr.add("p.ime");
        vr.add("p.prezime");
        vr.add("r.status");
        return vr;
    }

    @Override
    public String vratiUPDATE() {
        return "status = 'potvrdjena'";
    }

    @Override
    public String vratiINSERT() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumRezervacije);
        return "('" + brojRezervacije + "','" + rbLeta.getRbLeta() + "','" + putnik.getBrojPasosa() + "','" + datum + "', '" + status + "','"+zapisao.getSluzbenikId()+"')";
    }

    public Rezervacija(int brojRezervacije, Let rbLeta, Putnik putnik, Date datumRezervacije, String status) {
        this.brojRezervacije = brojRezervacije;
        this.rbLeta = rbLeta;
        this.putnik = putnik;
        this.datumRezervacije = datumRezervacije;
        this.status = status;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> rezervacije = new ArrayList<>();
        System.out.println("U vracam listi sam");
        try {
            while (rs.next()) {
                int brRez = rs.getInt("r.brojRezervacije");
                Date datumRez = rs.getDate("r.datumRezervacije");
                String status = rs.getString("r.status");

                int letId = rs.getInt("r.rbLeta");
                Date datum = rs.getDate("l.datumPolaska");
                String sat = rs.getString("l.sat");
                int idDest = rs.getInt("l.mestoIdDestinacija");
                long pttDest = rs.getLong("m.ptt");
                String nazivDest = rs.getString("m.naziv");
                Mesto dest = new Mesto(idDest, pttDest, nazivDest);

                Let let = new Let(letId, datum, dest, sat);

                String pasos = rs.getString("r.brojPasosa");
                String imePut = rs.getString("p.ime");
                String pre = rs.getString("p.prezime");
                String mat = rs.getString("p.jmbg");
                String mejlPut = rs.getString("p.email");
                String fonPut = rs.getString("p.telefon");
                Putnik p = new Putnik(pasos, imePut, pre, mat, mejlPut, fonPut);

                Rezervacija r = new Rezervacija(brRez, let, p, datumRez, status);
                rezervacije.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Rezervacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervacije;
    }

    @Override
    public String vratiSelect() {
        //  return "r.*, l.*, p.*, m.*";
        //return "r.brojRezervacije, r.datumRezervacije, r.status, r.rbLeta, l.datumPolaska, l.sat, l.mestoIdDestinacija, m.ptt, m.naziv, r.brojPasosa, p.ime, p.prezime, p.jmbg, p.email, p.telefon";
        return "*";
    }

    @Override
    public String vratiFrom() {
        return "rezervacija r JOIN let l ON r.rbLeta = l.rbLeta JOIN mesto m ON l.mestoIdDestinacija = m.mestoId JOIN putnik p ON r.brojPasosa = p.brojPasosa";
    }

    @Override
    public Map<String, Object> vratiMapu() {
        mapa.put("brojRezervacije", brojRezervacije);
        mapa.put("rbLeta", rbLeta.getRbLeta());
        mapa.put("brojPasosa", putnik.getBrojPasosa());
        mapa.put("datumRezervacije", datumRezervacije);
        mapa.put("status", status);
        return mapa;
    }

    public Rezervacija(Let rbLeta, Putnik putnik) {
        this.rbLeta = rbLeta;
        this.putnik = putnik;
    }

    @Override
    public String vratiWHEREUDELETE() {
        return "brojRezervacije = '" + brojRezervacije + "'";
    }

    @Override
    public String vratiWHEREUUpdate() {
        return "brojRezervacije = '" + brojRezervacije + "'";
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Rezervacija other = (Rezervacija) obj;
        if (this.brojRezervacije != other.brojRezervacije) {
            return false;
        }
        if (!Objects.equals(this.rbLeta, other.rbLeta)) {
            return false;
        }
        if (!Objects.equals(this.putnik, other.putnik)) {
            return false;
        }
        if (Objects.equals(this.rbLeta, other.rbLeta) && Objects.equals(this.putnik, other.putnik)) {
            return true;
        }
        return true;
    }

    @Override
    public String vratiOrderBy() {
        return "order by "+vratiPrimarniKljuc();
    }

    
    
}
