/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.ParametriBaze;
import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import gui.ServerGUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import niti.NitServer;
import sistemska.operacija.OpstaSO;
import sistemska.operacija.SOVratiSveSluzbenike;

/**
 *
 * @author Nevena
 */
public class Kontroler {

    private static Kontroler instance;
    public static final String TIP_BAZE = "tipBaze";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NAZIV_BAZE = "nazivBaze";
    public static final String PORT = "port";
    private NitServer server;
    private List<OpstiDomenskiObjekat> onlineSluzbenici;
    private ServerGUI forma;

    private Kontroler() {
        onlineSluzbenici = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public ParametriBaze dajParametre() {
        Properties props = new Properties();
        InputStream is;
        try {
            File f = new File("db.properties");
            is = new FileInputStream(f);
        } catch (Exception e) {
            is = null;
        }
        try {
            if (is == null) {
                is = getClass().getResourceAsStream("db.properties");
            }

            props.load(is);
        } catch (Exception e) {
        }
        String tipBaze = props.getProperty(TIP_BAZE);
        String username = props.getProperty(USERNAME);
        String pass = props.getProperty(PASSWORD);
        String baza = props.getProperty(NAZIV_BAZE);
        String driver = getImeDrivera(tipBaze);
        int port = Integer.parseInt(props.getProperty(PORT));
        return new ParametriBaze(tipBaze, username, pass, baza, driver, port);
    }

    public String getImeDrivera(String tipBaze) {
        Properties props = new Properties();
        InputStream is;
        try {
            File f = new File("driver.properties");
            is = new FileInputStream(f);
        } catch (Exception e) {
            is = null;
        }

        try {
            if (is == null) {
                is = getClass().getResourceAsStream("driver.properties");
            }

            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (tipBaze.contains(" ")) {
            tipBaze = tipBaze.replace(" ", "_");
        }
        return props.getProperty(tipBaze);
    }

    public List<OpstiDomenskiObjekat> vratiKorisnike() throws Exception {
        OpstaSO opsta = new SOVratiSveSluzbenike();
        opsta.izvrsiOperaciju(new Sluzbenik());
        return ((SOVratiSveSluzbenike) opsta).getSluzbenici();
    }

    public void pokreniServer() throws Exception {
        server = new NitServer();
        server.pokreniServer();
    }

    public void zaustaviServer() throws Exception {
        server.zaustaviServer();
        onlineSluzbenici = new ArrayList<>();
        forma.osveziTabelu();
    }

    public void proveriDaLiJeUlogovan(Sluzbenik sl) throws Exception {
        for (OpstiDomenskiObjekat odo : onlineSluzbenici) {
            Sluzbenik s = (Sluzbenik) odo;
            if (s.equals(sl)) {
                throw new Exception("Ovaj korisnik je vec ulogovan!!!");
            }
        }
        onlineSluzbenici.add(sl);
        forma.osveziTabelu();
    }

    public void setForma(ServerGUI aThis) {
        this.forma = aThis;
    }

    public List<OpstiDomenskiObjekat> getOnlineSluzbenici() {
        return onlineSluzbenici;
    }

    public void skloniSluzbenika(Sluzbenik sl) {
        OpstiDomenskiObjekat odo = null;
        for (OpstiDomenskiObjekat od : onlineSluzbenici) {
            Sluzbenik s = (Sluzbenik) od;
            if (s.equals(sl)) {
                odo = od;
            }
        }
        onlineSluzbenici.remove(odo);
        System.out.println("U kontroleru sam");
        forma.osveziTabelu();
    }

    public boolean daLiJeOnline(){
        return server.isOnline();
    }

    
}
