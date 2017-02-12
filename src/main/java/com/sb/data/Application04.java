package com.sb.data;

import com.sb.data.entities.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class Application04 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Account account = new Account();
            account.setName("test account");
            account.setOpenDate(new Date());
            account.setCurrentBalance(BigDecimal.ONE);
            account.setInitialBalance(BigDecimal.TEN);

            com.sb.data.entities.Transaction t1=new com.sb.data.entities.Transaction();
            t1.setLastUpdatedBy("lastUpdatedBy");//doldurabilirsin
            account.getTransactions().add(t1);

            session.save(account);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
