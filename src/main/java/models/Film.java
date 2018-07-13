package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {

    private int id;
    private String title;
    private Director director;
    private List<Actor> cast;
    private String genre;
    private Studio studio;


    public Film(){

    }


    public Film(String title, Director director, List<Actor> cast, String genre, Studio studio) {
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.studio = studio;

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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    //TODO: Many to one
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    //TODO : Many to MAny
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "actors_films", joinColumns  = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)})
    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //TODO : Many to one relation
    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    //TODO: pay everyone void
    // this.director.getpaid
    // for castMember in cast
    // cast.getpaid



    //TODO: calculate payroll for film,
    // everyone gets paid payrate and then total
    // director
    // total = 0
    // total += this.director.getpayrate
    // for actor in cast
    // total += actor.getpayrate
    // return total
}
