public class Nodos {
    String tituloPagina;
    String url;
    String horaApertura;
    Nodos siguiente;
    Nodos anterior;

    public Nodos(String tituloPagina, String url, String horaApertura) {
        this.tituloPagina = tituloPagina;
        this.url = url;
        this.horaApertura = horaApertura;
        this.siguiente = null;
        this.anterior = null;
    }

    public void mostrar() {
        System.out.println("----------------------");
        System.out.println("Titulo: " + tituloPagina);
        System.out.println("URL: " + url);
        System.out.println("Hora: " + horaApertura);
        System.out.println("----------------------");
    }
}
