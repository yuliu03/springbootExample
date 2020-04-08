package com.scrapy.common;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

public class APIResponse<T> {
    public static final String NOT_INITIALIZED = "not-initialized";
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String VALIDATION_FAIL = "validation-fail";
    public static final String BAD_PARAMETER = "bad-parameter";
    private static Properties DEFAULT_ERROR_MESSAGES = new Properties();
    private static final ReloadableResourceBundleMessageSource i18n = new ReloadableResourceBundleMessageSource();
    private static Locale locale;
    protected String code;
    protected T data;
    protected String message;
    protected Integer total;

    public APIResponse() {
        this("not-initialized", (T) null, (String)null);
    }

    public APIResponse(String code) {
        this(code, (T)null, (String)null);
    }

    public APIResponse(String code, T data) {
        this(code, data, (String)null);
    }

    public APIResponse(String code, T data, String message) {
        this.code = code;
        this.data = data;
        if (message == null) {
            this.message = convertCode2LocaleMessage(code);
        } else {
            this.message = message;
        }

    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static String convertCode2LocaleMessage(String strCode) {
        String message = i18n.getMessage(strCode, (Object[])null, locale);
        if (strCode.equals(message)) {
            message = DEFAULT_ERROR_MESSAGES.getProperty(strCode);
        }

        return message;
    }

    public String convertCode2LocaleMessage(String strCode, Locale locale) {
        return i18n.getMessage(strCode, (Object[])null, locale);
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse("success", data);
    }

    public static APIResponse fail(String message) {
        return new APIResponse("fail", (Object)null, message);
    }

    public static APIResponse<BindingResult> fail(BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap();
        Iterator i$ = bindingResult.getFieldErrors().iterator();

        while(i$.hasNext()) {
            FieldError error = (FieldError)i$.next();
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return new APIResponse("validation-fail", errorMap);
    }

    public static APIResponse response(String code) {
        return new APIResponse(code);
    }

    public static <T> APIResponse<T> response(String code, T data) {
        return new APIResponse(code, data);
    }

    static {
        locale = Locale.SIMPLIFIED_CHINESE;
        DEFAULT_ERROR_MESSAGES.setProperty("success", "API调用成功");
        DEFAULT_ERROR_MESSAGES.setProperty("fail", "API调用失败");
        DEFAULT_ERROR_MESSAGES.setProperty("validation-fail", "请求参数验证失败");
        DEFAULT_ERROR_MESSAGES.setProperty("bad-parameter", "拒绝访问, 请求参数错误");
        String apiResultI18NBasename = System.getProperty("xks.core.mvc.api.i18n.basename");
        if (!StringUtils.hasText(apiResultI18NBasename)) {
            apiResultI18NBasename = "classpath:i18n/api";
        }

        i18n.setBasenames(apiResultI18NBasename.split(","));
        i18n.setDefaultEncoding("utf-8");
        i18n.setUseCodeAsDefaultMessage(true);
        String sLocale = System.getProperty("xks.core.mvc.api.i18n.locale");
        if (StringUtils.hasText(sLocale)) {
            locale = new Locale(sLocale);
        }

    }
}
