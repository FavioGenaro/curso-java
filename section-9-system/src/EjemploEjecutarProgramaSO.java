
public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {

        Runtime rt = java.lang.Runtime.getRuntime(); // objeto Runtime
        java.lang.Process proceso; // cuando se ejecuta un programa, se retorna un objeto tipo Process

        try {
            // intentamos abrir el block de notas
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")) { // si el sistema operativo inicia con windows
                proceso = rt.exec("notepad"); // exec() retorna la instancia del proceso
            } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                proceso = rt.exec("textedit");
            }else if (System.getProperty("os.name").toLowerCase().contains("nux") || // Linux, aquí usamos contiene, en vez de startsWith, contains tmb se puede usar en el resto
                    System.getProperty("os.name").toLowerCase().contains("nix")) {
                proceso = rt.exec("gedit");
            }
            else {
                proceso = rt.exec("gedit"); // por defecto abrirá este programa, si es cualquie otro sistema operativo (lo más seguro es que sea linux)
            }
            proceso.waitFor(); // se espera hasta que se cierre el programa, no avanza en las demás líneas de codigo
        } catch(Exception e){
            System.err.println("El comando es desconocido: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Se ha cerrado el editor");
        System.exit(0);
    }
}
