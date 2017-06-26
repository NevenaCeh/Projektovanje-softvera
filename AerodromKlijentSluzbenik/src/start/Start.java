/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import gui.PrijavljivanjeSluzbenika;
import java.net.Socket;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import util.Util;

/**
 *
 * @author Nevena
 */
public class Start {

    public static void main(String[] args) {
        PrijavljivanjeSluzbenika ps = new PrijavljivanjeSluzbenika();
        try {
            Socket ks = new Socket("localhost", 9010);
            Kontroler.getInstance().getMapa().put(Util.MAP_KEY_SOKET, ks);
            ps.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ps, "Server nije pokrenut, ne mozete uci u aplikaciju! Pokusajte ponovo kasnije!");
            System.exit(0);
        }
       
    }
}

