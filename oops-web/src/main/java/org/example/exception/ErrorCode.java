package org.example.exception;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
@Data
public class ErrorCode {

    private static JSONObject jb;

    static {
        try {
            ClassPathResource classPathResource = new ClassPathResource("code.json");
            InputStream stream = classPathResource.getInputStream();
            byte[] bytes = IoUtil.readBytes(stream, true);
            String codes = new String(bytes);
            jb =  new JSONObject(codes);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String key) {
        this.code = code;
        this.msg = jb.getStr(key);
    }
}
