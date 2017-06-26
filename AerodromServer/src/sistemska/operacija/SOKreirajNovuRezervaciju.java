/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemska.operacija;

import domen.OpstiDomenskiObjekat;
import domen.Rezervacija;
import java.util.List;

/**
 *
 * @author Nevena
 */
public class SOKreirajNovuRezervaciju extends OpstaSO {

    private OpstiDomenskiObjekat rezervacija;

    public OpstiDomenskiObjekat getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(OpstiDomenskiObjekat rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        rezervacija = dbb.unos(odo);

    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        Rezervacija r = (Rezervacija) odo;
        List<OpstiDomenskiObjekat> rez = dbb.pronadji(r);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : rez) {
            Rezervacija rListe = (Rezervacija) opstiDomenskiObjekat;
            if (rListe.getRbLeta().equals(r.getRbLeta()) && rListe.getPutnik().equals(r.getPutnik())) {
                throw new Exception("Sistem ne moze da kreira rezervaciju!!! Ovo je iz SO");
            }
        }
    }

}
