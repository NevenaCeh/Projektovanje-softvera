/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemska.operacija;

import domen.OpstiDomenskiObjekat;
import domen.Sluzbenik;
import java.util.List;

/**
 *
 * @author Nevena
 */
public class SONadjiSluzbenika extends OpstaSO{
    
    private OpstiDomenskiObjekat sluzbenik;

    public OpstiDomenskiObjekat getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(OpstiDomenskiObjekat sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        List<OpstiDomenskiObjekat> lista;
        try {
            lista = dbb.pronadji(odo);
            if (!lista.isEmpty()) {
                sluzbenik = lista.get(0);
                /*if (((Sluzbenik) korisnik).isOnline()) {
                    throw new Exception("Korisnik je vec ulogovan");
                }*/
            } else {
                throw new Exception("Sistem ne moze da nadje sluzbenika na osnovu unetih vrednosti");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
