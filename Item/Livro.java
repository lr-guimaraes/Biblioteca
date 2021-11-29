package Item;

import java.util.Date;

public class Livro extends Item {

    private String autorLivro;
    private int totPagLivro;

    public Livro(int id, String titulo, Date dataDeLancamento, String autorLivro, int totPagLivro) {
        super(id, titulo, dataDeLancamento);
        this.autorLivro = autorLivro;
        this.totPagLivro = totPagLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public int getTotPagLivro() {
        return totPagLivro;
    }

    public void setTotPagLivro(int totPagLivro) {
        this.totPagLivro = totPagLivro;
    }
}
