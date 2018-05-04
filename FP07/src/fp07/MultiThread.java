/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;
 import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aluno
 */
public class MultiThread {

   
    private Socket s;
    public MultiThread(String IP, int port){
    try {
    s = new Socket (IP, port);
    
    ObjectInputStream is = new ObjectInputStream( s.getInputStream() );
    System.out.println( is.readObject() );
    
    s.close();
    }//try
     catch ( IOException e)
        { System.out.println(e.getMessage());} 
    catch (ClassNotFoundException ex) 
       { Logger.getLogger(MultiThread.class.getName()).log(Level.SEVERE, null, ex);    }
    
    
 } //construtor

 }//Cliente


