package sust.gaia.controller;

public class LoginService {

    public static void main(String[] args) {

        System.out.println(new LoginService().authenticateUser("Av", "A", "A"));
    }

    public boolean authenticateUser(String userName, String password, String userType) {

        String hql = "from UserDetails where userName='" + userName + "'or email='"+userName+"' and password='" + password + "'";
        if (HibernateUtil.getSessionFactory().openSession().createQuery(hql).uniqueResult() == null) {
            return false;
        }
        return true;
    }

}
