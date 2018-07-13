package models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

public class Actor extends Employee{

    private List<Film> films;

    public Actor(String name, int payRate, List<Film> films) {
        super(name, payRate);
        films = films;
    }

    @Cascade(CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actors_films", joinColumns  = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    public List<Film> getFilms() {
        return films;
    }


    public void setFilms(List<Film> films) {
        films = films;
    }
}
