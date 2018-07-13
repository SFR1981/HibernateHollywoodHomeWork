package models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name =  "studios")
public class Studio {

    private int id;
    private String name;
    private int bank;
    private List<Film> films;

    public Studio(){

    }


    public Studio(String name, int bank, List<Film> films) {
        this.name = name;
        this.bank = bank;
        this.films = films;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
