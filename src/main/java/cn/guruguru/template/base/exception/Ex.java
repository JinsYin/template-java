package cn.guruguru.template.base.exception;


import cn.guruguru.template.base.model.response.code.ICode;
import lombok.Getter;

/**
 * General response exception
 */
@Getter
public class Ex extends RuntimeException {

    private static final long serialVersionUID = 7840341868603278283L;

    private final int code;
    private final String message;

    // ~ constructors --------------------

    public Ex(ICode iCode) {
        super(iCode.getMessage());
        this.code = iCode.getCode();
        this.message = iCode.getMessage();
    }

    public Ex(ICode iCode, String overrideMessage) {
        super(overrideMessage);
        this.code = iCode.getCode();
        this.message = overrideMessage;
    }
}
