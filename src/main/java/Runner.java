import db.DBHelper;
import db.DBStudio;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

       Actor actor = new Actor("Wall Smath", 5);
      DBHelper.save(actor);

     Studio studio = new Studio("MirrorMax", 10000000);
      DBHelper.save(studio);

        Studio studio2 = new Studio("Mangle Entertainment", 10000000);
        DBHelper.save(studio2);

        Director director = new Director("Stiven Spoilberg", 100);
        DBHelper.save(director);

        Director director2 = new Director("Marvin Socrazy", 100);
        DBHelper.save(director2);



        ArrayList<Actor> cast = new ArrayList<Actor>();
        cast.add(actor);

       Film film1 = new Film("The day after the day it rained hammers", director, Genre.DISASTER, studio);
        film1.setCast(cast);
        DBHelper.save(film1);

        Film film2 = new Film("TekWars reboot", director2, Genre.SCIENCE_FICTION, studio2);
        film2.setCast(cast);
        DBHelper.save(film2);

        Film film3 = new Film ("Shrok 4", director, Genre.COMEDY, studio);
        film1.setCast(cast);
        DBHelper.save(film1);

        ArrayList<Film> films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);

        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);



        List<Film> foundFilms = DBStudio.getFilmsFromStudio(studio);










    }
}
