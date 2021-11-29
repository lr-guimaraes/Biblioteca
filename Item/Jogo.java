package Item;

import java.util.Date;

public class Jogo extends Item { //Classe x

    private String estudio;
    private String plataforma;

    public Jogo(int id, String tituloItem, Date dataDeLancamento, String estudio, String plataforma) {
        super(id, tituloItem, dataDeLancamento);
        this.estudio = estudio;
        this.plataforma = plataforma;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

}
