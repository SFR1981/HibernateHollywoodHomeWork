package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudioTest {

    Actor actor;
    Film film1;
    Film film2;
    ArrayList<Film> films;
    List<Actor> cast;
    Studio studio;
    Studio studio2;
    Director director;
    Director director2;

    @Before
    public void setUp() throws Exception {
        actor = new Actor("Wall Smath", 5);
        director = new Director("Stiven Spoilberg", 100);
        director2 = new Director("Marvin Socrazy", 100);
        cast = new ArrayList<Actor>();
        cast.add(actor);
        studio = new Studio("MirrorMax", 0);
        studio2 = new Studio("Mangle Entertainment", 0);
        film1 = new Film("The day after the day it rained hammers", director, Genre.COMEDY, studio);
        film2 = new Film("TekWars reboot", director, Genre.COMEDY, studio);
        films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);
    }

    @Test
    public void getName() {
        assertEquals("MirrorMax", studio.getName());
    }

    @Test
    public void setName() {
        studio.setName("cakes");
        assertEquals("cakes", studio.getName());
    }

    @Test
    public void getBank() {
        assertEquals(0, studio.getBank());
    }

    @Test
    public void setBank() {
        studio.setBank(1);
        assertEquals(1, studio.getBank());
    }

    @Test
    public void getFilms() {
        assertEquals(0, studio.getFilms().size());
    }

    @Test
    public void setFilms() {
        studio.setFilms(films);
        assertEquals(2, studio.getFilms().size());
    }

    @Test
    public void addFilmToFilms() {
        studio.addFilmToFilms(film2);
        assertEquals(1, studio.getFilms().size());
    }

    @Test
    public void canLoseMoney(){
        studio.setBank(10);
        studio.loseMoney(1);
        assertEquals(9, studio.getBank());

    }

    @Test
    public void studioPaysOut(){
        film1.addCast(actor);
        studio.setBank(205);
        studio.payPayFilmCrew(film1);
        assertEquals(100, film1.getDirector().getBank());
        assertEquals(5, actor.getBank());
        assertEquals(100, studio.getBank());
    }
}