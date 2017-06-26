/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import kontroler.Kontroler;

/**
 *
 * @author Nevena
 */
public class DBKonekcija {

    private String username;
    private String password;
    private String url;

    public DBKonekcija() {
        postaviAtribute();
    }

    public static void testirajKonekciju(String tipBaze, String username, String pass, String nazivBaze, int port) throws Exception {
        try {
            String url = getUrl(tipBaze, nazivBaze, port);
            System.out.println(url);
            Class.forName(Kontroler.getInstance().getImeDrivera(tipBaze));
            Connection conn = DriverManager.getConnection(url, username, pass);
            conn.close();
        } catch (ClassNotFoundException ex) {
            throw new Exception("Ne moze da ucita driver: " + ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception("Konekcija je neuspesna: " + ex.getMessage());
        }
    }

    static String getUrl(String tipBaze, String baza, int port) {
        String url = "";
        if (tipBaze.equalsIgnoreCase("mysql")) {
            url = "jdbc:mysql://localhost:" + port + "/" + baza + "?useUnicode=yes&characterEncoding=UTF-8";
        } else if (tipBaze.equalsIgnoreCase("sql server")) {
            url = "jdbc:sqlserver://localhost;database=" + baza + ";";
        } else if (tipBaze.equalsIgnoreCase("oracle")) {
            url = "jdbc:oracle:thin:@localhost:" + port + ":" + baza;
        }
        return url;
    }

    private void postaviAtribute() {
        ParametriBaze pb = Kontroler.getInstance().dajParametre();
        url = DBKonekcija.getUrl(pb.getTipBaze(), pb.getBaza(), pb.getPort());
        username = pb.getUsername();
        password = pb.getPass();
    }

}
