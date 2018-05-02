package fp07;

import java.io.Serializable;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedro
 */
public class Cliente implements Serializable   {
    
    public String cat;
    public String ip;
    public int port;
    
    public Cliente(){
        cat = "";
        ip = "";
        port = 0;
    }
    public Cliente(String categoria, String IP, int port){
        this.cat = categoria;
        this.ip = IP;
        this.port = port;
    }

    public String getCat() {
        return cat;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cat=" + cat + ", ip=" + ip + ", port=" + port + '}';
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cat, other.cat)) {
            return false;
        }
        return true;
    }
    
    
}
