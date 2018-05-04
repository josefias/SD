/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author aluno
 */
public class multiServer extends Thread{
    
 private ServerSocket ss;
 private Socket s;
 private Conection c;
 private int cli;
 private int port;
 private AtributosCliente me;
 
 public multiServer(AtributosCliente me, int port){
 super();
 this.port = port;
 this.me = me;
 start();
 } 
 
 
public void run(){
 try
{
 ss = new ServerSocket (port);

} catch ( IOException e){
    e.printStackTrace();
}
 try {
    while (true) {
    cli++;
    s = ss.accept();
    c = new Conection(me,s,cli);
    
    }
 }
 catch (IOException e) {System.out.println(e.getMessage());}
 }
}


