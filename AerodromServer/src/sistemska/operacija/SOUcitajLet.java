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
public class SOUcitajLet extends OpstaSO{

    private OpstiDomenskiObjekat let;

    public OpstiDomenskiObjekat getLet() {
        return let;
    }

    public void setLet(OpstiDomenskiObjekat let) {
        this.let = let;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        try {
            List<OpstiDomenskiObjekat> l = dbb.pronadji(odo);
            if (!l.isEmpty()) {
                let = l.get(0);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception("Sistem ne moze da nadje izabrani let");
        }
    }
    
}
