package hibernate_ders_4;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by halil on 15.09.2014.
 */
@Embeddable
public class CompoundKey implements Serializable {


    private int userId;
    private int accountId;


    public CompoundKey() {
    }

    public CompoundKey(int userId, int accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
