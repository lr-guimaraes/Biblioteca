package Item;
import java.util.ArrayList;

public class Biblioteca {

	private String nomeBib;
	private ArrayList<Item> alItem;

	public Biblioteca(String nomeBib) {
		this.nomeBib = nomeBib;
		this.alItem = new ArrayList<Item>(); 
	}

    public int size() {
        return 0;
    }
	// métodos, getters, setters, toString, compareTo etc conforme
	// a modelagem e encapsulamento que a equipe decidir implementar
	// várias opções

	public String getNomeBib() {
		return nomeBib;
	}

	public void setNomeBib(String nomeBib) {
		this.nomeBib = nomeBib;
	}

	public ArrayList<Item> getAlItem() {
		return alItem;
	}

	public void setAlItem(ArrayList<Item> alItem) {
		this.alItem = alItem;
	}

	@Override
	public String toString() {
		return "Biblioteca [alItem=" + alItem + ", nomeBib=" + nomeBib + "]";
	}


}
