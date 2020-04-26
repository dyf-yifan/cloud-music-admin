package com.soft1851.music.admin.util;

/**
 * @ClassName TestJWT
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/23
 * @Version 1.0
 */
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class TestJwt {
    final String SECRET = "sr4mkbbr4wdy45974s94l3squ0wtpf15";

    public static  String verify(String token) {
        try {
            token = encode();
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("sr4mkbbr4wdy45974s94l3squ0wtpf15")).withIssuer("TestAuth").build();

            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("email").asString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String encode() {
        try {

            return JWT.create().withIssuer("TestAuth").withIssuedAt(new Date()).withClaim("email", "TEST@TESTTEST.de").sign(getAlgorithm());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    private static Algorithm getAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("sr4mkbbr4wdy45974s94l3squ0wtpf15");
    }

    public static void main(String[] args) {
        String encode = encode();
        System.out.println(encode);
        System.out.println(verify(encode));
    }
}