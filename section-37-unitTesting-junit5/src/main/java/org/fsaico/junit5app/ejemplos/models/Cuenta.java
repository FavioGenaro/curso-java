package org.fsaico.junit5app.ejemplos.models;

import org.fsaico.junit5app.ejemplos.exception.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {
    private String persona;
    // Este es un decimal de alta precisión, los calculos se hacen con aritmetica(calculo humano) y no por computadora con binarios
    // eso le quita precisión a otros tipos de datos.
    private BigDecimal saldo;

    private Banco banco;

    // constructor
    public Cuenta(String persona, BigDecimal saldo) {
        //this.persona = persona.toUpperCase(); // en mayuscula
        this.persona = persona;
        this.saldo = saldo;
    }

    //creamos los get y set
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void debito(BigDecimal monto){
        // BigDecimal es inmutable, por lo que no podemos usar subtract o add para restar y sumar respectivamente
        // lo que hace es que retorna ese cambio, pero no lo guarda en el original asi que debemos asignarlo
        //this.saldo = this.saldo.subtract(monto);

        BigDecimal nuevoSaldo = this.saldo.subtract(monto);
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){ // si devuelve -1 significa que 0 es mayor al nuevo saldo, se sobrepaso al saldo
            throw new DineroInsuficienteException("Dinero Insuficiente"); // lanzamos la excepción con el mensaje personalizado
        }
        this.saldo = nuevoSaldo; // asignamos el nuevo saldo si el monto no sobre pasa al saldo
    }

    public void credito(BigDecimal monto){
        this.saldo = this.saldo.add(monto);
    }


    @Override
    public boolean equals(Object obj) {

        // esto valida si obj es null y si obj es de la clase cuenta
        if( !(obj instanceof Cuenta)) {
            return false;
        }

        Cuenta c = (Cuenta)obj;
        if (this.persona == null || this.saldo == null){
            return false;
        }

        // ambas condiciones deben cumplirse, compara el objeto actual(this) con el que le pasamos por parámetro
        return this.persona.equals(c.getPersona()) && this.saldo.equals(c.getSaldo());
    }
}
