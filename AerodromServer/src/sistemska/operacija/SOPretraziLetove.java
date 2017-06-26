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
public class SOPretraziLetove extends OpstaSO{
    
    private String kriterijumPretrage;
    private List<OpstiDomenskiObjekat> listaLetova;

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public List<OpstiDomenskiObjekat> getListaLetova() {
        return listaLetova;
    }

    public void setListaLetova(List<OpstiDomenskiObjekat> listaLetova) {
        this.listaLetova = listaLetova;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception{
        listaLetova = dbb.pretrazi(kriterijumPretrage, odo);
        if (listaLetova.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje letove po zadatoj vrednosti");
        }
    }
    
}
