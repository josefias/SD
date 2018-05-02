package fp07;/**
 *
 * @author pedro
 */


import java.rmi.*;
import java.io.*;
import java.util.ArrayList;

public class HelloServer extends java.rmi.server.UnicastRemoteObject
 implements Hello_S_I{
    private static Hello_C_I client;
    private static File fc = new File("C:\\Users\\Utilizador\\Desktop\\tudo\\UBI\\poo\\FP07\\src\\fp07\\Cata.dat"); 
       static ArrayList<String> p = new ArrayList<String>();
       static ArrayList<String> pp = new ArrayList<String>();
       static ArrayList<Cliente> cli = new ArrayList<Cliente>();
    
    public HelloServer() throws java.rmi.RemoteException{
        super();
    }
    //MÃ©todo remoto
    public void Listar(String s) throws java.rmi.RemoteException{
       int flag = 0;
        for (int i = 0; i < cli.size(); i++) {
            if(cli.get(i).getCat().equals(s)){
                client.printOnClient(cli.get(i).toString());
                flag++;
            }
        }
            
        if(flag == 0)    
            client.printOnClient("pedimos desculpa, no hay");
        System.out.println("SERVER: "+ s);
    }
     
   //Metodo remoto 
 
    
    public void subscribe(String s, Hello_C_I c) throws java.rmi.RemoteException{
        System.out.println("Subscribing " + s);
        client = c;
    }
    
    public static void Guardar_No_Ficheiro(File f, ArrayList<Object> o){
            try{
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(o);
                oos.close();
            }catch(IOException e){e.printStackTrace();}
            
       }
    
    
    public void registarCliente(Cliente c) throws java.rmi.RemoteException{
           cli.add(c);
           System.out.println(c);
           try{
                FileOutputStream fos = new FileOutputStream(fc);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(cli);
                oos.close();
            }catch(IOException e){e.printStackTrace();}
       }
    
    
    
    
    public static void main(String [] args){
        String s;
        System.setSecurityManager(new SecurityManager());
    
    try{
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        System.out.println("RMI registry ready");
    }catch(Exception e){
         System.out.println("Exception starting RMI registry:");
         e.printStackTrace();
    }
    
    try {
        HelloServer h = new HelloServer();
        Naming.rebind ("ElPedro",h);
//        while (true){
//        System.out.println("Mensagem para o cliente:");
//        s= lerString();
//        client.printOnClient(s);
//        }
        }catch (RemoteException r){
        System.out.println("Exception in server"+r.getMessage());
        }
        catch (java.net.MalformedURLException u){
        System.out.println("Exception in server - URL" );
        }
//        
//         try{
//                //Guardar_No_Ficheiro(fc,(ArrayList) p);
//
//                FileInputStream fis = new FileInputStream(fc);
//                ObjectInputStream ois = new ObjectInputStream(fis);
//
//                //cli= (ArrayList) ois.readObject();
//
//                ois.close();
//            }catch(IOException e){System.out.println(e.getMessage());}

    
    }



}   