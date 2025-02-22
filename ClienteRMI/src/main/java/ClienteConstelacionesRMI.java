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
            String bplaneta;
            do {
                escribirMenu1();
                opcion = lector.nextLine().toUpperCase();
                switch (opcion) {
                    case "C":
                        escribirMenuC();
                        buscado = lector.nextLine().toUpperCase();
                        System.out.println(constelaciones.buscarConstelacion(buscado));
                        break;
                    case "P":
                        escribirMenuP();
                        buscado = lector.nextLine().toUpperCase();
                        switch (buscado){
                            case "N":
                                System.out.println("Dime el nombre del planeta y te dare toda la información");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println();
                                break;
                            case "C":
                                System.out.println("Dime el color y te dire que planetas hay de ese color");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println();
                                break;
                            case "T":
                                System.out.println("Dime que tamaño, pequeño, mediano o gigante");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println();
                                break;
                            case "Comparador":
                                break;
                            case "Cercania":
                                break;
                            case "S":
                                System.out.println("Dime el planeta y te dire su satelite(si lo++ tiene)");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                        break;
                    case "FIN":
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
        System.out.println("Bienvenido al Planetario, sobre que necesita información");
        System.out.println("--------------------------");
        System.out.println("C para Constelaciones");
        System.out.println("P de Planetas");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
    private static void escribirMenuP() {
        System.out.println();
        System.out.println("Búsqueda sobre planetas");
        System.out.println("--------------------------");
        System.out.println("N = Nombre");
        System.out.println("C = Color");
        System.out.println("T = Tamaño");
        System.out.println("Comparador = Comparador gravedad");
        System.out.println("Cercania = Cual esta más cerca del sol");
        System.out.println("S = Satelite principal");
        System.out.println("--------------------------");
        System.out.println("¿Qué opción eliges?");
    }
    private static void escribirMenuC() {
        System.out.println();
        System.out.println("Búsqueda de Constelaciones");
        System.out.println("Escribe el nombre de la constelación que necesitas información");
    }
}

