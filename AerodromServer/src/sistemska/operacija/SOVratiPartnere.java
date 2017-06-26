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
public class SOVratiPartnere extends OpstaSO{
    
    List<OpstiDomenskiObjekat> partneri;

    public List<OpstiDomenskiObjekat> getPartneri() {
        return partneri;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        partneri = dbb.vratiSve(odo);
    }
    
}
