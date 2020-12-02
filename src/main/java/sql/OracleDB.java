package sql;

import model.Dot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;


public class OracleDB
{
    private final SessionFactory factory;

    public OracleDB()
    {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    public void addDot(Dot dot)
    {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(dot);
        transaction.commit();
        session.close();
    }

    public LinkedList<Dot> getDots()
    {
        LinkedList<Dot> dots = new LinkedList<>();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("FROM " + Dot.class.getSimpleName()).list();

        for(Object object : list)
        {
            Dot dot = (Dot)object;
            dots.add(dot);
        }

        transaction.commit();
        session.close();

        return dots;
    }
}
