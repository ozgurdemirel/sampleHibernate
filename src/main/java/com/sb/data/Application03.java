package com.sb.data;

import com.sb.data.entities.Address;
import com.sb.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Application03 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setAge(23);
            user.setBirthDate(new Date());
            user.setCreatedBy("Ozgur");
            user.setCreatedDate(new Date());
            user.setEmailAddress("email@address.com");
            user.setFirstName("ozgur");
            user.setLastName("demirel");
            user.setLastUpdatedBy("ozgur");
            user.setLastUpdatedDate(new Date());
            user.getAddress().add(new Address("a1","a2","city","state","zip"));
            user.getAddress().add(new Address("a22","a22","city22","state22","zip22"));
            session.save(user);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
