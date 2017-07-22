/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sust.gaia.controller;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import sust.gaia.dto.District;
import sust.gaia.dto.ThanaDetails;

/**
 *
 * @author Joker
 */
public class GetDistrictInfo {

    public static List<ThanaDetails> getAllThana() {
        List<District> list1 =getAllDistrictName();
        List<ThanaDetails> list=new ArrayList<ThanaDetails>();
        for (District d : list1) {
//            System.out.println(d.getDistName());
            for(ThanaDetails t:d.getThana()){
               list.add(t);
            }

        }
        return list;

    }

    public static List<District> getAllDistrictName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
		List<District> list = session.createQuery("from District").list();
        session.close();

        return list;
    }


}
