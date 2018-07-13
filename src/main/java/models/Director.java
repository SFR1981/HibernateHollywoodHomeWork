package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "directors")
public class Director extends Employee{

    private List<Film> films;

    public Director(){

    }


    public Director(String name, int payRate) {
        super(name, payRate);
        this.films = new ArrayList<Film>();
    }

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilmtoFilms(Film film){
        this.films.add(film);
    }
}
