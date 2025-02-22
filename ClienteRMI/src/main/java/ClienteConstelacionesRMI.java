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
            registry = LocateRegistry.getRegistry("192.168.1.138", 5055);
            System.out.println("Hemos obtenido el registro");

            ConstelacionInterfaceRMI constelaciones = (ConstelacionInterfaceRMI) registry.lookup("misConstelaciones");
            PlanetaInferfaceRMI planetas = (PlanetaInferfaceRMI) registry.lookup("misPlanetas");
            System.out.println("Hemos obtenidos los objetos remotos");
            System.out.println();
            String buscado;
            String opcion;
            String bplaneta;
            String bplaneta2;
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
                                System.out.println(planetas.buscarPlaneta(bplaneta));
                                break;
                            case "C":
                                System.out.println("Dime el color y te dire que planetas hay de ese color");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println(planetas.buscarPorColores(bplaneta));
                                break;
                            case "T":
                                System.out.println("Dime que tamaño, pequeño, mediano o gigante");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println(planetas.buscarPorTamaño(bplaneta));
                                break;
                            case "Comparador":
                                System.out.println("Dime 2 planetas y te dire cual tiene más gravedad, dime el primero");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println("Y el segundo planeta");
                                bplaneta2=lector.nextLine().toUpperCase();
                                System.out.println(planetas.compararGravedad(bplaneta,bplaneta2));
                                break;
                            case "Cercania":
                                System.out.println("Dime 2 planetas y te dire cual esta más cerca del sol, dime el primero");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println("Y el segundo planeta");
                                bplaneta2=lector.nextLine().toUpperCase();
                                System.out.println(planetas.planetaMasCercanoAlSol(bplaneta,bplaneta2));
                                break;
                            case "S":
                                System.out.println("Dime el planeta y te dire su satelite(si lo++ tiene)");
                                bplaneta=lector.nextLine().toUpperCase();
                                System.out.println(planetas.devolverSatelite(bplaneta));
                                break;
                            default:
                                System.out.println("Opción incorrecta");
                        }
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                }
            } while (!opcion.equals("FIN"));
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

