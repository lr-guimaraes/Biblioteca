package Item;
import java.util.ArrayList;
import java.util.Date;

public class ListaItens {

	private ArrayList<Item> alItens;

	// construtor
	public ListaItens() {
		super();
		this.alItens = new ArrayList<Item>();
	}
	
	public void addItem (Item item){
		alItens.add(item);
	}
	
	public ArrayList<Item> getListaItens(){
		return alItens;
	}
	// getters e setters
	// toString

	public int size() {
		return 0;
	}

    public ArrayList<Item> getAlItens() {
		return alItens;
	}

	public void setAlItens(ArrayList<Item> alItens) {
		this.alItens = alItens;
	}
}
