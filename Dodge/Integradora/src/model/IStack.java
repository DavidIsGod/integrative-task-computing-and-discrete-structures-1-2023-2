package model;

public interface IStack<T>{

     boolean push(T value);

    T pop();

    T peek();

    int getSize();

    boolean isEmpty();
}
