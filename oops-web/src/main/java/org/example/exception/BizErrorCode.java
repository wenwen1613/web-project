package org.example.exception;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
public interface BizErrorCode {

    ErrorCode AUTH_USERNAME_ERROR = new ErrorCode(30000, "auth.username.error");
    ErrorCode NULL_POINTER_ERROR = new ErrorCode(30001, "null.pointer.error");
    ErrorCode UNKNOWN_ERROR = new ErrorCode(40000, "unknown.error");
}
