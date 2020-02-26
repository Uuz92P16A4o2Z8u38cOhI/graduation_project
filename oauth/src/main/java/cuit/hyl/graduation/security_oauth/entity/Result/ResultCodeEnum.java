package cuit.hyl.graduation.security_oauth.entity.Result;


public enum ResultCodeEnum {
    // 成功
    SUCCESS(200,"请求成功"),

    // 失败
    FAIL(400,"请求失败"),

    LOGIN_FAIL(401,"登录失败"),
    // 未认证（签名错误）
    UNAUTHORIZED(402,"未认证"),

    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器错误");

    public int code;
    public String msg;
    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }
}
