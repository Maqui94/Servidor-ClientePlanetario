import java.rmi.RemoteException;

public interface PlanetaInferfaceRMI {
    public String buscarPlaneta(String nombre) throws RemoteException;
    public String buscarPorColores(String color) throws RemoteException;
}
