package org.fsaico.junit5app.ejemplos.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombre;
    private List<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta) { // agrega una cuenta a la lista
        this.cuentas.add(cuenta);
        cuenta.setBanco(this); // se añade el banco a la cuenta
    }

    public void transferir(Cuenta origen, Cuenta destino, BigDecimal monto) {

        origen.debito(monto); // retiramos dinero de la cuenta origen
        destino.credito(monto); // aumentamos dinero en el destino
    }

}
