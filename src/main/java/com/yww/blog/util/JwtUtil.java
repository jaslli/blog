package com.yww.blog.util;

import com.yww.blog.constant.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 *     JWT的工具类
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/3 17:12
 **/
@Data
@Component
public class JwtUtil {

    /**
     * 生成JWT
     * @param username 用户名
     * @return  token
     */
    public String createToken(String username) {
        Date now = new Date();
        return Jwts.builder()
                // 设置JWT的头部信息(header)
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS512")
                // 设置JWT载荷信息(playload)
                .setIssuer(JwtConstant.ISS)
                .setSubject(username)
                // TODO 过期时间交给redis统一管理
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + JwtConstant.EXPIRATION * 1000))
                // 签名(signature)
                .signWith(SignatureAlgorithm.HS512, JwtConstant.SECRET)
                .compact();
    }

    /**
     * 解析JWT
     * @param jwt token
     * @return Claims
     */
    public Claims getClaimsByToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(JwtConstant.SECRET)
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param claims token信息
     * @return true Or false
     */
    public boolean isExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }

}
