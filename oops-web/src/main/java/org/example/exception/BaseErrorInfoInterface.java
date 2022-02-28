package org.example.exception;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
public interface BaseErrorInfoInterface {
    /** 错误码*/
    Integer getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
