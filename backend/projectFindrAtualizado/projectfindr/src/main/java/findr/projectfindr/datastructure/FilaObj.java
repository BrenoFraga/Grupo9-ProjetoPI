package findr.projectfindr.datastructure;

public class FilaObj <T>{
    private T[] fila;
    private int tamanho;

    public FilaObj(int tamanho) {
        fila = (T[]) new Object[tamanho];
        tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }


    public void insert(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia!");
        }
        else {
            fila[tamanho++] = elemento;
        }

    }

    public T peek() {
        return fila[0];
    }

    public T poll() {
        T primeiro = peek();
        if (!isEmpty()) {
            for (int i = 0; i < tamanho-1; i++) {
                fila[i] = fila[i+1];
            }
            tamanho--;
            fila[tamanho] = null;
        }
        return primeiro;
    }

    public int getTamanho(){
        return tamanho;
    }
}
