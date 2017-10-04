package com.zhang.Controller;

import com.zhang.utils.CommonUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class AppController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected RedisTemplate redisTemplate1;

    @GetMapping(value = "/t1", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String t1() {
        return CommonUtils.toStr("ab");
    }

    @GetMapping(value = "/t2")
    @ResponseBody
    public String t2() {
        for (int i = 0; i < 1000; i++) {
            redisTemplate1.opsForList().rightPush("logstash:redis", UUID.randomUUID().toString());
        }
        return "";
    }

    @GetMapping(value = "/t3")
    @ResponseBody
    public String t3() {
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");
        return "success";
    }

    @Test
    public void t4() {
        logger.debug("DEBUG TEST 这个地方输出DEBUG级别的日志");
        logger.info("INFO test 这个地方输出INFO级别的日志");
        logger.error("ERROR test 这个地方输出ERROR级别的日志");
        int i = 0;
        try {
            i = 1 / 0;
        } catch (Exception e) {
            logger.error("mddFileUploadAndUpdateInfo error, {}, \r\n {}", null, e);
        }
    }

}
