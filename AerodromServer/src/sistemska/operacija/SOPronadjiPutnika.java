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
public class SOPronadjiPutnika extends OpstaSO{

    private String kriterijumPretrage;
    private OpstiDomenskiObjekat putnik;

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public OpstiDomenskiObjekat getPutnik() {
        return putnik;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        List<OpstiDomenskiObjekat> lista;
        try {
            lista = dbb.pretrazi(kriterijumPretrage, odo);
            if (!lista.isEmpty()) {
                putnik = lista.get(0);
            }else {
                throw new Exception("Sistem ne moze da nadje putnika na osnovu unetih vrednosti");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }
    
}
