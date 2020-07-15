/**
 * @author: 张晗修
 * @version: v1.0
 * @description: 用于token的加密，目前还没用上
 */

package com.neusoft.bsp.common.util;

import io.jsonwebtoken.*;

import java.util.Date;

public class TokenUtil {
    private static final String secret = "secret";
    public static final String tokenHeard = "tokenHead";
    private static final Long expTime = 60 * 5 * 1000L;

    public static String getToken(String name,String id,String ip) {
        JwtBuilder builder = Jwts.builder();
        builder.signWith(SignatureAlgorithm.HS256,secret);
        builder.setId(id).setSubject(name).setAudience(ip);
        builder.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expTime));
        String token = builder.compact();
        return token;
    }

    public static Claims getTokenBody(String token) {
        JwtParser parser = Jwts.parser();
        Claims body = parser.setSigningKey(secret).parseClaimsJws(token).getBody();
        return body;
    }

    public static String getName(String token) {
        Claims body = getTokenBody(token);
        String id = body.getId();
        return id;
    }
}
