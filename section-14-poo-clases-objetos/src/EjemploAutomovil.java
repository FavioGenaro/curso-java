public class EjemploAutomovil {

    public static void main(String[] args) {

        Automovil subaru = new Automovil();
        // Usamos los métodos get para asignar los valores
        subaru.setFabricante("Subaru");
        subaru.setModelo("Impreza");
        subaru.setCilindrada(2.0);
        subaru.setColor("Blanco");

        Automovil mazda = new Automovil();
        mazda.setFabricante("Mazda");
        mazda.setModelo("BT-50");
        mazda.setCilindrada(3.0);
        mazda.setColor("Rojo");

        // Usamos los métodos set para leer los valores
        System.out.println("subaru.fabricante" + subaru.getFabricante());
        System.out.println("mazda.fabricante" + mazda.getFabricante());

        // auto.detalle();
        // mazda.detalle();
        // System.out.println(auto.detalle2());
        // System.out.println(mazda.detalle2());

        // IntelliJ IDEA nos muestra el nombre de la variable
        // System.out.println(subaru.acelerar(3000));
        // System.out.println(subaru.frenar());

        // System.out.println(mazda.acelerarFrenar(4000)); // Ejecutamos el método que combina a los otros dos

        // colocamos la distancia en km y el porcentaje gastado que es del tipo float, por eso al final colocamos f
        //System.out.println("Kilómetros por litro " + subaru.calcularConsumo(300,0.6f));
        // ejecutamos el método sobrecargado, ambos argumentos son enteros.
        //System.out.println("Kilómetros por litro " + subaru.calcularConsumo(300,60));


    }
}
