package fp07;

/**
 *
 * @author pedro
 */
public interface Hello_S_I extends java.rmi.Remote{
    
    public void Listar(String s,Hello_C_I c)throws java.rmi.RemoteException;
    public void Listar(Hello_C_I c) throws java.rmi.RemoteException;
    public void subscribe (String s, Hello_C_I c) throws java.rmi.RemoteException;
    public void registarCliente(Cliente c) throws java.rmi.RemoteException;
   
}

    
