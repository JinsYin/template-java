package cn.guruguru.template.common.core.model.response;

import cn.guruguru.template.common.core.model.response.code.ICode;
import cn.guruguru.template.common.core.model.response.code.RCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * General HTTP response body that replaces the {@code RestResult}.
 *
 * @param <T> class to wrap
 */
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = -9077101179240111237L;

    // ~ fields -----------------------------------

    // 使用 Integer（默认值为 null）代替 int（默认值为 0），可以防止在没有设置 code 时响应默认值 0，
    // 而使用 Integer 会响应 null，并且可以配置 Jackson 以不响应 null
    @ApiModelProperty(value = "业务码", required = true)
    private Integer code;

    @ApiModelProperty(value = "响应信息", required = true)
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;

    // ~ constructors ------------------------------
    public R(Integer code, String message) {
        this(code, message, null);
    }

    public R(Integer code, T data) {
        this(code, null, data);
    }

    public R(ICode iCode) {
        this(iCode.getCode(), iCode.getMessage(), null);
    }

    // -------------------------------------------------------
    // Static builder methods for enhancing semantics.
    // Inspired by the RestResultUtils and the ResponseEntity.
    // -------------------------------------------------------

    // code:200
    public static <T> R<T> ok() {
        return R.<T>builder().withCode(RCode.CODE200.getCode()).build();
    }

    // code:200, data:{}
    public static <T> R<T> ok(T data) {
        return R.<T>builder().withCode(RCode.CODE200.getCode()).withData(data).build();
    }

    // code:200, message:{}
    public static <T> R<T> success() {
        return R.<T>builder().withICode(RCode.CODE200).build();
    }

    // code:200, message:{}, data:{}
    public static <T> R<T> success(T data) {
        return R.<T>builder().withICode(RCode.CODE200).withData(data).build();
    }

    // code:400, message:{}
    public static <T> R<T> failed() {
        return R.<T>builder().withCode(RCode.CODE400.getCode()).build();
    }

    // code:400, message:{message}
    public static <T> R<T> failed(String message) {
        return R.<T>builder()
                .withCode(RCode.CODE400.getCode())
                .withMessage(message)
                .build();
    }

    // code:500, message:{}
    public static <T> R<T> error() {
        return R.<T>builder().withICode(RCode.CODE500).build();
    }

    // code:500, message:{message}
    public static <T> R<T> error(String message) {
        return R.<T>builder()
                .withCode(RCode.CODE500.getCode())
                .withMessage(message)
                .build();
    }

    // code:{code}, message:{message}
    public static <T> R<T> exception(Integer code, String message) {
        return R.<T>builder().withCode(code).withMessage(message).build();
    }

    // code:{code}, message:{message}
    public static <T> R<T> exception(ICode iCode) {
        return R.<T>builder()
                .withCode(iCode.getCode())
                .withMessage(iCode.getMessage())
                .build();
    }

    // code:{code}, message:{message}
    public static <T> R<T> exception(ICode iCode, String message) {
        return R.<T>builder().withCode(iCode.getCode()).withMessage(message).build();
    }

    // ~ builder ------------------------------

    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

    public static final class Builder<T> {

        private Integer code;
        private String message;
        private T data;

        private Builder() {}

        public Builder<T> withCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> withICode(ICode iCode) {
            this.code = iCode.getCode();
            this.message = iCode.getMessage();
            return this;
        }

        public Builder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public R<T> build() {
            return new R<>(code, message, data);
        }
    }
}

