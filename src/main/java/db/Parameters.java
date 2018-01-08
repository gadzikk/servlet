package db;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by gadzik on 18.12.17.
 */
public class Parameters {
    private Long id;
    private String name;
    private Boolean state;
    private Integer page;
    private String orderby;
    private String ordering;
    private String email;
    private String password;
    private Long senderId;
    private Long receiverId;
    private BigDecimal money;

    private Parameters(Builder builder) {
        id = builder.id;
        name = builder.name;
        state = builder.state;
        page = builder.page;
        orderby = builder.orderby;
        ordering = builder.ordering;
        email = builder.email;
        password = builder.password;
        senderId = builder.senderId;
        receiverId = builder.receiverId;
        money = builder.money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getOrdering() {
        return ordering;
    }

    public void ordering(String ordering) {
        this.ordering = ordering;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Boolean state;
        private Integer page;
        private String orderby;
        private String ordering;
        private String email;
        private String password;
        private Long senderId;
        private Long receiverId;
        private BigDecimal money;

        public Builder() {
        }

        public Builder id(String val) {
            if (val != null) {
                id = Long.valueOf(val);
            }
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder state(String val) {
            if (val != null)
                state = Boolean.valueOf(val);
            return this;
        }

        public Builder page(String val) {
            page = 1;
            if (StringUtils.isNotBlank(val)) {
                page = Integer.parseInt(val);
            }
            return this;
        }

        public Builder orderby(String val) {
            orderby = "id";
            if (StringUtils.isNotBlank(val)) {
                orderby = val;
            }
            return this;
        }

        public Builder ordering(String val) {
            ordering = "asc";
            if (StringUtils.isNotBlank(val)) {
                ordering = val;
            }
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder senderId(String val) {
            if (StringUtils.isNotBlank(val)) {
                senderId = Long.parseLong(val);
            }
            return this;
        }

        public Builder receiverId(String val) {
            if (StringUtils.isNotBlank(val)) {
                receiverId = Long.parseLong(val);
            }
            return this;
        }

        public Builder money(String val) {
            money = BigDecimal.ZERO;
            if (StringUtils.isNotBlank(val)) {
                money = new BigDecimal(val);
            }
            return this;
        }

        public Parameters build() {
            return new Parameters(this);
        }
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", page=" + page +
                ", orderby='" + orderby + '\'' +
                ", ordering='" + ordering + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", money=" + money +
                '}';
    }
}
