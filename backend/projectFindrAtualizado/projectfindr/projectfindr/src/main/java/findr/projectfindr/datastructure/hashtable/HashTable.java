package findr.projectfindr.datastructure.hashtable;

import findr.projectfindr.datastructure.listaLigada.ListaLigada;

public class HashTable {
    private final ListaLigada[] table;
    public HashTable(int tam) {
        this.table = new ListaLigada[tam];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ListaLigada();
        }
    }
    public int funcaoHash(String valor){
        int ret = 0;
        switch (valor){
            case "A" : ret = A;
            case "B" : ret = B;
            case "C" : ret = C;
            case "D" : ret = D;
            case "E" : ret = E;
            case "F" : ret = F;
            case "G" : ret = G;
            case "H" : ret = H;
            case "I" : ret = I;
            case "J" : ret = J;
            case "K" : ret = K;
            case "L" : ret = L;
            case "M" : ret = M;
            case "N" : ret = N;
            case "O" : ret = O;
            case "P" : ret = P;
            case "Q" : ret = Q;
            case "R" : ret = R;
            case "S" : ret = S;
            case "T" : ret = T;
            case "U" : ret = U;
            case "V" : ret = V;
            case "W" : ret = W;
            case "X" : ret = X;
            case "Y" : ret = Y;
            case "Z" : ret = Z;
        }
        return ret;
    }
    public void insere(String valor,String data) {
        this.table[funcaoHash(valor)].insereNode(data);
    }
    public boolean busca(String valor,String data) {
        return this.table[funcaoHash(valor)]
                .buscaNode(data) != null;
    }

    public boolean remove(String valor) {
        return this.table[funcaoHash(valor)]
                .removeNode(valor);
    }

    public void exibe(){
        for (ListaLigada lista: this.table) {
            lista.exibe();
        }
    }
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int H = 7;
    public static final int I = 8;
    public static final int J = 9;
    public static final int K = 10;
    public static final int L = 11;
    public static final int M = 12;
    public static final int N = 13;
    public static final int O = 14;
    public static final int P = 15;
    public static final int Q = 16;
    public static final int R = 17;
    public static final int S = 18;
    public static final int T = 19;
    public static final int U = 20;
    public static final int V = 21;
    public static final int W = 22;
    public static final int X = 23;
    public static final int Y = 24;
    public static final int Z = 25;
}

