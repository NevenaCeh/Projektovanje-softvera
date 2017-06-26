/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemska.operacija;

import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Nevena
 */
public class SOVratiRezervacijeLeta extends OpstaSO {

    private List<OpstiDomenskiObjekat> rezervacijeLeta;

    public List<OpstiDomenskiObjekat> getRezervacijeLeta() {
        return rezervacijeLeta;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        rezervacijeLeta = dbb.pronadji(odo);
    }

}
