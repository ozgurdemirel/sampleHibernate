package com.sb.data;

import com.sb.data.entities.Account;
import com.sb.data.entities.Credential;
import com.sb.data.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.Date;

public class Application06 {

    public static void main(String[] args) {
        //user and account many to many relations
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();

            Account account1 = account1();
            Account account2 = account2();

            User user1 = user1();
            User user2 = user2();
//
//            account1.getUsers().add(user1);
//            account1.getUsers().add(user2);
//
//            account2.getUsers().add(user1);
//            account2.getUsers().add(user2);

            user1.getAccounts().add(account1);
            user1.getAccounts().add(account2);

            user2.getAccounts().add(account1);
            user2.getAccounts().add(account2);

            session.save(user1);
            session.save(user2);

            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

    private static User user1(){
        User user = new User();
        user.setFirstName("ozgur");
        user.setLastName("demirel");
        user.setBirthDate(new Date());
        user.setEmailAddress("email@pismail.com");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("ozgur");
        user.setCreatedBy("ozgur");
        user.setCreatedDate(new Date());
        user.setAge(19);

        Credential credential1=new Credential();
        credential1.setUsername("ozg3ur");
        credential1.setPassword("123456");
        user.setCredential(credential1);
        return user;
    }


    private static User user2(){
        User user = new User();
        user.setFirstName("ozgur22");
        user.setLastName("demire22l");
        user.setBirthDate(new Date());
        user.setEmailAddress("email22@p22ismail.com");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("ozgur22");
        user.setCreatedBy("ozg222ur");
        user.setCreatedDate(new Date());
        user.setAge(21);

        Credential credential1=new Credential();
        credential1.setUsername("o2zgur");
        credential1.setPassword("1223456");
        user.setCredential(credential1);
        return user;
    }

    private static Account account1(){
        Account account = new Account();
        account.setName("accountname1x");
        account.setInitialBalance(BigDecimal.TEN);
        account.setCurrentBalance(BigDecimal.TEN);
        account.setOpenDate(new Date());
        return account;
    }

    private static Account account2(){
        Account account = new Account();
        account.setName("accountname2");
        account.setInitialBalance(BigDecimal.TEN);
        account.setCurrentBalance(BigDecimal.TEN);
        account.setOpenDate(new Date());
        return account;
    }



}
