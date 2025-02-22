import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServidorRMI {
    public static void main(String[] args) {
        String host;
        int puerto = 5055;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Se ha podido obtener la dirección IP");
        } catch (UnknownHostException e) {
            System.out.println("No se ha podido obtener la dirección IP");
            System.out.println(e.getMessage());
            return;
        }
        try {
            Registry registro = LocateRegistry.createRegistry(puerto);

            ConstelacionesRMI constelaciones = new ConstelacionesRMI();
            PlanetasRMI planetas = new PlanetasRMI();
            registro.rebind("misConstelaciones", constelaciones);
            registro.rebind("misPlanetas", planetas);
            System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
        } catch (RemoteException e) {
            System.out.println("No se ha podido registrar el servicio");
            System.out.println(e.getMessage());
        }
    }
}
