package com.dsczs.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class t2 {
    private static Logger log = LoggerFactory.getLogger(t2.class);

    public static void main(String[] args) {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
    }
}
