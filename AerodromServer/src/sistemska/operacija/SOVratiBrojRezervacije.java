/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemska.operacija;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Nevena
 */
public class SOVratiBrojRezervacije extends OpstaSO {

    int brojRezervacija;

    public int getBrojRezervacija() {
        return brojRezervacija;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        brojRezervacija = dbb.izbroj(odo);
    }

}
