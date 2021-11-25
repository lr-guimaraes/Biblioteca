package Item;

import java.util.Date;

public class Filme extends Item { //Classe Y
    //adicionar data de lancamento como LocalDate
    private String Genero;

    public Filme(int id, String NomeFilme, Date dataDeLancamento, String Genero) {
        super(id, NomeFilme, dataDeLancamento);
        this.Genero = Genero;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

}
