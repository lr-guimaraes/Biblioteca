package Item;

import java.util.Date;

public class Item {

	private int IdItem;
	private String tituloItem;
	private Disponibilidade dispItem;
	private Date dataDeLancamento;

	public Item(int idItem,String tituloItem,Date dataDeLancamento){
		this.IdItem = idItem;
		this.tituloItem = tituloItem;
		this.dataDeLancamento = dataDeLancamento;
		dispItem = Disponibilidade.DISPONIVEL;
	}

    public int getIdItem() {
		return IdItem;
	}
//	public void setIdItem(int idItem) {
//		IdItem = idItem;
//	}
	public String getTituloItem() {
		return tituloItem;
	}
	public void setTituloItem(String tituloItem) {
		this.tituloItem = tituloItem;
	}
	public Disponibilidade getDispItem() {
		return dispItem;
	}
	public void setDispItem(Disponibilidade dispItem) {
		this.dispItem = dispItem;
	}
	@Override
	public String toString() {
		return " Titulo: " + tituloItem + "     Código de identicação: " + IdItem +  "     disponibilidade: " + dispItem;
	}
	

	
}
