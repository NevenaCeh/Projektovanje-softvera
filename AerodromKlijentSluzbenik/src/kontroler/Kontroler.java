/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AvioKompanijaPartner;
import domen.Avion;
import domen.Let;
import domen.Mesto;
import domen.Putnik;
import domen.Rezervacija;
import domen.Sluzbenik;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import gui.PocetnaUlogovana;
import gui.PrijavljivanjeSluzbenika;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.Util;

public class Kontroler {

    private static Kontroler instance;
    private Map<String, Object> mapa;
    public List<Rezervacija> pretraziRezervacijetext;

    private Kontroler() {
        mapa = new HashMap<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<Mesto> vratiListuMesta() throws Exception {
        List<Mesto> lista = null;
        try {
            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_MESTA);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Mesto>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
        return lista;
    }

    public Map<String, Object> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, Object> mapa) {
        this.mapa = mapa;
    }

    public void prijaviKorisnika(String usn, String lozinka, PrijavljivanjeSluzbenika forma) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_PROVERA_SLUZBENIKA);
            kto.setParametar(new Sluzbenik(usn, lozinka));
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
            Sluzbenik sl = (Sluzbenik) sto.getRezultat();
            mapa.put("ulogovaniSluzbenik", sl);
            mapa.put("loginForma", forma);
            PocetnaUlogovana pocetnaUlogovana = new PocetnaUlogovana();
            forma.setVisible(false);
            pocetnaUlogovana.setVisible(true);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }

    }

    public void unesiPartneraUBazu(AvioKompanijaPartner partner) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_SACUVAJ_PARTNERA);
            kto.setParametar(partner);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("sacuvanPartner", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public void vratiKolikoImaLetovaUBazi() throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_BROJ_LETA);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int broj = (int) sto.getRezultat();
            mapa.put("brojLeta", broj);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<Avion> vratiListuAviona() {
        List<Avion> lista = null;
        try {

            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_AVIONE);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Avion>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
        }
        return lista;
    }

    public List<AvioKompanijaPartner> vratiListuPartnera() {
        List<AvioKompanijaPartner> lista = null;
        try {
            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_PARTNERE);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<AvioKompanijaPartner>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
        }
        return lista;
    }

    public void sacuvajLet(Let let) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_SACUVAJ_LET);
            kto.setParametar(let);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("sacuvanLet", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<Let> vratiLetoveIzBaze() {
        List<Let> lista = null;
        try {

            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_LETOVE);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Let>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
        }
        return lista;
    }

    public List<Let> pretraziLetove(String text) throws Exception {
        List<Let> letovi = new ArrayList<>();
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_PRETRAGA_LETOVA);
            kto.setParametar(text);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();

            letovi = (List<Let>) sto.getRezultat();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return letovi;
    }

    public void obrisiLet(Let let) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_OBRISI_LET);
            kto.setParametar(let);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("statusObrisanogLeta", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public void sacuvajPutnika(Putnik putnik) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_SACUVAJ_PUTNIKA);
            kto.setParametar(putnik);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("sacuvanPutnik", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public List<Putnik> vratiListuPutnika() {
        List<Putnik> lista = null;
        try {
            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_PUTNIKE);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Putnik>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
        }
        return lista;
    }

    public List<Rezervacija> vratiRezervacijeZaOvajLet(Let l) throws Exception {
        List<Rezervacija> lista = null;
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_REZERVACIJE_ZA_LET);
            Rezervacija r = new Rezervacija(l);
            kto.setParametar(r);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Rezervacija>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
        return lista;
    }

    public void odjava() {
        PrijavljivanjeSluzbenika pocetna = (PrijavljivanjeSluzbenika) mapa.get("loginForma");
        Sluzbenik sl = (Sluzbenik) mapa.get("ulogovaniSluzbenik");
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.ODJAVA_KORISNIKA);
            kto.setParametar(sl);

            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.remove("ulogovaniSluzbenik");
            pocetna.setVisible(true);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void vratiKolikoImaRezervacijaUBazi() throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_BROJ_REZERVACIJE);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int broj = (int) sto.getRezultat();
            mapa.put("brojRezervacije", broj);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public void sacuvajRezervaciju(Rezervacija reserve) throws Exception {
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_SACUVAJ_REZERVACIJU);
            kto.setParametar(reserve);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("sacuvanaRezervacija", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

   /* public List<Rezervacija> vratiRezervacije() {
        List<Rezervacija> lista = null;
        try {
            Socket soket = (Socket) getMapa().get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_VRATI_SVE_REZERVACIJE);

            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(kto);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            lista = (List<Rezervacija>) sto.getRezultat();
        } catch (Exception ex) {
            System.out.println("Greska " + ex.getMessage());
        }
        return lista;
    }*/

    public List<Rezervacija> pretraziRezervacije(String text) throws Exception {
        List<Rezervacija> trazene = new ArrayList<>();
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_PRETRAGA_REZERVACIJA);
            kto.setParametar(text);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();

            trazene = (List<Rezervacija>) sto.getRezultat();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return trazene;
    }

    public void obrisiRezervaciju(Rezervacija r) throws Exception {
        //statusObrisaneRez
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_OBRISI_REZERVACIJU);
            kto.setParametar(r);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("statusObrisaneRez", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }

    }

    public void izmeniRezervaciju(Rezervacija r) throws Exception {
        //statusIzmene
        try {
            Socket soket = (Socket) getMapa().get(util.Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(soket.getOutputStream());

            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_IZMENA_REZERVACIJE);
            kto.setParametar(r);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            mapa.put("statusIzmene", sto);
        } catch (Exception ex) {
            System.out.println("Greska: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    public Let vratiLet(Let let) throws Exception {
        Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
        KlijentTransferObjekat kto = new KlijentTransferObjekat();
        kto.setOperacija(Util.OPERACIJA_VRATI_LET);
        kto.setParametar(let);
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(kto);

        ObjectInputStream in = new ObjectInputStream(s.getInputStream());
        ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
        let = (Let) sto.getRezultat();
        return let;
    }

    public Putnik pronadjiPutnika(String text) throws Exception {
        Putnik p = null;
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OPERACIJA_PRETRAGA_PUTNIKA);
            kto.setParametar(text);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();

            p = (Putnik) sto.getRezultat();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return p;
    }

}
