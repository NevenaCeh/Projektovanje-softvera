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
public class SOVratiLetove extends OpstaSO{

    List<OpstiDomenskiObjekat> letovi;

    public List<OpstiDomenskiObjekat> getLetovi() {
        return letovi;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        letovi = dbb.vratiSve(odo);
    }
    
}
