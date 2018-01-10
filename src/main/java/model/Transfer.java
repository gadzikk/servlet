package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by gadzik on 10.01.18.
 */
public class Transfer {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private BigDecimal transferedMoney;
    private Date creationDate;

    public Transfer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getTransferedMoney() {
        return transferedMoney;
    }

    public void setTransferedMoney(BigDecimal transferedMoney) {
        this.transferedMoney = transferedMoney;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
