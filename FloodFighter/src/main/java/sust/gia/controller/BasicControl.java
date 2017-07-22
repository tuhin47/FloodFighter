package sust.gia.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import sust.gaia.dto.District;

/**
 *
 * @author Joker
 */
public class BasicControl {

   
    public District returnExistedDist(String distName){
        Session session=HibernateUtil.getSessionFactory().openSession();
        District d= (District) session.createQuery("from District where distName='" + distName + "'").uniqueResult();
        session.close();
        return d;
    }
    public void insert(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(obj);
        session.getTransaction().commit();
        session.close();
    }

    public List provideList(String name) {
        return HibernateUtil.getSessionFactory().openSession().createQuery("from " + name).list();
    }

    public static boolean isTheParameterValid(HttpServletRequest request, String parameter) {

        return request.getParameterMap().containsKey(parameter);
    }


}
