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
public class SOVratiBrojLeta extends OpstaSO{

    int brojLetova;

    public int getBrojLetova() {
        return brojLetova;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        brojLetova = dbb.izbroj(odo);
    }

    
}
