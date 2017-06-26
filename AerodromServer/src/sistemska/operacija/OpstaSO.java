/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemska.operacija;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nevena
 */
public abstract class OpstaSO {

    protected DBBroker dbb;

    public OpstaSO() {
        dbb = new DBBroker();
    }

    public void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        try {
            konektujSe();
            proveriPreduslov(odo);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
            zatvori();
        } catch (Exception ex) {
            ponisti();
            zatvori();
            System.out.println("Greska kod izvrsenja SO" + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

    private void konektujSe() throws Exception {
        dbb.konektujSe();
    }

    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null) {
            throw new Exception("Tip podatka nije odredjen!!!");
        }
    }

    protected abstract void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void potvrdi() throws Exception {
        dbb.potvrdiTransakciju();
    }

    private void zatvori() throws Exception {
        dbb.zatvoriTransakciju();
    }

    private void ponisti() throws Exception {
        dbb.ponistiTransakciju();
    }

}
