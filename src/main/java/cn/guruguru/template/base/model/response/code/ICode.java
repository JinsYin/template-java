package cn.guruguru.template.base.model.response.code;

/**
 * Copied from {@code CodeI}
 *
 * @author rqyin
 */
public interface ICode {

    String CODE = "code";
    String MESSAGE = "message";

    int getCode();

    String getMessage();
}
