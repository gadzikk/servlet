import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gadzik on 19.12.17.
 */
public class Account {

    private Long id;
    private String email;
    private BigDecimal money;
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", money=" + money +
                '}';
    }
}
