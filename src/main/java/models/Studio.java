package models;


import db.DBHelper;
import db.DBStudio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name =  "studios")
public class Studio {

    private int id;
    private String name;
    private int bank;
    private List<Film> films;

    public Studio() {

    }


    public Studio(String name, int bank) {
        this.name = name;
        this.bank = bank;
        this.films = new ArrayList<Film>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "bank")
    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    @OneToMany(mappedBy = "studio", fetch = FetchType.EAGER)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilmToFilms(Film film) {
        this.films.add(film);
        DBHelper.update(this);
        this.payPayFilmCrew(film);
    }

    public void loseMoney(int pay) {
        this.bank -= pay;
    }

    //    // pay everyone
    public void payPayFilmCrew(Film film) {
        film.payAll();
        int cost = film.payroll();
        this.loseMoney(cost);
        DBHelper.update(this);

    }

    //pay all payrolls for all movies belonging to studio


}
