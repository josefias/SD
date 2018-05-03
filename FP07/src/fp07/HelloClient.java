package fp07;

/**
 *
 * @author pedro
 */

import java.io.*;
import java.rmi.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloClient extends java.rmi.server.UnicastRemoteObject implements
Hello_C_I{
    
        
        
    public HelloClient() throws RemoteException {
        super();
      
    }
    //MÃ©todo remoto
    public void printOnClient (String s)throws java.rmi.RemoteException{
    System.out.println ("Message from server: " + s);
    }
  

    public static void main (String [] args){
     int x=0;
     String dat = ".dat", file ="";
     AtributosCliente cli = new AtributosCliente();
     String Path = "C:\\Users\\Utilizador\\Desktop\\tudo\\UBI\\poo\\FP07\\src\\fp07\\Cliente\\";
      String  nome = "jony", cat = "orticulas", ip = "127.0.0.5", fruta = "girimum"; 
     int tele = 1234, port = 2222 ,preco = 12, stock = 100;    
     
     System.out.println("Qual é o teu Nome?");
     file = ler.umaString();//nome
     String concat = file.concat(dat); //nome.dat
     String concat1 = Path.concat(concat); //C:\\Users\\Utilizador\\Desktop\\tudo\\UBI\\poo\\FP07\\src\\fp07\\nome.dat

     File fc = new File(concat1);
        try {
            fc.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(tesster.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(fc.length()!= 0){
                cli = cli.Ler_Fich(fc);
                System.out.println("o ficheiro tem dados");
            }    
            else{
                cli.genClient();
               // cli.genClient(nome, cat ,ip, fruta, tele, port, preco, stock);
                System.out.println("o ficheiro estava vazio");
                cli.Guardar_No_FicheiroCli(fc, cli);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tesster.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     System.setSecurityManager(new SecurityManager());
    try {
    Hello_S_I h = (Hello_S_I)Naming.lookup ("ElPedro");
    HelloClient c = new HelloClient();
    
    
    h.subscribe( cli.getName(), (Hello_C_I)c);
    
    
       while(x!=4 ){
           
           System.out.println("1-queres vender \n2-queres comprar \n3-Listar todos \n4-exit");
            x = ler.umInt();
       if(x==1)     
            h.registarCliente(cli.dados);
       if(x==2) 
           h.Listar("madeira",(Hello_C_I) c);//todos os metodos que levam callback precisam de receber como parametro (hello_C_I) c
       
        if(x==3) 
           h.Listar((Hello_C_I) c);
       }
    }
    catch (Exception r){
    System.out.println ( "Exception in client" +r.getMessage());
    }
        
    
    }
}
