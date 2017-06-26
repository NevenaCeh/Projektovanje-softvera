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
public class SOVratiMesta extends OpstaSO{

    private List<OpstiDomenskiObjekat> listaMesta;

    public List<OpstiDomenskiObjekat> getListaMesta() {
        return listaMesta;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        listaMesta = dbb.vratiSve(odo);
    }
    
}
