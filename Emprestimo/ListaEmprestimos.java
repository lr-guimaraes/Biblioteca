package Emprestimo;
import java.util.ArrayList;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}
// construtor
	public ListaEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}
	// getters e setters
	public ArrayList<Emprestimo> getAlEmprestimos() {
		return alEmprestimos;
	}
	public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}	
	// toString
	@Override
	public String toString() {
		return "ListaEmprestimos [alEmprestimos=" + alEmprestimos + "]";
	}
	public void addEmprestimo(Emprestimo emprestimo) {
		alEmprestimos.add(emprestimo);
	}	
}