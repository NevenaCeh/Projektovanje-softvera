/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Nevena
 */
public abstract class OpstiDomenskiObjekat {
    
    protected Map<String, Object> mapa;

    public OpstiDomenskiObjekat() {
        mapa = new HashMap<>();
    }
    
    public abstract String vratiImeKlase();
    
    public abstract String vratiImeTabeleUBazi();

    public String vratiINSERT(){return "";};

    public abstract String vratiPrimarniKljuc();
    
    public String vratiWhereUSELECT(){return "";};

    public abstract List<String> vratiVrednostiZaPretragu();

    public List<OpstiDomenskiObjekat> vratiVezaneObjekte() {
        return null;
    }

    public void postaviListuObjekata(List<OpstiDomenskiObjekat> obj) {
    }

    public String vratiSelect() {
        return "*";
    }

    public String vratiFrom() {
        return "";
    }

    public String vratiOrderBy() {
        return "";
    }

    public String vratiUPDATE(){return "";};

    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        return null;
    }

    public Map<String, Object> vratiMapu() {
        return mapa;
    }
    
    public String vratiWHEREUDELETE(){
        return "";
    }

    public String vratiWHEREUUpdate() {
        return "";
    }

   
        
    
    
    
}
