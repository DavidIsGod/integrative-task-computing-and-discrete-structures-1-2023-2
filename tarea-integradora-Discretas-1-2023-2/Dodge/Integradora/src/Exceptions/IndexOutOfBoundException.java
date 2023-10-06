package Exceptions;

public class IndexOutOfBoundException extends Exception{

    public IndexOutOfBoundException(String message) {
        super("Index out of bound");


    }

    public String getMessage(){
        return super.getMessage();
    }
}
