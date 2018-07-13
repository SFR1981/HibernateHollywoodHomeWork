package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActorTest {

    Actor actor;
    Film film1;
    Film film2;
    Film film3;
    ArrayList<Film> films;
    List<Actor> cast;
    Studio studio;
    Director director;


    @Before
    public void before(){
        actor = new Actor("Wall Smath", 5);
        director = new Director("Stiven Spoilberg", 100);
        cast = new ArrayList<Actor>();
        cast.add(actor);
        studio = new Studio("MirrorMax", 999999);
        film1 = new Film("The day after the day it rained hammers", director,  Genre.DISASTER, studio);
        film2 = new Film("TekWars reboot", director, Genre.SCIENCE_FICTION, studio);
        film3 = new Film("Shrok 4", director, Genre.HORROR, studio);
        films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);



    }

    @Test
    public void getFilms() {
        assertEquals(0, actor.getFilms().size());
    }

    @Test
    public void setFilms() {
        actor.setFilms(films);
        assertEquals(2, actor.getFilms().size());

    }

    @Test
    public void canAddFilm(){
        actor.addFilmtoFilms(film3);
        assertEquals(1, actor.getFilms().size());
    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
        assertEquals("Wall Smath", actor.getName());
    }

    @Test
    public void setName() {
        actor.setName("Harry Noone");
        assertEquals("Harry Noone", actor.getName());

    }

    @Test
    public void getBank() {
        assertEquals(0, actor.getBank());
    }

    @Test
    public void setBank() {
        actor.setBank(5);
        assertEquals(5, actor.getBank());
    }

    @Test
    public void getPayRate() {
        assertEquals(5, actor.getPayRate());
    }

    @Test
    public void setPayRate() {
        actor.setPayRate(6);
        assertEquals(6, actor.getPayRate());
    }

    @Test
    public void isPaid() {
        actor.isPaid();
        assertEquals(5, actor.getBank());
    }

    @Test
    public void payRateIncrease() {
        actor.payRateIncrease(5);
        assertEquals(10, actor.getPayRate());
    }
}