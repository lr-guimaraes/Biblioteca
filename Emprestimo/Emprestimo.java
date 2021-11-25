package Emprestimo;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Amigo.Amigo;
import Item.Item;

public class Emprestimo {

	private int idAmigo;
	private int idItem;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	// para a equipe pensar nesta repetição, pois pode-se obter os objetos pelo IDs
	private Item item;
	private Amigo amigo;

	public Emprestimo(int idAmigo, int idItem){
		this.idAmigo = idAmigo;
		this.idItem = idItem;
	}
	
	public Emprestimo(int idAmigo, int idItem, Date dataEmprestimo){
		this.idAmigo = idAmigo;
		this.idItem = idItem;
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getIdAmigo() {
		return idAmigo;
	}
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public String getDataEmprestimoBr1(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(dataEmprestimo);
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Amigo getAmigo() {
		return amigo;
	}
	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}
	

}
