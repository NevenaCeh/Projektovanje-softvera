/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

public class ParametriBaze {

    private String tipBaze;
    private String username;
    private String pass;
    private String baza;
    private String driver;
    private int port;

    public ParametriBaze(String tipBaze, String username, String pass, String baza, String driver, int port) {
        this.tipBaze = tipBaze;
        this.username = username;
        this.pass = pass;
        this.baza = baza;
        this.driver = driver;
        this.port = port;
    }
    

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getTipBaze() {
        return tipBaze;
    }

    public void setTipBaze(String tipBaze) {
        this.tipBaze = tipBaze;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getBaza() {
        return baza;
    }

    public void setBaza(String baza) {
        this.baza = baza;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "ParametriBaze{" + "tipBaze=" + tipBaze + ", username=" + username + ", pass=" + pass + ", baza=" + baza + ", driver=" + driver + ", port=" + port + '}';
    }

}
