import java.rmi.RemoteException;

public interface ConstelacionInterfaceRMI {
    public String buscarConstelacion(String nombre) throws RemoteException;
}
