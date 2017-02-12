package com.sb.data;

import com.sb.data.entities.Address;
import com.sb.data.entities.Bank;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Application02 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Bank bank = new Bank();
            bank.setName("Garanti Bankasi");
            bank.setAddresss(new Address(
                    "address line 1",
                    "address line 2",
                    "city",
                    "state",
                    "zipCode"
            ));
            bank.setCreatedBy("Ozgur DEMIREL");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("Ozgur DEMIREL");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            bank.getContacts().put("TYPE1","CONTACT");
            bank.getContacts().put("TYPE2","CONTACT2");
            bank.getContacts().put("TYPE3","CONTACT3");


            session.save(bank);

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private static class Employee {
    }
}
