package models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilmTest {

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
        studio = new Studio("MirrorMax", 999999);
        studio2 = new Studio("Mangle Entertainment", 999999);
        film1 = new Film("The day after the day it rained hammers", director, Genre.DISASTER, studio);
        film2 = new Film("TekWars reboot", director, Genre.SCIENCE_FICTION, studio);
        films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);
    }

    @Test
    public void getTitle() {
        assertEquals("TekWars reboot", film2.getTitle());
    }

    @Test
    public void setTitle() {
        film1.setTitle("Start wars");
        assertEquals("Start wars", film1.getTitle());
    }

    @Test
    public void getDirector() {
        assertEquals("Stiven Spoilberg", film1.getDirector().getName());
    }

    @Test
    public void setDirector() {
        film1.setDirector(director2);
        assertEquals("Marvin Socrazy", film1.getDirector().getName());
    }

    @Test
    public void getCast() {
        assertEquals(0, film1.getCast().size());
    }

    @Test
    public void setCast() {
        film1.setCast(cast);
        assertEquals(1, film1.getCast().size());
    }

    @Test
    public void getGenre() {
        assertEquals(Genre.DISASTER, film1.getGenre());
    }

    @Test
    public void setGenre() {
        film1.setGenre(Genre.HORROR);
        assertEquals(Genre.HORROR, film1.getGenre());
    }

    @Test
    public void getStudio() {
        assertEquals("MirrorMax", film1.getStudio().getName());
    }

    @Test
    public void setStudio() {
        film1.setStudio(studio2);
        assertEquals("Mangle Entertainment", film1.getStudio().getName());

    }

    @Test
    public void canPayDirector(){
        film1.payDirector(director);
        assertEquals(100, director.getBank());
    }

    @Test
    public void canPayCast(){
        film1.setCast(cast);
        film1.payCast();
        assertEquals(5, actor.getBank());
    }

    @Test
    public void canPayAll(){
        film1.setCast(cast);
        film1.payAll();
        assertEquals(100, director.getBank());
        assertEquals(5, actor.getBank());

    }

    @Test
    public void canGetPayRoll(){
        film1.setCast(cast);
        assertEquals(105, film1.payroll());
    }

    @Test
    public void canAddCast(){
        film1.addCast(actor);
        assertEquals(1, film1.getCast().size());

    }
}