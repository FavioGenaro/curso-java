import java.util.Map;

public class EjemploVariablesDeEntorno {
    public static void main(String[] args) {
        // tipo map, almacena valores en modo clave-valor
        Map<String, String> varEnv = System.getenv(); // obtenemos las variables de entorno
        System.out.println("Variables de ambiente del sistema = " + varEnv); // imprimos todas

        System.out.println("------ Listando variables de entorno del sistema ------");
        for(String key: varEnv.keySet()){
            System.out.println(key + " => " + varEnv.get(key));
        }

        System.out.println("\n");
        // podemos obtener uno por una las variables de entorno, estos son muy parecide a las propiedades, que son tmb extraidas
        String username = System.getenv("USERNAME"); // Obtenemos el USERNAME
        System.out.println("username = " + username);
        
        String javaHome = System.getenv("JAVA_HOME"); // obtenemos JAVA_HOME
        System.out.println("javaHome = " + javaHome);

        String temDir = System.getenv("TEMP"); // ruta del directorio temporal
        System.out.println("temDir = " + temDir);

        String path = System.getenv("Path");
        System.out.println("path = " + path);

        // obtenemos las variables de entorno desde el MAP que declaramos al inicio
        String path2 = varEnv.get("Path");
        System.out.println("path2 = " + path2);

        // Podemos crear estas variables, sino exiten aparece null
        String appEnv = varEnv.get("APPLICATION_ENV");
        System.out.println("appEnv = " + appEnv);

        String hola = varEnv.get("SALUDAR_HOLA");
        System.out.println("hola = " + hola);
    }
}
