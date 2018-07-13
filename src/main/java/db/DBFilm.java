package db;

import models.Actor;
import models.Film;

public class DBFilm {

    public static void addActor(Actor actor, Film film){
        film.addCast(actor);
        actor.addFilmtoFilms(film);
        DBHelper.update(actor);
    }
}
