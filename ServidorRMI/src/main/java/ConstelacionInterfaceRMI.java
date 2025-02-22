import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConstelacionInterfaceRMI extends Remote {
    public String buscarConstelacion(String nombre) throws RemoteException;
}
