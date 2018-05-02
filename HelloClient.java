package fp07;

/**
 *
 * @author pedro
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.*;
import java.util.ArrayList;


public class HelloClient extends java.rmi.server.UnicastRemoteObject implements
Hello_C_I{
        ArrayList<Produto> Lista;
        Cliente dados;
        
        
    public HelloClient() throws RemoteException {
        super();
        Lista = new ArrayList<Produto>();
        dados = new Cliente();
    }
    //MÃ©todo remoto
    public void printOnClient (String s)throws java.rmi.RemoteException{
    System.out.println ("Message from server: " + s);
    }
  
    
    public static void main (String [] args){
     int x=0;
     Cliente utilizador = new Cliente("xinelos","127.0.0.1",2222);
    System.setSecurityManager(new SecurityManager());
    try {
    Hello_S_I h = (Hello_S_I)Naming.lookup ("ElPedro");
    HelloClient c = new HelloClient();
    h.subscribe( "Piccini Server", (Hello_C_I)c);
    
    System.out.println("1-queres vender \n2-queres comprar");
       while(x>=0 && x<1)
            x = ler.umInt();
       if(x==1)     
            h.registarCliente(utilizador);
       if(x==2) 
           h.Listar("xinelos");
   }
    catch (Exception r){
    System.out.println ( "Exception in client" +r.getMessage());
    }
        
    
    }
}
