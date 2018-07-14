import db.DBActor;
import db.DBFilm;
import db.DBHelper;
import db.DBStudio;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

       Actor actor = new Actor("Wall Smath", 5);
      DBHelper.save(actor);
      Actor actor2 = new Actor("Com Truise", 5);
      DBHelper.save(actor2);
      Actor actor3 = new Actor("Morolyn Manson", 15);
      DBHelper.save(actor3);
      Actor actor4 = new Actor("Spock Early", 52);
      DBHelper.save(actor4);
      Actor actor5 = new Actor("Postman Pat", 43);
      DBHelper.save(actor5);

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
        cast.add(actor2);

        ArrayList<Actor> cast2 = new ArrayList<Actor>();
        cast2.add(actor3);
        cast2.add(actor4);
        cast2.add(actor5);


       Film film1 = new Film("The day after the day it rained hammers", director, Genre.DISASTER, studio);
       DBHelper.save(film1);

        Film film2 = new Film("TekWars reboot", director2, Genre.SCIENCE_FICTION, studio2);
        film2.setCast(cast2);
        DBHelper.save(film2);

        Film film3 = new Film ("Shrok 4", director, Genre.HORROR, studio);
        DBHelper.save(film3);
        DBFilm.addActor(actor, film3);
        DBFilm.addActor(actor5, film3);
        ArrayList<Film> films = new ArrayList<Film>();
        films.add(film1);
        films.add(film2);

        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film3);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);
        studio.addFilmToFilms(film1);
        studio2.addFilmToFilms(film2);



        List<Film> foundFilms = DBStudio.getFilmsFromStudio(studio);
        List<Film> filmsByDirector = DBFilm.getFilmsFromDirector(director);

        List<Film> actorFilms = DBActor.getFilmsByActor(actor);
        List<Film> horrors = DBActor.getFilmsByGenre(actor, Genre.HORROR);
        Studio foundStudio = DBStudio.getStudioFromAFilm(film2);
        Studio findStudio = DBHelper.find(Studio.class , film2.getStudio().getId());
        Director findDirector = DBFilm.getDirectorByFilm(film2);









    }
}
