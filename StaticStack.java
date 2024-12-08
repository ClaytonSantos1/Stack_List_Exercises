package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private E[] elements;
    private int size;

    public StaticStack(int maxSize) {
        elements = (E[]) new Object[maxSize];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }
        elements[size++] = element;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return elements[--size];
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return elements[size - 1];
    }

    // Método para acessar elementos sem removê-los 
    public E get(int index) { 
        if (index < 0 || index >= size) { 
            throw new IndexOutOfBoundsException(); 
    } 
    return elements[index];
    }
}

