import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface PlanetaInterfaceRMI {
    public String buscarPlaneta(String nombre) throws RemoteException;
    public String buscarPorColores(String color) throws RemoteException;
}
