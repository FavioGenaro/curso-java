import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class EjemploAsignarPropiedadesDeSistema {
    public static void main(String[] args) {

        try { // nos obigla a usar try porque puede que el archivo no exista
            // leemos el archivo config.properties, este en formato de bytes
            // dentro del archivo se crean variables con valores. El nombre de esta variable debe estar separado con puntos
            FileInputStream archivo = new FileInputStream("src/config.properties");

            Properties p = new Properties(System.getProperties()); // objeto properties
            p.load(archivo); // cargamos el archivo

            // añadimos una propiedad, esta es una forma alterna a tener el archivo
            p.setProperty("mi.propiedad.personalizada","Mi valor guardado en el objeto properties");
            System.setProperties(p); // asignamos estas propiedades al sistema

            Properties ps = System.getProperties(); // nuevo objeto para ver si se añadieron las propiedades que creamos
            // obtenemos algunas propiedades
            System.out.println("ps.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));

            System.out.println("\nPropiededes del sistema:");
            ps.list(System.out); // imprimimos todas las propieades
        } catch(Exception e){
            System.err.println("no existe el archivo = " + e);
            System.exit(1);
        }
    }
}
