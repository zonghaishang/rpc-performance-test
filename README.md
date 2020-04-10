一、在pom.xml引入测试api facade

二、获取压测工程

1. 获取rpc-performance工程

```shell
git clone https://github.com/zonghaishang/rpc-performance.git
# 本地install依赖和打包
mvn clean install package
```

2. 解压rpc-performance-xx.tar.gz

```shell
tar -xzvf rpc-performance-xx.tar.gz
# 解压后生成rpc.benchmark目录
```

三、开发压测接口实现类(eg: BenchmarkRandom_1k)，并且继承AbstractExchangeRunnable并实现doInvoke方法

参考实现：

```java
public class BenchmarkRandom_1k extends AbstractExchangeRunnable {

    public BenchmarkRandom_1k(InvokeOption option) {
        super(option);
    }

    @Override
    public Object doInvoke() {
        /**
         * 通过serviceFactory获取接口proxy,
         * 如果返回值不为空并且没有异常抛出，认为调用成功.
         */
        BenchmarkService benchmarkService = (BenchmarkService) serviceFactory.getReference(BenchmarkService.class);
        return benchmarkService.send_1k(randomString(1024));
    }
}
```

四、打包本地测试工程执行测试

1. 打包工程

```shell
mvn clean package
```

2. 复制本地测试工程jar到`rpc.benchmark/ext`目录

3. 执行压测

```shell
cd rpc.benchmark
./benchmark.sh
usage: benchmark.sh [options]
 -b,--target <arg>         target benchmark runnable class
 -c,--threads <arg>        The number of concurrent
 -d,--duration <arg>       benchmark running duration(seconds)
 -h,--host <arg>           server host or address
 -p,--port <arg>           server port
 -t,--timeout <arg>        rpc request timeout(milliseconds)
 -tc,--connections <arg>   The number of tcp connection
 -w,--warm-up <arg>        warm up duration(seconds)

# 开始压测, 为了测试结果更准确，建议warm up 30秒.
# 压测工具默认会不统计最后调用10秒
./benchmark.sh -b com.demo.rpc.benchmark.BenchmarkRandom_1k -h 127.0.0.1 -p 20880 -d 300 -w 30
```

五、本项目依赖facade指引

目前测试用facade api包含在开源仓库：

https://github.com/sofastack-guides/sofastack-mesh-demo.git
对应的分支：benchmark

1. 本机进入sofastack-mesh-demo根目录，执行mvn clean install一下

2. 在测试时，可以把dubbo-echo-server注册中心禁用掉，这样本地启动server即可。
```
<dubbo:registry address="N/A"/>
```
