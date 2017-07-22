/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Session;
import sust.gaia.dto.AffectedDist;
import sust.gaia.dto.Thana;

/**
 *
 * @author Joker
 */
public class AffectedPlaces {

    public static void main(String[] args) {
        for (Thana t : sortedThanaList()) {
            System.out.println(t.getThana_name() + " " + t.getRatio());
        }

    }

    public static List<AffectedDist> listOfAffectedDist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
		List<AffectedDist> list = session.createQuery("from AffectedDist").list();
        session.close();
        return list;

    }

    public static List<Thana> sortedThanaList() {
        List<AffectedDist> affList = listOfAffectedDist();
        List<Thana> list = new ArrayList<Thana>();
        for (AffectedDist a : affList) {
            for (Thana t : a.getAffectedThana()) {
                list.add(t);
            }
        }
        Collections.sort(list, new Comparator<Thana>() {
            public int compare(Thana a1, Thana a2) {
                return (int) (a2.getRatio() - a1.getRatio());
            }
        });

        return list;
    }

}
