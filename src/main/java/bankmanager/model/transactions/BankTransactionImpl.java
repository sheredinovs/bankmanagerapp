package bankmanager.model.transactions;

import bankmanager.model.account.BankAccountImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BankTransactionImpl implements BankTransaction {
    private static final Logger LOG = LoggerFactory.getLogger(BankTransactionImpl.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private BankAccountImpl bankAccount;

    private Date transactionDate;

    @OneToOne
    private BankAccountImpl accountFrom;

    @OneToOne
    private BankAccountImpl accountTo;


    public BankTransactionImpl(BankAccountImpl bankAccount, Date transactionDate) {
        this.bankAccount = bankAccount;
        this.transactionDate = transactionDate;
    }

    @Override
    public Integer getId(){
        return id;
    }

    @Override
    public BankAccountImpl getAccount() {
        return bankAccount;
    }

    @Override
    public Date getCreatedDate() {
        return transactionDate;
    }

    @Override
    public BankAccountImpl getAccountFrom() {
        return accountFrom;
    }

    @Override
    public BankAccountImpl getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(BankAccountImpl accountTo){
        this.accountTo = accountTo;
    }

    public void setAccountFrom(BankAccountImpl accountFrom){
        this.accountFrom = accountFrom;
    }
}
