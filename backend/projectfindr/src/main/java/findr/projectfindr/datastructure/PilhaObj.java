package findr.projectfindr.datastructure;

public class PilhaObj <T>{

    private T[] pilha;
    private int topo;

    public PilhaObj(int tamanho) {
        pilha = (T[]) new Object[tamanho];
        topo = -1;
    }

    public boolean isEmpty(){
        return topo == -1;
    }

    public boolean isFull(){
        return topo == pilha.length -1;
    }

    public void push(T elemento){
        if(!isFull()){
            pilha[++topo] = elemento;
        }
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        return pilha[topo --];
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return pilha[topo];
    }

}
