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
public class SOObrisiLet extends OpstaSO{

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        try {
            dbb.obrisi(odo);
        } catch (Exception e) {
            throw new Exception("Sistem ne moze da obrise let");
        }
    }
    
}
