package fp07;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedro
 */

import java.rmi.*;
import java.io.*;
import java.io.File;
import java.util.ArrayList;


public class Catalogo extends java.rmi.server.UnicastRemoteObject{ 
    
       private static File fc = new File("C:\\Users\\pedro\\Desktop\\5º Ano\\2sem\\SD\\Praticas\\TP1\\src\\Cata.dat"); 
       static ArrayList<String> p = new ArrayList<String>();
       static ArrayList<String> pp = new ArrayList<String>();
       static ArrayList<Cliente> cli = new ArrayList<Cliente>();
       
       public static void Guardar_No_Ficheiro(File f, ArrayList<Object> o){
            try{
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(o);
                oos.close();
            }catch(IOException e){e.printStackTrace();}
            
       }
       
       public Catalogo() throws java.rmi.RemoteException{
           super();
       }
       
       public void registarCliente(Cliente c) throws java.rmi.RemoteException{
           cli.add(c);
           
           Guardar_No_Ficheiro(fc,(ArrayList) cli);
       }

       
       
       
       
       public static void main(String [] args) throws ClassNotFoundException{
            
            String s = "bora!";
            p.add(s);
            
            try{
                Guardar_No_Ficheiro(fc,(ArrayList) p);

                FileInputStream fis = new FileInputStream(fc);
                ObjectInputStream ois = new ObjectInputStream(fis);

                pp= (ArrayList) ois.readObject();

                ois.close();
            }catch(IOException e){System.out.println(e.getMessage());}
            
            System.out.println(pp);
       }
        
}
