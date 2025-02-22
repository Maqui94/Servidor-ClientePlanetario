import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PlanetasRMI extends UnicastRemoteObject implements PlanetaInterfaceRMI {
    private static final long serialVersionUID = -4817856459999901797L;
    private ArrayList<Planeta> planetas;

    public PlanetasRMI() throws RemoteException {
        planetas.add(new Planeta("Mercurio", "Gris", "Pequeño", 3.7, "Ninguno", 1));
        planetas.add(new Planeta("Venus", "Amarillo", "Mediano", 8.87 , "Ninguno", 2));
        planetas.add(new Planeta("Tierra", "Azul", "Mediano", 9.81, "Luna", 3));
        planetas.add(new Planeta("Marte", "Rojo", "Mediano", 3.71, "Fobos", 4));
        planetas.add(new Planeta("Júpiter", "Marrón y Beige", "Gigante", 24.79, "Ganímedes", 5));
        planetas.add(new Planeta("Saturno", "Dorado", "Gigante", 10.44, "Titán", 6));
        planetas.add(new Planeta("Urano", "Azul Verdoso", "Gigante", 8.69, "Titania", 7));
        planetas.add(new Planeta("Neptuno", "Azul", "Gigante", 11.15, "Tritón", 8));
    }
    @Override
    public String buscarPlaneta(String nombre) throws RemoteException {
        String resultado = "";
        for (Planeta c : planetas) {
            if (c.getNombre().contains(nombre)) {
                resultado = resultado + c + "\n";
            }
        }
        return "El planeta "+ nombre+ " "+  resultado;
    }

    @Override
    public String buscarPorColores(String color) throws RemoteException {
        return "";
    }
    //Formatear par que quede bonito
    //Buscar por colores, y me da solo los nombres.
    //Buscar por tamaño, me da los nombres.
    //Comparar Gravedades entre un planeta y o tro.
    //Cual esta mas cerca del sol.
    //Cual es el satelite principal del planeta X
}
