public class Automovil {

    // hay otros modificadores de ocultación como el static que hace que el atributo sea igual para todos los objetos o de la clase
    // también está el final, que hace que el atributo sea constante y no sea modificado por ningún objeto
    private String fabricante;
    private String modelo;
    private String color;
    private double cilindrada;
    private int capacidadTanque = 40; // por defecto tiene 40 litros

    public String getFabricante(){ // GET
        return this.fabricante;
    }
    public void setFabricante(String fabricante){ // SET
        this.fabricante = fabricante; // asignamos al atributo fabricante la variable fabricante que se pasa como parámetro
    }

    public String getModelo(){ // SET
        return this.modelo;
    }
    public void setModelo(String modelo){ // SET
        this.modelo = modelo;
    }

    public String getColor(){
        return this.color;
    }
    public void setColor(String color){ // SET
        this.color = color;
    }

    public double getCilindrada(){ // GET
        return this.cilindrada;
    }
    public void setCilindrada(double cilindrada){ // SET
        this.cilindrada = cilindrada;
    }

    public int getCapacidadTanque(){ // GET
        return this.capacidadTanque;
    }
    public void setCapacidadTanque(int capacidadTanque){ // SET
        this.capacidadTanque = capacidadTanque;
    }
    // los métodos como los atributos tiene modificadores de acceso y de ocultación
    // método static: se pueden invocar los métodos sin crear el objeto, directamente con la clase como la clase Math (Math.max([])), porque ese método no es del objeto, le pertenece a la clase
    // método final: Evita que ese método se modifique en la herencia

    // primero colocamos el modificador de acceso sea public, etc., si se omite queda por default
    /* Luego se coloca el tipo de retorno, es decir, el tipo de dato del valor que va a devolver, que puede ser un primitivo (int, string, long, boolean,etc.) o un objeto,
      pero también no podrían retorna nada, esto si colocamos void (vacío)  */
    // Después, colocamos el nombre del método
    // Finalmente, colocamos los paréntesis, que dentro pueden venir parámetros o argumentos del método, estos parámetros pueden ser cualquier valor, incluso pueden ser valores de la misma clase

    public void detalle (){
        // this, es un objeto que hace referencia a la misma clase y podemos referenciar los atributos o métodos de la propia clase
        /* this también puede omitirse, pero podemos crear variables con el mismo nombre dentro de este método y si no tiene this no toma al atributo de la clase,
        sino a la variable del método, por eso es mejor colocar el this para ser más explícito */
        System.out.println("auto.fabricante = " + this.fabricante);
        System.out.println("auto.modelo = " + this.modelo);
        System.out.println("auto.color = " + this.getColor());
        System.out.println("auto.cilindrada = " + this.getCilindrada());

    }

    // NOTA: un método de una clase no debería imprimir datos, solo debe ejecutar un proceso o devolver esos datos para luego guardarlo en algún archivo o json, etc.
    public String detalle2 (){
        StringBuilder sb = new StringBuilder(); // usamos esta clase para concatenar, aunque también podemos usar el +
        sb.append("auto.fabricante = " + this.fabricante); // concatenamos cada texto
        sb.append("\nauto.modelo = " + this.modelo);
        sb.append("\nauto.color = " + this.color);
        sb.append("\nauto.cilindrada = " + this.cilindrada);

        return sb.toString(); // retornamos un string
    }

    // retorna un String y recibe un argumento del tipo entero
    // podríamos obviar los this porque no hay variables con el mismo nombre
    public String acelerar (int rpm) {
        return "El auto " + this.fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar () {
        return this.fabricante + " " + this.modelo + " frenando!";
    }

    // método que combina a los otros dos
    public String acelerarFrenar (int npm){
        // ambos métodos retornan un string por eso podemos almacenarlos en variables del mismo tipo
        String acelerar = this.acelerar(npm); // usamos this para hacer referencia al método de la clase
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    // calculamos el rendimiento de kilómetros recorrido por litro de bencina
    public float calcularConsumo (int km, float porcentajeBencina){
        return  km/(capacidadTanque*porcentajeBencina);
    }

    // sobrecargamos el método calcularConsumo con el segundo método como entero, por si alguien coloca 50,60,80%
    public float calcularConsumo (int km, int porcentajeBencina){
        return  km/(capacidadTanque*(porcentajeBencina/100f));
    }
}
