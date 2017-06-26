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
public class SOKreirajNovuAvioKompanijuPartnera extends OpstaSO{

    private OpstiDomenskiObjekat partner;

    public OpstiDomenskiObjekat getPartner() {
        return partner;
    }

    public void setPartner(OpstiDomenskiObjekat partner) {
        this.partner = partner;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception{
        partner = dbb.unos(odo);
    }
    
}
