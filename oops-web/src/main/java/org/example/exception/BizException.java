package org.example.exception;

import lombok.Data;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
@Data
public class BizException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException() {
        super();
    }


    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg) {
        super(errorCode.toString());
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorCode.toString(), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(ErrorCode err) {
        super(err.getMsg());
        this.errorCode = err.getCode();
        this.errorMsg = err.getMsg();
    }
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }


}
