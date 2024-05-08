package cn.guruguru.template.common.model.response.code;


import lombok.Getter;

/**
 * General HTTP response code
 *
 * @see org.springframework.http.HttpStatus
 */
@Getter
public enum RCode implements ICode {

    CODE200(200, "成功"),
    CODE400(400, "客户端请求有误"), // 如请求体的 JSON 格式有误
    CODE401(401, "未通过身份验证"),
    CODE403(403, "不具有访问资源的权限"),
    CODE404(404, "请求的资源不存在"),
    CODE405(405, "不允许使用该请求方式"),
    CODE408(408, "请求超时"),
    CODE413(413, "请求体过大"),
    CODE414(414, "请求地址过长"),
    CODE415(415, "媒体类型不支持"),
    CODE429(429, "请求次数超过限额"),
    CODE431(431, "请求头过大"),
    CODE500(500, "服务器遇到未知问题"),
    CODE503(503, "服务器正在维护"),
    CODE504(504, "网关超时"),

    // 通用业务码
    ALREADY_EXISTS(10001, "记录已存在"),
    NON_EXISTENT(10002, "记录不存在"),
    VALIDATOR_ERROR(10003, "验证器使用错误"),
    OPERATION_FAILED(10004, "操作失败"),
    UNSUPPORTED_OPERATION(10005, "不支持的操作类型"),
    NO_DATA_CHANGE(10006, "没有数据变化"),
    PARAM_ERROR(10007, "参数错误"),
    JSON_FORMAT_ERROR(10008, "JSON 格式转换错误"),
    ROUTE_FORMAT_ERROR(10009, "路由格式错误"),
    DELETE_NO_RECORDS(10010, "没有记录被删除"),
    ;

    private final int code;
    private String message;

    RCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * (Optional) modify message.
     *
     * @param message exception message
     * @return a {@link RCode}
     */
    public RCode setMessage(String message) {
        this.message = message;
        return this;
    }
}
