package bankmanager.model.transactions;


import bankmanager.model.account.BankAccountImpl;

import java.util.Date;

public interface BankTransaction {
    Integer getId();
    BankAccountImpl getAccount();
    Date getCreatedDate();
    BankAccountImpl getAccountFrom();
    BankAccountImpl getAccountTo();
}
