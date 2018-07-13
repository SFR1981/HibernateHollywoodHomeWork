import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;

import java.util.ArrayList;

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

       Film film1 = new Film("The day after the day it rained hammers", director, "disaster", studio);
        film1.setCast(cast);
        DBHelper.save(film1);

        Film film2 = new Film("TekWars reboot", director2, "disaster", studio2);
        film2.setCast(cast);
        DBHelper.save(film2);

        ArrayList<Film> films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);

        studio.setFilms(films);
        studio2.payPayFilmCrew(film2);
        studio.payPayFilmCrew(film1);
        studio.payPayFilmCrew(film1);











    }
}
