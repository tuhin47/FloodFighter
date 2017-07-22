/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gia.controller;

import org.hibernate.Session;
import sust.gaia.dto.AffectedDist;
import sust.gaia.dto.District;
import sust.gaia.dto.Thana;
import sust.gaia.dto.ThanaDetails;

/**
 *
 * @author Joker
 */
public class Ratio {

    public static double rationFunction(double cum_sum, long population) {
        try {
            double ratio = ((double) population) / cum_sum;
            return ratio;
        } catch (Exception e) {
            return -1.0;
        }
    }

    public static void Main(String[] args) {

    }

    public static long getTotalPopulation(String affectedDist, String thanaName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        District d = (District) session.createQuery("from District where distName='" + affectedDist + "'").uniqueResult();
        session.close();
        for (ThanaDetails t : d.getThana()) {
            if (t.getThana_name().equals(thanaName)) {
                return t.getPopulation();
            }
        }
        return 0;
    }

    public static double getPreviousRelif(String affectedDist, String thanaName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        AffectedDist d = (AffectedDist) session.createQuery("from AffectedDist where distName='" + affectedDist + "'").uniqueResult();
        session.close();
        if (d == null) {
            return 0;
        }
        for (Thana t : d.getAffectedThana()) {
            if (t.getThana_name().equals(thanaName)) {
                return t.getCumulative();
            }
        }
        return 0;
    }

    public static AffectedDist rationGetAffectedDist(String affectedDistName) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        AffectedDist dist= (AffectedDist) session.createQuery("from AffectedDist where distName='"+affectedDistName+"'").uniqueResult();
        session.close();
        return dist;
    }
}
