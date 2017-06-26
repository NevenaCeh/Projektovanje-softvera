/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import sistemska.operacija.SOVratiRezervacijeLeta;
import domen.AvioKompanijaPartner;
import domen.Avion;
import domen.Let;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Putnik;
import domen.Rezervacija;
import domen.Sluzbenik;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import sistemska.operacija.OpstaSO;
import sistemska.operacija.SOKreirajNoviLet;
import sistemska.operacija.SOKreirajNovuAvioKompanijuPartnera;
import sistemska.operacija.SOKreirajNovuRezervaciju;
import sistemska.operacija.SONadjiSluzbenika;
import sistemska.operacija.SOObrisiLet;
import sistemska.operacija.SOObrisiRezervaciju;
import sistemska.operacija.SOPretraziLetove;
import sistemska.operacija.SOPronadjiPutnika;
import sistemska.operacija.SOUcitajLet;
import sistemska.operacija.SOVratiAvione;
import sistemska.operacija.SOVratiBrojLeta;
import sistemska.operacija.SOVratiBrojRezervacije;
import sistemska.operacija.SOVratiLetove;
import sistemska.operacija.SOVratiMesta;
import sistemska.operacija.SOVratiPartnere;
import sistemska.operacija.SOVratiPutnike;
import sistemska.operacija.SOZapamtiRezervaciju;
import util.Util;

/**
 *
 * @author Nevena
 */
public class NitKlijent extends Thread {

    Socket s;
    private OpstiDomenskiObjekat sluzbenik;

    public NitKlijent(Socket s) {
        this.s = s;
    }

    public Socket getS() {
        return s;
    }

