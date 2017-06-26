/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Nevena
 */
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvioKompanijaPartner extends OpstiDomenskiObjekat implements Serializable{

    private int sifraAVK;
    private String naziv;
    private String ziroRacun;
    private Date datumSklapanjaPartnerstva;
    private String email;
    private String telefon;
    private String ulica;
    private String broj;
    private Mesto mesto;

    public AvioKompanijaPartner(int sifraAVK, String naziv, String ziroRacun, Date datumSklapanjaPartnerstva, String email, String telefon, String ulica, String broj) {
        this.sifraAVK = sifraAVK;
        this.naziv = naziv;
        this.ziroRacun = ziroRacun;
        this.datumSklapanjaPartnerstva = datumSklapanjaPartnerstva;
        this.email = email;
        this.telefon = telefon;
        this.ulica = ulica;
        this.broj = broj;
    }
    
    public int getSifraAVK() {
        return sifraAVK;
    }

    public void setSifraAVK(int sifraAVK) {
        this.sifraAVK = sifraAVK;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public Date getDatumSklapanjaPartnerstva() {
        return datumSklapanjaPartnerstva;
    }

    public void setDatumSklapanjaPartnerstva(Date datumSklapanjaPartnerstva) {
        this.datumSklapanjaPartnerstva = datumSklapanjaPartnerstva;
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

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public AvioKompanijaPartner() {
    }

    public AvioKompanijaPartner(int sifraAVK, String naziv, String ziroRacun, Date datumSklapanjaPartnerstva, String email, String telefon, String ulica, String broj, Mesto mesto) {
        this.sifraAVK = sifraAVK;
        this.naziv = naziv;
        this.ziroRacun = ziroRacun;
        this.datumSklapanjaPartnerstva = datumSklapanjaPartnerstva;
        this.email = email;
        this.telefon = telefon;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeKlase() {
        return "AvioKompanijaPartner";
    }

    @Override
    public String vratiImeTabeleUBazi() {
        return "partner";
    }

    @Override
    public String vratiINSERT() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumSklapanjaPartnerstva);
        String maticniBroj;
        
        return "("+"'"+sifraAVK+"',"+"'"+naziv+"','"+ziroRacun+"','"+
                datum+"','"+email+"','"+telefon+"','"+ulica+"','"+broj+"','"+getMesto().getMestoId()+"'"+")";
//                +"','"+getUlicaSediste()+"','"+
//                getBrojSediste()+"'"+")";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "sifraAVK";
    }

    @Override
    public List<String> vratiVrednostiZaPretragu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("sifraAVK");
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
                AvioKompanijaPartner avk = new AvioKompanijaPartner(id, ime, zr, dat, mejl, fon, ul, br, m);
                lista.add(avk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(lista.get(0));
        return lista;
    }

    @Override
    public String vratiFrom() {
        return "partner p join mesto m on p.mestoId = m.mestoId";
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
        final AvioKompanijaPartner other = (AvioKompanijaPartner) obj;
        if (this.sifraAVK != other.sifraAVK) {
            return false;
        }
        return true;
    }
    
    
    

}
