/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.rpc.benchmark;

import com.opensource.rpc.benchmark.RpcBenchmarkClient;

/**
 *
 * program arguments:
 * -b com.demo.rpc.benchmark.BenchmarkRandom_1k -h 127.0.0.1 -p 20880 -d 60 -w 30 -tc 10 -c 2
 *
 * @author yiji
 * @version : Main.java, v 0.1 2020年04月10日 2:58 下午 yiji Exp $
 */
public class DebugBenchmarkMain {
    public static void main(String[] args) throws Exception {
        new  RpcBenchmarkClient().run(args);
    }
}