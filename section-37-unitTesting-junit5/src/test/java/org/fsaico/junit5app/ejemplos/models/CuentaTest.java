package org.fsaico.junit5app.ejemplos.models;

//import org.junit.jupiter.api.Assertions;

import org.fsaico.junit5app.ejemplos.exception.DineroInsuficienteException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*; // agrega los asetions que es para validar los test

class CuentaTest {

    // Como buena practica debe ser un método default o privado de package, solo se debe de usar dentro del contexto de pruebas
    // no debe ser public

    // camel case
    @Test
    void testNombreCuenta() {
        // instanciamos la clase que queremos probar
        // es mejor pasar el BigDecimal como string, sino con le punto estamos pasando un double que tiene ciertas limitaciones
        Cuenta cuenta = new Cuenta("Favio FG", new BigDecimal("1000.123456"));

        // pasamos datos de prueba
        //cuenta.setPersona("Favio");
        // valor esperado y real
        String esperado = "Favio";
        String real = cuenta.getPersona();

        assertNotNull(real, () -> "la cuenta no puede ser nula");
        assertEquals(esperado, real, () -> "el nombre de la cuenta no es el que se esperaba: se esperaba " + esperado
                + " sin embargo fue " + real);
        assertTrue(real.equals("Andres"), () -> "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("Favio", new BigDecimal("1000.12345"));
        // comparamos el número, este será del tipo double, por lo que debemos convertir Bigdecimal
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());

        // el saldo no puede ser negativo, no queremos que se cumpla que el saldo es menor que cero
        // compareTo() devuelve un entero, lo comparamos con un cero tipo BigDecimal.
        // si compareTo() retorna -1 quiere decir que el saldo es menor que cero, es decir BigDecimal.ZERO es mayor al saldo
        // si es mayor de BigDecimal.ZERO, retorna 1 y por tanto es mayor que cero
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
    }

    @Test
    void testReferenciaCuenta() {

        // valor real o actual
        Cuenta cuenta = new Cuenta("John Doe", new BigDecimal("8900.9997"));
        // valor esperado
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8900.9997"));

        // esto debe afirmarse porque los dos objeto no son iguales
        // Equals hace la comparación por referencia, ambos objetos apuntan a direcciones de memoria distintas, por lo que son distintos
        //assertNotEquals(cuenta2,cuenta);

        assertEquals(cuenta2, cuenta); // aquí deberia fallar, porque los objetos son distintos
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100)); // quitamos 100

        assertNotNull(cuenta.getSaldo()); // el saldo no debe ser nulo
        // verificamos como entero y como string:
        assertEquals(900, cuenta.getSaldo().intValue()); // verificamos la parte entera
        assertEquals("900.12345", cuenta.getSaldo().toPlainString()); // devuelve el string plano con el valor del saldo

    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100)); // quitamos 100

        assertNotNull(cuenta.getSaldo()); // el saldo no debe ser nulo
        // verificamos como entero y como string:
        assertEquals(1100, cuenta.getSaldo().intValue()); // verificamos la parte entera
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString()); // devuelve el string plano con el valor del saldo
    }

    @Test
    void testDineroInsuficienteExceptionCuenta() {
        Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        // cuando invocamos debito debemos comprobar que lo que se va a retirar es menor al saldo
        // assertThrows para el manejo de excepciones, pasamos la excepcion que esperamos que se lance en el método debito y una función lamda
        // assertThrows devuelve un objeto excepción, el cual debe ser asignado para poder
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500)); // monto mayor al que tenemos
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual); // validamos el mensaje de error
    }

    @Test
    void testTransferirDineroCuentas() {
        // creamos 2 cuentas
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco del Estado");
        // vamos a transferir de 2 a 1, 500 soles
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString()); // la cuenta 2 debería quedar con 1000
        assertEquals("3000", cuenta1.getSaldo().toPlainString()); // la cuenta 1 con 3000
    }

    @Test
    void testRelacionBancoCuentas() {
        //fail();
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        /*assertEquals("1000.89898", cuenta2.getSaldo().toPlainString()); // la cuenta 2 debería quedar con 1000
        assertEquals("3000", cuenta1.getSaldo().toPlainString()); // la cuenta 1 con 3000

        assertEquals(2,banco.getCuentas().size()); // debemos tener 2 cuentas en la lista
        assertEquals("Banco del Estado.", cuenta1.getBanco().getNombre());

        // la lista se transforma a stream e iteramos toda la lista para encontrar a la cuenta con el nombre Andres
        assertEquals("Andres", banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Andres"))
                .findFirst() // retorna un optional
                .get().getPersona()); // con esto obtenemos el nombre de esa cuenta

        assertTrue( banco.getCuentas().stream()
                .filter(c -> c.getPersona().equals("Andres"))
                .findFirst().isPresent()); // con esto obtenemos el nombre de esa cuenta

        assertTrue( banco.getCuentas().stream()
                .anyMatch(c -> c.getPersona().equals("Andres")));*/

        // Como tenemos una sola línea de código en cada función lambda podemos omitir las llaves
        assertAll(
                () -> assertEquals("1000.89898", cuenta2.getSaldo().toPlainString(), // error
                        () -> "el valor del saldo de la cuenta2 no es el esperado."), // mensaje
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString(),
                        () -> "el valor del saldo de la cuenta1 no es el esperado."), // mensaje
                () -> assertEquals(2, banco.getCuentas().size(),
                        () -> "el banco no tienes las cuentas esperadas"), // mensaje
                () -> assertEquals("Banco del Estado.", cuenta1.getBanco().getNombre()), // error
                () -> assertEquals("Andres", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Andres"))
                        .findFirst()
                        .get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Jhon Doe"))));
    }

}