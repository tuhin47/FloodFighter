package sust.gia.controller;

import sust.gaia.dto.UserDetails;

public class SignUp {

    public static void main(String[] args) {

        System.out.println(new SignUp().addUser("C", "C", "C", "C"));

    }

    public boolean addUser(String userName, String password, String email, String contact) {

        if (isUserExists(userName, email)) {
            return false;
        }
        UserDetails user = new UserDetails(userName, password, email, contact);
        new BasicControl().insert(user);
        return true;
    }

    private boolean isUserExists(String userName, String email) {

        String hql = "from UserDetails where userName='" + userName + "'or email='" + email + "'";
        if (HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult() == null) {
            return false;
        }
        return true;

    }
}
