package db;

import models.Actor;
import models.Film;
import models.Genre;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBActor {

    private static Session session;



    public static List<Film> getFilmsByActor(Actor actor){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("cast","actor" );
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            films = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return films;
    }


    public static List<Film> getFilmsByGenre(Actor actor, Genre genre){
        List<Film> films = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Film.class);
            cr.createAlias("cast","actor" );
            cr.add(Restrictions.eq("actor.id", actor.getId()));
            cr.add(Restrictions.eq("genre", genre));
            films = cr.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
            return films;
        }


    }



