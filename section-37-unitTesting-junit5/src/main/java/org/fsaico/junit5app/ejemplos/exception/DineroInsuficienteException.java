package org.fsaico.junit5app.ejemplos.exception;

public class DineroInsuficienteException extends RuntimeException{

    // contructor que pasa el mensaje al padre
    public DineroInsuficienteException (String message){
        super(message);
    }

}
