package Emprestimo;

import java.util.ArrayList;

public class ListaEmprestimos {

    private ArrayList<Emprestimo> alEmprestimos;

    public ListaEmprestimos() {
        super();
        this.alEmprestimos = new ArrayList<Emprestimo>();
    }

    public ListaEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
        this.alEmprestimos = alEmprestimos;
    }

    public ArrayList<Emprestimo> getAlEmprestimos() {
        return alEmprestimos;
    }

    public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
        this.alEmprestimos = alEmprestimos;
    }

    @Override
    public String toString() {
        return "ListaEmprestimos [alEmprestimos=" + alEmprestimos + "]";
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        alEmprestimos.add(emprestimo);
    }
}