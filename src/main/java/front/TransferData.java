package front;

import model.Customer;

import java.math.BigDecimal;

/**
 * Created by gadzik on 08.01.18.
 */
public class TransferData {
    private Customer sender;
    private Customer receiver;
    private BigDecimal money;

    private TransferData(Builder builder) {
        setSender(builder.sender);
        setReceiver(builder.receiver);
        setMoney(builder.money);
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }


    public static final class Builder {
        private Customer sender;
        private Customer receiver;
        private BigDecimal money;

        public Builder() {
        }

        public Builder sender(Customer val) {
            sender = val;
            return this;
        }

        public Builder receiver(Customer val) {
            receiver = val;
            return this;
        }

        public Builder money(BigDecimal val) {
            money = val;
            return this;
        }

        public TransferData build() {
            return new TransferData(this);
        }
    }
}
