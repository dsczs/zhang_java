package com.zhang.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/8/12.
 */
public class Test1 {

    private static final Logger log = LoggerFactory.getLogger(Test1.class);

    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";

        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }

    @Test
    public void t1() {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("Test1 error, {}, \r\n {}", null, e);
        }
        log.error("======error");
    }
}
