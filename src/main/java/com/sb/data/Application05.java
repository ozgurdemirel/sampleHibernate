package com.sb.data;

import com.sb.data.entities.Account;
import com.sb.data.entities.Budget;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class Application05 {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();

            Budget budget = new Budget();
            budget.setGoalAmount(new BigDecimal("1400.00"));
            budget.setName("Emergency Fund");
            budget.setPeriod("Yearly");

            com.sb.data.entities.Transaction tx1 = new com.sb.data.entities.Transaction();
            Account account = new Account();
            account.setName("test");
            tx1.setAccount(account);
            tx1.setAmount(BigDecimal.TEN);

            budget.getTransactions().add(tx1);

            session.save(budget);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
