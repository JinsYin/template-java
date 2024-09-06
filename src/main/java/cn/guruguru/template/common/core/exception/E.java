package cn.guruguru.template.common.core.exception;

import cn.guruguru.template.common.core.model.response.code.ICode;
import lombok.Getter;

/**
 * General response exception
 */
@Getter
public class E extends RuntimeException {

    private static final long serialVersionUID = 7840341868603278283L;

    private final int code;
    private final String message;

    // ~ constructors --------------------

    public E(ICode iCode) {
        super(iCode.getMessage());
        this.code = iCode.getCode();
        this.message = iCode.getMessage();
    }

    public E(ICode iCode, String overrideMessage) {
        super(overrideMessage);
        this.code = iCode.getCode();
        this.message = overrideMessage;
    }
}
