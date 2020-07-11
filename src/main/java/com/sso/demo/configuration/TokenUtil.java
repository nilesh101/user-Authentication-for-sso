package com.sso.demo.configuration;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sso.demo.model.User;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

    private Cache<String, User> cache = null;

    /*Configuration token expiration time. Fetching value from application.properties file*/
    @Autowired
    public TokenUtil(@Value("${TokenExpirationTimeInMinutes}") Integer ExpirationTimeInMinutes){
        cache = CacheBuilder.newBuilder().expireAfterWrite(ExpirationTimeInMinutes, TimeUnit.MINUTES).build();
    }

    public String generateToken(User userProfile) {
        String token = RandomStringUtils.randomAlphanumeric(150);

        /*If use tries to generate new token before token expiry then invalidate old token*/
        cache.asMap().forEach((k, v) -> {
            if(v.equals(userProfile)) {
                cache.invalidate(k);
            }
        });
        cache.put(token, userProfile);
        return token;
    }

    public User getUserProfile(String token) {
        return cache.getIfPresent(token);
    }

    public void invalidateToken(String token) {
        cache.invalidate(token);
    }

}
