package fp07;/**
 *
 * @author pedro
 */


import java.rmi.*;
import java.io.*;
import java.util.ArrayList;

public class HelloServer extends java.rmi.server.UnicastRemoteObject  implements Hello_S_I{
    private  Hello_C_I client;
    private static File fc = new File("C:\\Users\\Utilizador\\Desktop\\SD\\FP07\\src\\fp07\\Cata.dat"); 
       static ArrayList<String> p = new ArrayList<String>();
       static ArrayList<String> pp = new ArrayList<String>();
       static ArrayList<Cliente> cli = new ArrayList<Cliente>();
    
    public HelloServer() throws java.rmi.RemoteException{
        super();
    }
    //MÃ©todo remoto
    public ArrayList<Cliente> Listar(String s,Hello_C_I c) throws java.rmi.RemoteException{
       int flag = 0;
       client = c;
       ArrayList<Cliente> aux = new ArrayList<Cliente>();
        for (int i = 0; i < cli.size(); i++) {
            if(cli.get(i).getCat().equals(s)){
                aux.add(cli.get(i));
                flag++;
            }
        }
            
        if(flag == 0)    
            client.printOnClient("pedimos desculpa, no hay");
        System.out.println("SERVER: "+ s);
    return aux;
    }
         public void Listar(Hello_C_I c) throws java.rmi.RemoteException{
       int flag = 0;
       client = c; // ho Hello_C_I c recebido como parametro ermito a chamada de callBack para o cliente corrto
       
        for (int i = 0; i < cli.size(); i++) {
          
                client.printOnClient(cli.get(i).toString());
                flag++;
            
        }
            
        if(flag == 0)    
            client.printOnClient("pedimos desculpa, no hay");
    }
   //Metodo remoto 
 
    
    public void subscribe(String s, Hello_C_I c) throws java.rmi.RemoteException{
        System.out.println("Subscribing " + s);
        client = c;
    }
    
    public void RemoveCli(Cliente c) throws java.rmi.RemoteException{
        int flag = 0;
        for (int i = 0; i < cli.size(); i++) {
            if(c.equals(cli.get(i))){
                cli.remove(i);
                flag++;
            }    
        }
    if(flag != 0)
        Guardar_No_Ficheiro(fc,(ArrayList) cli);
    }
    
    
    public static void Ler_Fich(File f) throws ClassNotFoundException{
        try{
                    FileInputStream fis = new FileInputStream(f);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    cli = (ArrayList<Cliente> )ois.readObject();
                    ois.close();
                }catch(IOException e){e.printStackTrace();}
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
        int flag = 0;
        for (int i = 0; i < cli.size(); i++) {
            if(c.getIp().equals(cli.get(i)))
                flag++;
        }
           if(flag == 0){
            cli.add(c);
               System.out.println(c);
               try{
                    FileOutputStream fos = new FileOutputStream(fc);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(cli);
                    oos.close();
                }catch(IOException e){e.printStackTrace();}
       }
    }
    
    
    
    public static void main(String [] args) throws ClassNotFoundException{
        String s;
        System.setSecurityManager(new SecurityManager());
        Ler_Fich(fc);
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