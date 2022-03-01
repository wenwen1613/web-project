package org.example.filter;

import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author jingwen.li
 * @date 2022/3/1
 *
 * 用于重置request请求参数
 * 例如：request请求参数为加密数据，可在请求到达请求接口之前进行解密，并替换接口对应的明文参数进行请求
 *
 */
public class ParameterRequestWrapper extends ContentCachingRequestWrapper {

    private Map<String, String[]> params = new HashMap<>(16);

    private boolean resetParams = false;

    public ParameterRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
    }

    public ParameterRequestWrapper(HttpServletRequest request, boolean resetParams) throws IOException {
        super(request);
        this.resetParams = resetParams;
        if (resetParams) {
            this.params.putAll(request.getParameterMap());
        }
    }

    public void setResetParams(boolean resetParams) {
        this.resetParams = resetParams;
    }

    void addParameters(Map<String, Object> extraParams) {
        for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
            addParameter(entry.getKey(), entry.getValue());
        }
    }

    private void addParameter(String name, Object value) {
        if (Objects.nonNull(value)) {
            if (value instanceof String[]) {
                params.put(name, (String[]) value);
            } else if (value instanceof String) {
                params.put(name, new String[] { (String) value });
            } else {
                params.put(name, new String[] { String.valueOf(value) });
            }
        }
    }

    @Override
    public String getParameter(String name) {
        if (!resetParams) {
            return super.getParameter(name);
        }
        String[] values = params.get(name);
        if (Objects.isNull(values) || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        if (!resetParams) {
            return super.getParameterValues(name);
        }
        return params.get(name);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        if (!resetParams) {
            return super.getParameterNames();
        }
        return Collections.enumeration(params.keySet());
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        if (!resetParams) {
            return super.getParameterMap();
        }
        return this.params;
    }
}
