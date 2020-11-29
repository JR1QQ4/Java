## Java 

Java的设计者已经写了颇有影响力的“白皮书”，用来解释设计的初衷以及完成的情况，并且发布了一个简短的摘要。

摘要可以用11个关键术语进行组织：
1. 简单性，Java语法是C++语法的一个“纯净”版本
2. 面向对象
3. 分布式
4. 健壮性
5. 安全性
6. 体系结构中立
7. 可移植性
8. 解释型
9. 高性能
10. 多线程
11. 动态性

Java发展简史：
- 1991年想要设计一种小型的计算机语言，这个项目被命名为“Green”
- 1992年Creen项目发布了第一个产品“*7”
- 1994年项目解散，当时Internet发展壮大，用Java开发- 浏览器
- 1996年Sun发布了Java的第1个版本
- 1998年 Java 1.2版本，市场部改名“Java2标准版软件开发工具箱1.2版”，此外还有用于手机等嵌入式设备的“微型版”，用于服务器处理的“企业版”
- 2004年 Java 1.5做了重大改进，添加了泛型等，版本数字升至5.0
- 2006年版本6（没有后缀.0）
- 2009年Oracle收购Sun
- 2011年Oracle发布了Java 7
- 2014年Java 8发布，提供了一种“函数式”编程方法

Java语言的发展状况：
- 1996，1.0特性：语言本身，类与接口的数量：211
- 1997，1.1特性：内部类，类与接口的数量：477
- 1998，1.2特性：strictfp修饰符，类与接口的数量：1524
- 2000，1.3特性：无，类与接口的数量：1840
- 2002，1.4特性：断言，类与接口的数量：2723
- 2004，5.0特性：泛型类、for each、可变元参数、自动装箱、元数据、枚举、静态导入，类与接口的数量：3279
- 2006，6特性：无，类与接口的数量：3793
- 2011，7特性：基于字符串的switch、钻石操作符、二进制字面量、异常处理改进，类与接口的数量：4024
- 2014，8特性：lambda表达式、包含默认方法的接口、流和日期/时间库，类与接口的数量：4240

常见误解：
- Java是HTML的扩展（Java applet才是HTML扩展）
- 使用XML，所以不需要Java
- Java是一种非常容易学习的程序设计语言
- Java将成为适用于所有平台的通用性编程语言
- Java只不过是另一种程序设计语言
- Java是专用的，应该避免使用
- Java是解释型的，因此对于关键的应用程序速度太慢了
- 所有的Java程序都是在网页中运行的
- Java程序是主要的安全风险
- JavaScript是Java的简易版
- 使用Java可以用廉价的Internet设备取代桌面计算机

Java术语：
- JDK(Java Development Kit)，编写Java程序的程序员使用的软件，1.2~1.4称为Java SDK
- JRE(Java Runtime Environment)，运行Java程序的用户使用的软件，包含虚拟机但不包含编译器
- Server JRE，在服务器上运行Java程序的软件
- SE(Standard Edition)，用于桌面或简单服务器应用的Java平台
- EE(Enterprise Edition)，用于复杂服务器应用的Java平台
- ME(Micro Edition)，用于手机或其他小型设备的Java平台
- Java FX，用于图形化用户界面的一个替代工具包，在Oracle的Java SE发布版本中提供
- OpenJDK，Java SE的一个免费开源实现，不包含浏览器继承或JavaFX
- J2(Java 2)，一个过时的术语，用于描述1998年~2006年之间的Java版本
- SDK(Software Development Kit)，一个过时的术语，用于描述1998年~2006年之间的JDK
- u(Update)，Oracle的术语，表示bug修正版本，JavaSE 8u31即Java SE 8的第31次更新，内部版本号1.8.0_31
- NetBeans，Oracle的集成开发环境

部署 Java 应用程序：
- JAR文件：
    - 创建：jar cvf JARFileName File1 File2 ...
    - 清单文件（manifest），创建：jar cfm JARFileName ManifestFileName ...，更新：jar ufm JARFileName ManifestFileName
    - 可执行JAR文件，启动应用程序：java -jar MyProgram.jar  
- applet，包含在HTML页面中的Java程序
- Java Web Start













