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
public class SOVratiPutnike extends OpstaSO{

    List<OpstiDomenskiObjekat> putnici;

    public List<OpstiDomenskiObjekat> getPutnici() {
        return putnici;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        putnici = dbb.vratiSve(odo);
    }
    
}
