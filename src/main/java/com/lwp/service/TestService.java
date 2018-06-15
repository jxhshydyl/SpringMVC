package com.lwp.service;

import com.lwp.dao.TestDao;
import com.lwp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {
    @Autowired
    TestDao testDao;
    @Autowired
    RedisTemplate redisTemplate;

    @Transactional
    public int addUser(User user){
        testDao.insert(user);
        int i = testDao.insert(user);
        redisTemplate.opsForHash().put("qw","qw","12");
        this.redisTemplate.expire("qw",60, TimeUnit.SECONDS);
        boolean ishas = redisTemplate.hasKey("qw");
        String str=(String)redisTemplate.opsForHash().get("qw","qw");
        System.out.println("取出的字符串为："+str);
        redisTemplate.opsForValue().set("sd",1L);
        RedisAtomicLong redisAtomicLong=new RedisAtomicLong("sd", redisTemplate.getConnectionFactory());
        //Long num =  redisAtomicLong.getAndIncrement();
        long l = redisAtomicLong.get();
        Long strs = (Long)redisTemplate.opsForValue().get("sd");
        System.out.println(l);
        //System.out.println(num);
        System.out.println(ishas);
        return i;
    }
}
