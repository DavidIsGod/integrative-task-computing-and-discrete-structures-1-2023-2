package Exceptions;

public class ListNullException extends Exception{

    public ListNullException(String message) {
        super("List is empty");


    }

    public String getMessage(){
        return super.getMessage();
    }
}
