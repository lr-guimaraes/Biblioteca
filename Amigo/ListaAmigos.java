package Amigo;

import java.util.ArrayList;

public class ListaAmigos {

    private ArrayList<Amigo> alAmigos;

    public ListaAmigos() {
        super();
        this.alAmigos = new ArrayList<Amigo>();
    }

    public int addAmigo(String nome) {
        int idAmigo = alAmigos.size() + 1;
        Amigo amigo = new Amigo(idAmigo, nome);
        alAmigos.add(amigo);
        return idAmigo;
    }

    public ArrayList<Amigo> getListaAmigos() {
        return alAmigos;
    }

    public int size() {
        return 0;
    }

    public ArrayList<Amigo> getAlAmigos() {
        return alAmigos;
    }

    public void setAlAmigos(ArrayList<Amigo> alAmigos) {
        this.alAmigos = alAmigos;
    }

    public void add(Amigo amigo) {
    }

}
