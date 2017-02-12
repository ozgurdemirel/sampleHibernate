package com.sb.data.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "USER_ACCOUNT",
                joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
                inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<User> users = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "account")
    private List<Transaction> transactions=new ArrayList<>();

    @Column(name = "NAME")
    private String name;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

    @Column(name = "OPEN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;
        if (users != null ? !users.equals(account.users) : account.users != null) return false;
        if (transactions != null ? !transactions.equals(account.transactions) : account.transactions != null)
            return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (initialBalance != null ? !initialBalance.equals(account.initialBalance) : account.initialBalance != null)
            return false;
        if (currentBalance != null ? !currentBalance.equals(account.currentBalance) : account.currentBalance != null)
            return false;
        return openDate != null ? openDate.equals(account.openDate) : account.openDate == null;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (initialBalance != null ? initialBalance.hashCode() : 0);
        result = 31 * result + (currentBalance != null ? currentBalance.hashCode() : 0);
        result = 31 * result + (openDate != null ? openDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", users=" + users +
                ", transactions=" + transactions +
                ", name='" + name + '\'' +
                ", initialBalance=" + initialBalance +
                ", currentBalance=" + currentBalance +
                ", openDate=" + openDate +
                '}';
    }

}
