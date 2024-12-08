package Etapa3;

public class StaticList<E> implements List<E>{
    protected E[] elements;
    int numElements;

    public StaticList(int maxSize) {
        elements = (E[])new Object[maxSize];
        numElements = 0;
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return numElements == elements.length;
    }

    @Override
    public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException{
        // Verifica se tem espaço na lista
        if (isFull())
            throw new OverflowException();

        // Verifica se a posição é válida
        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        // Desloca para a direita os elementos necessarios
        // Abrindo espaço para o novo elemento.
        for( int i = numElements-1; i >= pos; i--)
            elements[i+1] = elements[i];

        // Armazena o novo elemento e ajusta o total
        elements[pos] = element;
        numElements++;

    }

    @Override
    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        // Verifica se a lista está vazía
        if (isEmpty())
            throw new UnderflowException();

        // Verifica se a posição é válida
        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        // Guarda posição referência temporária ao elemento removido
        E element = elements[pos];

        // Desloca elementos para a esquerda sobrescrevendo o elemento a ser removido
        for (int i = pos; i < numElements-1; i++)
            elements[i] = elements[i+1];    

        // Define a posição do último elemento para null para que a coleta de lixo possa atuar e ajuste o total de elementos
        elements[numElements-1] = null;
        numElements--;

        return element;
    }

    @Override
    public E get(int pos) throws IndexOutOfBoundsException{
        // Verifica se a posição é válida
        if (pos < 0 || pos > numElements)
            throw new IndexOutOfBoundsException();

        return elements[pos];
    }

    @Override
    public int search(E element) {
        // Varre todos os elementos e compara com elemento procurado
        for (int i = 0; i < numElements; i++)
            if (element.equals(elements[i]))
                return i;
        
        return -1;
    }

    // Método público para contar elementos 
    public int contaElementos(E el) { 
    return contaElementosRecursivo(el, 0); 
    } 
    
    // Método privado recursivo 
    private int contaElementosRecursivo(E el, int pos) { 
    if (pos >= numElements)
        return 0; 
    
     int count = el.equals(elements[pos]) ? 1 : 0; 
     return count + contaElementosRecursivo(el, pos + 1);
     
    }
}
