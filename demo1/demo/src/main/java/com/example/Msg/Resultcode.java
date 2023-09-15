package com.example.Msg;

public  enum Resultcode {

    BAD_REQUEST(400,"其他错误"),
    PARAM_IS_INVALID(401,"参数无效"),
    USER_NOT_EXIST(402, "账号不存在"),
    PASSWORD_ERROR(403, "账号密码错误"),
    SUCCESS(200,"登录成功"),
    ID_NOT_EXIST(404,"id不存在");

    private Integer code;
    private String message;

    Resultcode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
