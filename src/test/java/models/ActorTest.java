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
    List<Film> films;
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
        film1 = new Film("The day after the day it rained hammers", director, cast, "disaster", studio);
        film1 = new Film("TekWars reboot", director, cast, "disaster", studio);
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

    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getBank() {
    }

    @Test
    public void setBank() {
    }

    @Test
    public void getPayRate() {
    }

    @Test
    public void setPayRate() {
    }

    @Test
    public void isPaid() {
    }

    @Test
    public void payRateIncrease() {
    }
}