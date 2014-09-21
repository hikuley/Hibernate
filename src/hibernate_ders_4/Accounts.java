package hibernate_ders_4;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by halil on 15.09.2014.
 */

@Entity
public class Accounts implements Serializable {


    @Id
    private CompoundKey compoundKey;

    private int accountBalnce;


    public Accounts() {
    }

    public CompoundKey getCompoundKey() {
        return compoundKey;
    }

    public void setCompoundKey(CompoundKey compoundKey) {
        this.compoundKey = compoundKey;
    }

    public int getAccountBalnce() {
        return accountBalnce;
    }

    public void setAccountBalnce(int accountBalnce) {
        this.accountBalnce = accountBalnce;
    }
}
