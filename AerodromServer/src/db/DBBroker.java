/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author Nevena
 */
public class DBBroker {

    private Connection veza;

    public void konektujSe() throws Exception {
        ParametriBaze parametri = Kontroler.getInstance().dajParametre();
        String url = DBKonekcija.getUrl(parametri.getTipBaze(), parametri.getBaza(), parametri.getPort());
        String user = parametri.getUsername();
        String pass = parametri.getPass();
        veza = DriverManager.getConnection(url, user, pass);
        veza.setAutoCommit(false);
    }

    public void potvrdiTransakciju() {
        try {
            veza.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriTransakciju() throws SQLException {
        veza.close();
    }

    public void ponistiTransakciju() {
        try {
            veza.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OpstiDomenskiObjekat unos(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "INSERT INTO " + odo.vratiImeTabeleUBazi() + " VALUES " + odo.vratiINSERT();
        System.out.println(sql);
        Statement st = veza.createStatement();
        st.executeUpdate(sql);
        return odo;
    }

    public void izmena(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "UPDATE "+odo.vratiImeTabeleUBazi()+" SET "+odo.vratiUPDATE()+" WHERE "+odo.vratiWHEREUUpdate();
        System.out.println(sql);
        Statement s = veza.createStatement();
        s.executeUpdate(sql);
        
    }

    public List<OpstiDomenskiObjekat> pretrazi(String kriterijumPretrage, OpstiDomenskiObjekat odo) throws Exception {
        List<OpstiDomenskiObjekat> l = new ArrayList<>();
        String sql = "SELECT " + odo.vratiSelect() + " FROM " + odo.vratiFrom() + " WHERE ";
        List<String> lista = odo.vratiVrednostiZaPretragu();
        for (int i = 0; i < lista.size() - 1; i++) {
            sql += lista.get(i) + " LIKE '" + kriterijumPretrage + "%' OR ";
        }
        sql += lista.get(lista.size() - 1) + " LIKE '" + kriterijumPretrage + "%'";
        System.out.println(sql);
        Statement s = veza.createStatement();
        ResultSet rs = s.executeQuery(sql);
        l = odo.vratiListu(rs);
        return l;
    }

    public List<OpstiDomenskiObjekat> pronadji(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "SELECT " + odo.vratiSelect() + " FROM " + odo.vratiFrom() + " WHERE "+ odo.vratiWhereUSELECT();
        System.out.println(sql);
        Statement s = veza.createStatement();
        ResultSet rs = s.executeQuery(sql);
        return odo.vratiListu(rs);

    }

    public void obrisi(OpstiDomenskiObjekat odo) throws SQLException {
        String sql = "DELETE FROM " + odo.vratiImeTabeleUBazi() + " WHERE " + odo.vratiWHEREUDELETE();
        System.out.println(sql);
        Statement st = veza.createStatement();
        st.executeUpdate(sql);
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        String sql = "select " + odo.vratiSelect() + " from " + odo.vratiFrom() + " " + odo.vratiOrderBy();
        System.out.println(sql);
        Statement st = veza.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return odo.vratiListu(rs);
    }

    public int izbroj(OpstiDomenskiObjekat odo) throws Exception {
        //String sql = "SELECT COUNT(" + odo.vratiPrimarniKljuc() + ") FROM " + odo.vratiImeTabeleUBazi()+" ORDER BY "+odo.vratiPrimarniKljuc();
        String sql = "select " + odo.vratiPrimarniKljuc() + " from " + odo.vratiFrom() + " order by " + odo.vratiPrimarniKljuc();
        System.out.println(sql);
        int broj = 1;
        Statement st = veza.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {            
            broj = rs.getInt(odo.vratiPrimarniKljuc());
            broj++;
        }        
        //rs.next();
        //int broj = rs.getInt(1);
        System.out.println(broj);
        return broj;
    }

}
