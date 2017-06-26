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
public class SOKreirajNoviLet extends OpstaSO{

    private OpstiDomenskiObjekat let;

    public OpstiDomenskiObjekat getLet() {
        return let;
    }

    public void setLet(OpstiDomenskiObjekat let) {
        this.let = let;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception{
        let = dbb.unos(odo);
    }
    
}
