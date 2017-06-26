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
public class SOSacuvajPutnika extends OpstaSO {

    private OpstiDomenskiObjekat putnik;

    public OpstiDomenskiObjekat getPutnik() {
        return putnik;
    }

    public void setPutnik(OpstiDomenskiObjekat putnik) {
        this.putnik = putnik;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        putnik = dbb.unos(odo);
    }

}
