/**
 * 
 */
package cn.blaze.consts;

/**
 * 返回的系统错误码定义
 */
public enum RetCode {

    /**
     * 成功
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * BAD_PARAMETER
     */
    BAD_PARAMETER(201, "BAD_PARAMETER"),

    UID_NOTEXIST(202, "UID_NOTEXIST"),

    /**
     * NO_LUCKY
     */
    NO_LUCKY(204, "NO_LUCKY"),

    /**
     * BAD_REQUEST
     */
    BAD_REQUEST(400, "BAD REQUEST"),

    /**
     * NOT_LOGIN
     */
    NOT_LOGIN(401, "NOT LOGIN"),

    /**
     * FORBIDDEN
     */
    FORBIDDEN(403, "FORBIDDEN"),
    /**
     * NOT_FOUND
     */
    NOT_FOUND(404, "NOT FOUND"),

    /**
     * ABNORMAL_FREQUENCY
     */
    ABNORMAL_FREQUENCY(411, "ABNORMAL FREQUENCY"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(500, "SERVER ERROR");

    public final int code;

    public final String msg;

    private RetCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RetCode valueOf(int code) {
        for (RetCode rc: RetCode.values()) {
            if (rc.code == code)
                return rc;
        }
        return null;
    }
}
