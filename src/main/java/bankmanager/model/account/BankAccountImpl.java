package bankmanager.model.account;


import bankmanager.model.client.BankClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class BankAccountImpl implements BankAccount{
    private static final Logger LOG = LoggerFactory.getLogger(BankAccountImpl.class);

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private BankClientImpl bankClient;

    @Column(columnDefinition = "DECIMAL(5,4)")
    private BigDecimal amountOfMoney;

    public BankAccountImpl(BankClientImpl client, BigDecimal amountOfMoney) {
        this.bankClient = client;
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public BankClientImpl getClient() {
        return bankClient;
    }

    @Override
    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccountImpl)) return false;

        BankAccountImpl that = (BankAccountImpl) o;

        if (!id.equals(that.id)) return false;
        if (!bankClient.equals(that.bankClient)) return false;
        return amountOfMoney.equals(that.amountOfMoney);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + bankClient.hashCode();
        result = 31 * result + amountOfMoney.hashCode();
        return result;
    }

}
