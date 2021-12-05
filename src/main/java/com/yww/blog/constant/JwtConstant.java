package com.yww.blog.constant;

/**
 * <p>
 *     JWT的相关常量
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/30 22:53
 **/
public class JwtConstant {

    /**
     * JWT的签发者
     */
    public static final String ISS = "Yw";

    /**
     * token过期时间
     */
    public static final Long EXPIRATION = 604800L;

    /**
     * 携带Token的头部位置
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token的密钥（最好是随机生成的）
     */
    public static final String SECRET = "XK$d58a*OaTVjOrvJ&eCe6Rc5#jR98+d";

}
