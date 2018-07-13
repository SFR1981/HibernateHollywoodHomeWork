package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "actors")
public class Actor extends Employee{

    private List<Film> films;

    public Actor(String name, int payRate) {
        super(name, payRate);
        this.films = new ArrayList<Film>();
    }

    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actors_films", joinColumns  = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public List<Film> getFilms() {
        return this.films;
    }


    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilmtoFilms(Film film){
        this.films.add(film);
    }
}
