package db;

import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFilm {

    private static Session session;
    public static void addActor(Actor actor, Film film){
        film.addCast(actor);
        actor.addFilmtoFilms(film);
        DBHelper.update(actor);
    }

    public static Director getDirectorByFilm(Film film) {

        session = HibernateUtil.getSessionFactory().openSession();
        Director director = null;
        try{
            Criteria cr = session.createCriteria(Director.class);
            cr.add(Restrictions.eq("id", film.getDirector().getId()));
            director = (Director) cr.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }return director;
    }

    public static List<Film> getFilmsFromDirector(Director director) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = null;
        try{
            Criteria cr = session.createCriteria(Film.class);
            cr.add(Restrictions.eq( "director", director));
            films = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return films;
    }

    }

