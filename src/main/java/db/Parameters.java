package db;

import org.apache.commons.lang3.StringUtils;

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

    private Parameters(Builder builder) {
        id = builder.id;
        name = builder.name;
        state = builder.state;
        page = builder.page;
        orderby = builder.orderby;
        ordering = builder.ordering;
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

    public static final class Builder {
        private Long id;
        private String name;
        private Boolean state;
        private Integer page;
        private String orderby;
        private String ordering;

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
                ", orderering='" + ordering + '\'' +
                '}';
    }
}
