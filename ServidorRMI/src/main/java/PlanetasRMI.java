import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PlanetasRMI extends UnicastRemoteObject implements PlanetaInterfaceRMI {
    private static final long serialVersionUID = -4817856459999901797L;
    private ArrayList<Planeta> planetas;

    public PlanetasRMI() throws RemoteException {
        planetas = new ArrayList<Planeta>();
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
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().toUpperCase().contains(nombre)) {
                resultado += planeta + "\n";
            }
        }
        return "Info del planeta: " + resultado;
    }

    @Override
    public String buscarPorColores(String color) throws RemoteException {
        String resultado = "";
        for (Planeta planeta : planetas) {
            if (planeta.getColor().toUpperCase().contains(color)) {
                resultado += planeta.getNombre() + ", ";
            }
        }
        return "Los planetas de color " + color + " son: " +  resultado + "\n";
    }

    @Override
    public String buscarPorTamaño(String tamaño) throws RemoteException {
        String resultado = "";
        for (Planeta planeta : planetas) {
            if (planeta.getTamaño().toUpperCase().contains(tamaño)) {
                resultado += planeta.getNombre() + ", ";
            }
        }
        return "Los planetas de tamaño " + tamaño + " son: " +  resultado + "\n";
    }

    @Override
    public String compararGravedad(String nombre1, String nombre2) throws RemoteException {
        Double gravedad1 = 0.0;
        Double gravedad2 = 0.0;
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().toUpperCase().contains(nombre1)) {
                gravedad1 = planeta.getGravedad();
            }
            if (planeta.getNombre().toUpperCase().contains(nombre2)) {
                gravedad2 = planeta.getGravedad();
            }
        }
        return "El planeta con más gravedad es: " + ((gravedad1 > gravedad2) ? (nombre1 + "\n") : (nombre2 + "\n"));
    }

    @Override
    public String planetaMasCercanoAlSol(String nombre1, String nombre2) throws RemoteException {
        int posicion1 = 0;
        int posicion2 = 0;
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().toUpperCase().contains(nombre1)) {
                posicion1 = planeta.getPosicion();
            }
            if (planeta.getNombre().toUpperCase().contains(nombre2)) {
                posicion2 = planeta.getPosicion();
            }
        }
        return "El planeta que más cerca esta del Sol es: " + (posicion1 < posicion2 ? (nombre1 + "\n") : (nombre2 + "\n"));
    }

    @Override
    public String devolverSatelite(String nombre) throws RemoteException {
        String satelitePrincipal = "";
        for (Planeta planeta : planetas) {
            if (planeta.getNombre().toUpperCase().contains(nombre)) {
                satelitePrincipal += planeta.getSatelite() + "\n";
            }
        }
        return "El satélite del planeta " + nombre + " es: " + satelitePrincipal;
    }
}
