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
public class SOVratiSveSluzbenike extends OpstaSO{
    
    List<OpstiDomenskiObjekat> sluzbenici;

    public List<OpstiDomenskiObjekat> getSluzbenici() {
        return sluzbenici;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        sluzbenici = dbb.vratiSve(odo);
    }
 
    
    
}
