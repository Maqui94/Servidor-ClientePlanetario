public class Constelacion {
    private String nombre;
    private String observaciones;
    public Constelacion() {}

    public Constelacion(String nombre, String observaciones) {
        this.nombre = nombre;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Constelacion{" +
                "nombre='" + nombre + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}