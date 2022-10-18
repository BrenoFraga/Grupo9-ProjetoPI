package findr.projectfindr.datastructure.listaLigada;

import findr.projectfindr.datastructure.node.Node;

public class ListaLigada {
    private Node head;
    public ListaLigada() {
        head = new Node("");
    }
    public void insereNode(String valor) {
        Node novo = new Node(valor);
        novo.setNext(head.getNext());
        head.setNext(novo);
    }
    public void exibe()
    {
        Node atual = head.getNext();
        while (atual != null) {
            System.out.print(atual.getInfo() + "\t");
            atual = atual.getNext();
        }
        System.out.println();
    }
    public Node buscaNode(String valor) {
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getNext();
        }
        return null;
    }
    public Boolean removeNode(String valor) {
        Node ant = head;
        Node atual = head.getNext();
        while (atual != null) {
            if (atual.getInfo().equals( valor)) {
                ant.setNext(atual.getNext());
                return true;
            }
            ant = atual;
            atual = atual.getNext();
        }
        return false;
    }

    public int getTamanho() {
        Node atual = head.getNext();
        int tam = 0;
        while (atual != null) {
            tam++;
            atual = atual.getNext();
        }
        return tam;
    }

}
