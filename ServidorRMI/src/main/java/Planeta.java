public class Planeta {
    private String nombre;
    private String color;
    private String tamaño;
    private double gravedad;
    private String satelite;
    private int posicion;

    public Planeta() {
    }

    public Planeta(String nombre, String color, String tamaño, double gravedad, String satelite, int posicion) {
        this.nombre = nombre;
        this.color = color;
        this.tamaño = tamaño;
        this.gravedad = gravedad;
        this.satelite = satelite;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getSatelite() {
        return satelite;
    }

    public void setSatelite(String satelite) {
        this.satelite = satelite;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", gravedad=" + gravedad +
                ", satelite='" + satelite + '\'' +
                ", posicion=" + posicion +
                '}';
    }
}
