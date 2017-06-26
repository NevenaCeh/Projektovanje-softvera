/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Nevena
 */
public class NitServer extends Thread {

    ServerSocket ss;
    JLabel status;
    JButton pokreni;
    JButton zaustavi;
    private List<NitKlijent> klijenti;
    private boolean online;

    public NitServer() {
        klijenti = new ArrayList<>();
        online = false;
    }

    public void pokreniServer() throws Exception {
        online = true;
        ss = new ServerSocket(9010);
        start();
    }

    public void zaustaviServer() throws Exception {
        online = false;
        ss.close();
        for (int i = 0; i < klijenti.size(); i++) {
            klijenti.get(i).getS().close();
        }
        klijenti.clear();
    }

    @Override
    public void run() {
        while (online) {
            try {
                Socket s = ss.accept();
                System.out.println("Klijent se povezao!!!");
                NitKlijent nit = new NitKlijent(s);
                klijenti.add(nit);
                nit.start();
            } catch (SocketException se) {
                System.out.println("Server zaustavljen!");
            } catch (Exception ex) {
                Logger.getLogger(NitServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isOnline() {
        return online;
    }
    
    

}
