package com.wulong.project.tool;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtUtils {
  
    public static final String JWT_SECERT = "wulong_fast_word";
      
    /** 
     * 使用对称加密来生成key
     * @return 
     */  
    public static SecretKey generalKey() {
        String encodeKey = Base64.encode(JWT_SECERT.getBytes());
        SecretKey key = new SecretKeySpec(encodeKey.getBytes(), 0, encodeKey.length(), "AES");
        return key;  
    }  
      
    /** 
     * 签发JWT token
     *  
     * @param jti jwt的唯一身份标识,主要用来作为一次性token,从而回避重放攻击 
     * @param sub jwt所面向的用户 
     * @param expiredTime 过期时间,单位ms
     * @return 
     */  
    public static String createJWT(String jti, String sub, long expiredTime) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Long nowMillis = System.currentTimeMillis();  
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();  
        JwtBuilder builder = Jwts.builder()
                .claim("name", "wulong") // 自定义声明(可以定义多个,也可以不定义)
                .setId(jti)  	//设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setSubject(sub)  //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setIssuedAt(now) // jwt的签发时间
                .signWith(signatureAlgorithm, secretKey);
        if (expiredTime >= 0) {
        	long expMillis = nowMillis + expiredTime;
            Date expDate = new Date(expMillis);  
            builder.setExpiration(expDate);  // token过期时间
        }  
        return builder.compact();  
    }  
      
    /** 
     * 校验jwtStr 
     *  
     * @param jwtStr 
     * @return 
     * @throws ExpiredJwtException,SignatureException,Exception token已过期,签名校验失败,其它错误 
     */  
    public static boolean validateJWT(String jwtStr) {  
        boolean flag = false;  
        try {  
            parseJWT(jwtStr);  
            flag = true;  
        } catch (ExpiredJwtException e) {
            // TODO 可以用日志来记录错误信息  
        } catch (SignatureException e) {
            // TODO 可以用日志来记录错误信息  
        } catch (Exception e) {  
            // TODO 可以用日志来记录错误信息  
        }  
        return flag;  
    }  
      
    /** 
     *  
     * 解析JWT字符串 
     *  
     * @param jwt 
     * @return claims,包括公告声明,自定义声明 
     * @throws ExpiredJwtException,SignatureException,Exception token已过期,签名校验失败,其它错误 
     */  
    public static Claims parseJWT(String jwt) throws ExpiredJwtException,SignatureException,Exception {
        SecretKey secretKey = generalKey();  
        return Jwts.parser()  
            .setSigningKey(secretKey)  
            .parseClaimsJws(jwt)  
            .getBody();  
    }  
      
    public static void main(String[] args) throws Exception {
        String jwtString = createJWT("1001", "1001", 10000);
        System.out.println(jwtString);

        /*String jwtString = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoid3Vsb25nIiwianRpIjoiMTAwMSIsInN1YiI6IjEwMDEiLCJpYXQiOjE1NDI2MTczODAsImV4cCI6MzA4NTIzNDc3MX0._vtA9p7dCflY9usm5uJ0I1AT8cGqn3Ldj-k--e6Hr5Y";
      Claims claims = parseJWT(jwtString);
      System.out.println(claims.getId());
      System.out.println(claims.getSubject());
      System.out.println(claims.get("name")); // 自定义的
          
        try {  
            System.out.println(parseJWT(jwtString));  
        } catch (ExpiredJwtException e) {  
            System.out.println("token已过期");  
        } catch (SignatureException e) {  
            System.out.println("签名校验失败");  
        } catch (Exception e) {  
            System.out.println("其它错误");  
        } */
  
    }  
  
}  