    @Override
    public void run() {
        try {
            boolean kraj = false;
            while (!kraj) {
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();
                int operacija = kto.getOperacija();
                System.out.println("Nalazim se u nit klijent!");
                switch (operacija) {
                    case Util.OPERACIJA_PROVERA_SLUZBENIKA: {
                        System.out.println("radim proveru korisnika");
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SONadjiSluzbenika();
                            so.izvrsiOperaciju((Sluzbenik) kto.getParametar());
                            Sluzbenik sl = (Sluzbenik) ((SONadjiSluzbenika) so).getSluzbenik();
                            Kontroler.getInstance().proveriDaLiJeUlogovan(sl);
                            sluzbenik = sl;
                            sto.setRezultat(sl);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_MESTA: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiMesta();
                            so.izvrsiOperaciju(new Mesto());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> mesta = ((SOVratiMesta) so).getListaMesta();
                            sto.setRezultat(mesta);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                            System.out.println(e.getMessage());
                        }

                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_SACUVAJ_PARTNERA: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            AvioKompanijaPartner partner = (AvioKompanijaPartner) kto.getParametar();
                            OpstaSO so = new SOKreirajNovuAvioKompanijuPartnera();
                            so.izvrsiOperaciju(partner);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Sistem je kreirao partnera!");
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska("Sistem ne moze da kreira novog partnera");
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_BROJ_LETA: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiBrojLeta();
                            so.izvrsiOperaciju(new Let());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            int br = ((SOVratiBrojLeta) so).getBrojLetova();
                            sto.setRezultat(br);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_AVIONE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiAvione();
                            so.izvrsiOperaciju(new Avion());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> avioni = ((SOVratiAvione) so).getAvioni();
                            sto.setRezultat(avioni);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_PARTNERE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiPartnere();
                            so.izvrsiOperaciju(new AvioKompanijaPartner());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> partneri = ((SOVratiPartnere) so).getPartneri();
                            sto.setRezultat(partneri);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_SACUVAJ_LET: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Let let = (Let) kto.getParametar();
                            OpstaSO so = new SOKreirajNoviLet();
                            so.izvrsiOperaciju(let);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Sistem je kreirao let!");
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska("Sistem ne moze da kreira novi let!");
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_LETOVE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiLetove();
                            so.izvrsiOperaciju(new Let());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> letovi = ((SOVratiLetove) so).getLetovi();
                            sto.setRezultat(letovi);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_PRETRAGA_LETOVA: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOPretraziLetove();
                            String text = (String) kto.getParametar();
                            ((SOPretraziLetove) so).setKriterijumPretrage(text);
                            so.izvrsiOperaciju(new Let());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(((SOPretraziLetove) so).getListaLetova());
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_OBRISI_LET: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOObrisiLet();
                            Let let = (Let) kto.getParametar();
                            so.izvrsiOperaciju(let);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_SACUVAJ_PUTNIKA: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Putnik p = (Putnik) kto.getParametar();
                            OpstaSO so = new SOKreirajNovuAvioKompanijuPartnera();
                            so.izvrsiOperaciju(p);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Putnik je uspesno sacuvan!");
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_PUTNIKE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiPutnike();
                            so.izvrsiOperaciju(new Putnik());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> putnici = ((SOVratiPutnike) so).getPutnici();
                            sto.setRezultat(putnici);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_REZERVACIJE_ZA_LET: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Rezervacija r = (Rezervacija) kto.getParametar();
                            OpstaSO so = new SOVratiRezervacijeLeta();
                            so.izvrsiOperaciju(r);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> rezervacije = ((SOVratiRezervacijeLeta) so).getRezervacijeLeta();
                            sto.setRezultat(rezervacije);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.ODJAVA_KORISNIKA: {
                        System.out.println("Primio sam da hoces da se odjavis!");
                        Sluzbenik sl = (Sluzbenik) kto.getParametar();
                        sluzbenik = null;
                        Kontroler.getInstance().skloniSluzbenika(sl);
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        System.out.println("Poslao sam ti odgovor!");
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_BROJ_REZERVACIJE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiBrojRezervacije();
                            so.izvrsiOperaciju(new Rezervacija());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            int br = ((SOVratiBrojRezervacije) so).getBrojRezervacija();
                            sto.setRezultat(br);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_SACUVAJ_REZERVACIJU: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Rezervacija p = (Rezervacija) kto.getParametar();
                            OpstaSO so = new SOKreirajNovuRezervaciju();
                            so.izvrsiOperaciju(p);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Sistem je kreirao rezervaciju!");
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska("Sistem ne moze da kreira novu rezervaciju!");
                        }
                        out.writeObject(sto);
                        break;
                    }
                    /*case Util.OPERACIJA_VRATI_SVE_REZERVACIJE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOVratiSveRezervacije();
                            so.izvrsiOperaciju(new Rezervacija());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            List<OpstiDomenskiObjekat> reserve = ((SOVratiSveRezervacije) so).getRezervacije();
                            sto.setRezultat(reserve);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }*/
                    case Util.OPERACIJA_IZMENA_REZERVACIJE: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Rezervacija r = (Rezervacija) kto.getParametar();
                            OpstaSO so = new SOZapamtiRezervaciju();
                            so.izvrsiOperaciju(r);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_OBRISI_REZERVACIJU: {
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOObrisiRezervaciju();
                            Rezervacija r = (Rezervacija) kto.getParametar();
                            so.izvrsiOperaciju(r);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_VRATI_LET:{
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            Let l = (Let) kto.getParametar();
                            OpstaSO so = new SOUcitajLet();
                            so.izvrsiOperaciju(l);
                            Let zaSlanje = (Let) ((SOUcitajLet) so).getLet();
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(zaSlanje);
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                    case Util.OPERACIJA_PRETRAGA_PUTNIKA:{
                        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                        ServerTransferObjekat sto = new ServerTransferObjekat();
                        try {
                            OpstaSO so = new SOPronadjiPutnika();
                            String text = (String) kto.getParametar();
                            ((SOPronadjiPutnika) so).setKriterijumPretrage(text);
                            so.izvrsiOperaciju(new Putnik());
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(((SOPronadjiPutnika) so).getPutnik());
                        } catch (Exception ex) {
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(ex.getMessage());
                        }
                        out.writeObject(sto);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Greska u runu niti klijent jer "+e.getMessage());
        }
    }

}
