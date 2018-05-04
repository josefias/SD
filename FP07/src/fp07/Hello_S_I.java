
package fp07;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface Hello_S_I extends java.rmi.Remote{
    
    public ArrayList<Cliente> Listar(String s,Hello_C_I c)throws java.rmi.RemoteException;
    public void Listar(Hello_C_I c) throws java.rmi.RemoteException;
    public void subscribe (String s, Hello_C_I c) throws java.rmi.RemoteException;
    public void registarCliente(Cliente c) throws java.rmi.RemoteException;
    public void RemoveCli(Cliente c)throws java.rmi.RemoteException;
   
}

    
