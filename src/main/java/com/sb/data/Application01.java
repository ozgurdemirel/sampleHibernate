package com.sb.data;

import com.sb.data.entities.Credential;
import com.sb.data.entities.User;
import org.hibernate.Session;
import java.util.Date;

public class Application01 {

    public static void main(String[] args) {
        //1       finito
        //        Session session =HibernateUtil.getSessionFactory().openSession();
        //        session.beginTransaction();
        //        session.close();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("isim");
        user.setEmailAddress("email@email.com");
        user.setFirstName("isim");
        user.setLastName("soyisim");
        user.setLastUpdatedBy("isim");
        user.setLastUpdatedDate(new Date());
        user.setCreatedDate(new Date());

        Credential credential = new Credential();
        credential.setPassword("password");
        credential.setUsername("username");

        credential.setUser(user);//...
        user.setCredential(credential);

        session.save(credential);


        User dbUser =(User) session.get(User.class,credential.getUser().getUserId());
        System.out.println("-------- sb ----------");
        System.out.println(dbUser.getFirstName());
        System.out.println(dbUser.getCredential().getPassword());

        session.getTransaction().commit();
        session.close();
    }

}
