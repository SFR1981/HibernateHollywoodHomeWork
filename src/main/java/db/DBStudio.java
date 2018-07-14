package db;

import models.Director;

import models.Film;
import models.Studio;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudio {
    private static Session session;

    //what do we need to do?
    // give a list of films from a Studio



public static List<Film> getFilmsFromStudio(Studio studio){
    session = HibernateUtil.getSessionFactory().openSession();
    List<Film> films = null;
    try{
        Criteria cr = session.createCriteria(Film.class);
        cr.add(Restrictions.eq( "studio", studio));
        films = cr.list();
}catch (HibernateException e){
        e.printStackTrace();
    }finally {
        session.close();
    }
    return films;
    }

    public static Studio getStudioFromAFilm(Film film) {
    session = HibernateUtil.getSessionFactory().openSession();
    Studio studio = null;
    try{
        Criteria cr = session.createCriteria(Studio.class);
        cr.add(Restrictions.eq("id", film.getStudio().getId()));
        studio = (Studio) cr.uniqueResult();
    }catch (HibernateException e){
        e.printStackTrace();
    }finally {
        session.close();
    }return studio;
    }


    //give a list of actors from a studio
}
