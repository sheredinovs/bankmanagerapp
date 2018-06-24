package bankmanager.model.account;


import bankmanager.model.client.BankClientImpl;

import java.math.BigDecimal;

public interface BankAccount {
    Integer getId();
    BankClientImpl getClient();
    BigDecimal getAmountOfMoney();
}
