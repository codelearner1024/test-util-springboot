package com.wwg.bitcalc;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @类描述: 二进制计算
 * @Author wwg
 * @date: 2020/11/24 13:29
 * @Version: 1.0
 **/
public class TestBitCalc {

    public static final Logger LOG = LoggerFactory.getLogger(TestBitCalc.class);
    // runState bits: SHUTDOWN must be negative, others arbitrary powers of two
    private static final int  RSLOCK     = 1;
    private static final int  RSIGNAL    = 1 << 1;
    private static final int  STARTED    = 1 << 2;
    private static final int  STOP       = 1 << 29;
    private static final int  TERMINATED = 1 << 30;
    private static final int  SHUTDOWN   = 1 << 31;

    @Test
    public void test1(){
        LOG.info("RSLOCK:{}",RSLOCK);
        LOG.info("RSIGNAL:{}",RSIGNAL);
        LOG.info("STARTED:{}",STARTED);
        LOG.info("STOP:{}",STOP);
        LOG.info("TERMINATED:{}",TERMINATED);
        LOG.info("SHUTDOWN:{}",SHUTDOWN);

    }
}
