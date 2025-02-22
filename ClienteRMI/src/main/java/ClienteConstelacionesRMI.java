import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class ClienteConstelacionesRMI {
    public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
        try {
            registry = LocateRegistry.getRegistry("localhost", 5055);
            System.out.println("Hemos obtenido el registro");

            ConstelacionInterfaceRMI constelaciones = (ConstelacionInterfaceRMI) registry.lookup("miConstelaciones");
            PlanetaInferfaceRMI planetas = (PlanetaInferfaceRMI) registry.lookup("miPlanetas");
            System.out.println("Hemos obtenidos los objetos remotos");
            System.out.println();
            String buscado;
            String opcion;
            do {
                escribirMenu();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "T":
                        System.out.println("Escribe nombre de la constelación: ");
                        buscado = lector.nextLine();
                        System.out.println(constelaciones.buscarConstelacion(buscado));
                        break;
                    case "B":
                        System.out.println("Escribe nombre banda: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarBanda(buscado));
                        break;
                    case "A":
                        System.out.println("Escribe nombre álbum: ");
                        buscado = lector.nextLine();
                        System.out.println(canciones.buscarAlbum(buscado));
                        break;
                    case "P":
                        System.out.println("Escribe año de producción: ");
                        buscado = lector.nextLine();
                        int a = Integer.parseInt(buscado);
                        System.out.println(canciones.buscarProducido(a));
                        break;
                    case "F":
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("F"));
        } catch (RemoteException | NotBoundException e) {
            System.out.println(e.getMessage());
        }
        lector.close();
    }
    private static void escribirMenu1() {
        System.out.println();
        System.out.println("Búsqueda de canciones");
        System.out.println("--------------------------");
        System.out.println("T = Título");
        System.out.println("B = Banda");
        System.out.println("A = Álbum");
        System.out.println("P = Año producción");
        System.out.println("F = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
    private static void escribirMenu2() {
        System.out.println();
        System.out.println("Búsqueda de canciones");
        System.out.println("--------------------------");
        System.out.println("T = Título");
        System.out.println("B = Banda");
        System.out.println("A = Álbum");
        System.out.println("P = Año producción");
        System.out.println("F = Terminar programa");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
}
//Bienvenida al Planetario
//Formatear 1 menu para elegir Planetas o constelaciones
//La busqueda que deseas reaalizar para cada uno
