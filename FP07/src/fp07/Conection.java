/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aluno
 */
public class Conection extends Thread {
 private Socket S;
 private int cli;
 public Conection ( Socket s ,int n) {
 super();
 S = s;
 cli = n;
 start();
}
 
  public void run () {
 try {
 ObjectOutputStream os = new ObjectOutputStream( S.getOutputStream());

 os.writeObject ( "A data e hora do sistema: " + new java.util.Date() );
 os.flush();
 sleep(3000);
 os.writeObject ( "A data e hora do sistema: " + new java.util.Date() );
 os.flush();
 
 }
 catch ( IOException e) {System.out.println(e.getMessage());} 
 catch (InterruptedException ex) {
     System.out.println(ex.getMessage());     }
 }
  
}


