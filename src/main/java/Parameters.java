/**
 * Created by gadzik on 18.12.17.
 */
public class Parameters {
    private Long id;

    private Parameters(Builder builder) {
        setId(builder.id);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final class Builder {
        private Long id;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Parameters build() {
            return new Parameters(this);
        }
    }
}
