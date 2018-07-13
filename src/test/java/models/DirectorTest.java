package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DirectorTest {

    Actor actor;
    Film film1;
    Film film2;
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
        film1 = new Film("The day after the day it rained hammers", director, Genre.DISASTER, studio);
        film2 = new Film("TekWars reboot", director, Genre.DISASTER, studio);
        films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);
    }

    @Test
    public void getFilms() {
        assertEquals(0, director.getFilms().size());

    }

    @Test
    public void setFilms() {
        director.setFilms(films);
        assertEquals(2, director.getFilms().size());
    }

    @Test
    public void addFilmtoFilms() {
        director.addFilmtoFilms(film1);
        assertEquals(1, director.getFilms().size());
    }

    @Test
    public void getName() {
        assertEquals("Stiven Spoilberg", director.getName());
    }

    @Test
    public void setName() {
        director.setName("Barry");
        assertEquals("Barry", director.getName());
    }

    @Test
    public void getBank() {
        assertEquals(0, director.getBank());
    }

    @Test
    public void setBank() {
        director.setBank(1);
        assertEquals(1, director.getBank());
    }

    @Test
    public void getPayRate() {
        assertEquals(100, director.getPayRate());
    }

    @Test
    public void setPayRate() {
        director.setPayRate(101);
        assertEquals(101, director.getPayRate());
    }

    @Test
    public void isPaid() {
        director.isPaid();
        assertEquals(100, director.getBank());
    }

    @Test
    public void payRateIncrease() {
        director.payRateIncrease(5);
        assertEquals(105, director.getPayRate());
    }
}