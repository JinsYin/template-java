package cn.guruguru.template.base.model.response;


import cn.guruguru.template.base.model.pagination.PaginationResult;
import cn.guruguru.template.base.model.response.code.ICode;
import cn.guruguru.template.base.model.response.code.RCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

/**
 * General HTTP response body that contains total and collections.
 *
 * @param <T> class to wrap
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rz<T> implements Serializable {

    private static final long serialVersionUID = -2733521975979569235L;

    @ApiModelProperty(value = "业务码", required = true)
    private Integer code;

    @ApiModelProperty(value = "响应集合总条数", required = true)
    private Number total; // Long or Integer

    @ApiModelProperty(value = "响应集合数据", required = true)
    private Collection<T> data;

    // ~ static methods ------------------

    public static <T> Rz<T> ok(PaginationResult<T> data) {
        return Rz.<T>builder()
                .withCode(RCode.CODE200)
                .withTotal(data.getTotal())
                .withData(data.getCollection())
                .build();
    }

    public static <T> Rz<T> ok(Number total, Collection<T> data) {
        return Rz.<T>builder()
                .withCode(RCode.CODE200)
                .withTotal(total)
                .withData(data)
                .build();
    }

    public static <T> Rz<T> of(Integer code, Long total, Collection<T> data) {
        return Rz.<T>builder().withCode(code).withTotal(total).withData(data).build();
    }

    // ~ builder -------------------------

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private Integer code = RCode.CODE200.getCode();
        private Number total;
        private Collection<T> data;

        public Builder<T> withCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> withCode(ICode iCode) {
            this.code = iCode.getCode();
            return this;
        }

        public Builder<T> withTotal(Number total) {
            this.total = total;
            return this;
        }

        public Builder<T> withData(Collection<T> data) {
            this.data = data;
            return this;
        }

        public Rz<T> build() {
            return new Rz<>(code, total, data);
        }
    }
}
