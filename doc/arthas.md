[arthas](https://cloud.tencent.com/developer/article/1534894)
# 列举一些 Arthas 的常用命令
```
java -jar arthas-boot.jar
dashboard 当前系统的实时数据面板

thread 查看当前 JVM 的线程堆栈信息

watch 方法执行数据观测

trace 方法内部调用路径，并输出方法路径上的每个节点上耗时

stack 输出当前方法被调用的调用路径

tt 方法执行数据的时空隧道，记录下指定方法每次调用的入参和返回信息，并能对这些不同的时间下调用进行观测

monitor 方法执行监控

jvm 查看当前 JVM 信息

vmoption 查看，更新 JVM 诊断相关的参数

sc 查看 JVM 已加载的类信息

sm 查看已加载类的方法信息

jad 反编译指定已加载类的源码

classloader 查看 classloader 的继承树，urls，类加载信息

heapdump 类似 jmap 命令的 heap dump 功能
```