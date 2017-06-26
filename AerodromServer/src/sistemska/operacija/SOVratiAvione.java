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
public class SOVratiAvione extends OpstaSO{

    List<OpstiDomenskiObjekat> avioni;

    public List<OpstiDomenskiObjekat> getAvioni() {
        return avioni;
    }  
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        avioni = dbb.vratiSve(odo);
    }
    
}
