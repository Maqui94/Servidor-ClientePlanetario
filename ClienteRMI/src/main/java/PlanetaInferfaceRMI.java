import java.rmi.RemoteException;

public interface PlanetaInferfaceRMI {
    public String buscarPlaneta(String nombre) throws RemoteException;
    public String buscarPorColores(String color) throws RemoteException;
    public String buscarPorTamaño(String tamaño) throws RemoteException;
    public String compararGravedad(String nombre1, String nombre2) throws RemoteException;
    public String planetaMasCercanoAlSol(String nombre1, String nombre2) throws RemoteException;
    public String devolverSatelite(String nombre) throws RemoteException;
}
