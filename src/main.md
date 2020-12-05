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

Java环境搭建：
- 安装JDK
    - 搜索Java Archive，选择下载源并安装（建议创建一个专门放Java文件的目录，如d:\java）
    - 添加JAVA_HOME环境变量
    - 添加Path环境变量%JAVA_HOME%\bin（Windows系统变量优先级高，Mac用户变量优先级高）
    - 测试安装完成：cmd中输入java -version和javac

Java Class类：
- Java文件必须以.java作为扩展名
- 一个Java文件只能有一个public class
- public class的名字必须和文件名字一样，大小写都要完全一致（大驼峰命名）
- 一个文件可以有多个class，但只能有一个public。不提倡一个文件放多个类（内部类除外）
    - ps：为了能快速练习代码，一个文件李创建了多个类，这是不规范的
- 类是Java中的最基础逻辑单位，所有内容都需要放在类的范围中，Java项目就是一个个类组成的
- 类的构成：成员变量/属性、成员方法/函数
- 规范参考：阿里巴巴Java开发手册

Java 面向对象OOP：
- 对象是一个变量（具体的东西）
- 类就是类型（是规范，是定义），从万千对象中抽取共性
- 类规定乐对象应该有的属性内容和方法；对象是类的具体实现
- OO（Oriented Object）是对OP（Oriented Procedure）的一种改进
    - OP的典型代表是C和Pascal，更强调方法动作，所有的变量是被动参与进来，没有自主决定权
    - OO的方法属于每个对象，更强调方法的执行主体（obj.add(b)主语obj谓语add宾语b）
- 函数内的局部变量，编译器不会给默认值，需要初始化后才可使用；类的成员变量，编译器会给默认值，可直接使用
- 继承：
    - 每个Java类都必须有构造函数；如果没有定义，编译器会自动产生一个空的无形参构造函数
    - 子类继承父类所有的东西（但不能直接访问private成员）
    - 所有类都继承自java.lang.Object类，**所有的类都是单根继承的**
    - 每个子类的构造函数的第一句都是默认调用父类的无参数构造函数super()，除非自定义super
    - 抽象类：
        - 抽象类关键字abstract声明
        - 抽象类的组成：成员变量、具体方法(方法有实现)、**抽象方法(有abstract关键字，方法未实现且无大括号{})**
        - 抽象类也是类；子类可以继承与抽象类，但一定要实现父类们所有abstract方法，不能全部实现则必须定义为抽象类
    - 接口：
        - 类的所有方法都没有实现，那么这个类就是接口，用关键字interface声明
        - **类只可以继承(extends)一个类，但是可以实现(implement)多个接口**，继承和实现可以同时
        - 接口不算类，或者说是“特殊”的类
        - 类实现接口，就必须实现所有未实现的方法；如果没有全部实现，那么只能称为一个抽象类
        - 接口里可以定义变量，但是一般是常量
- 类转型：子类可以转换成父类，而父类不可以转为子类；只有一种情况例外，就是这个父类本身是从子类转换过来的
    - 类型转换带来的作用就是多态，即子类可以重写(覆盖，覆写)父类的方法，子类的方法优先级高于父类
- 多态：
    - 以统一的接口来操纵某一类中不同的对象的动态行为
    - 对象的解耦
- 关键字：
    - static：
        - 静态变量是类共有成员，多个对象共享一个存储空间
        - 静态方法用类名调用，静态方法中只能使用静态变量，禁止使用类名引用非静态方法
        - 静态类（内部类）
        - 静态代码块只在类第一次被加载时调用，执行顺序：static块 > 匿名块 > 构造函数
    - final：
        - final类不能被继承
        - 父类中如果有final的方法，子类中不能更改次方法
        - final变量不能再次赋值，如果不是基本类型的变量（对象），不能修改指针但可修改其内部的值
- 不可变对象Immutable Object(八个基本类别的包装类、String等)，可变对象Mutable Object(普通对象)   

    
抽象类与接口：
- 相同点：两者都不能被实例化，不能new操作
- 不同点：
    - 关键字不同，抽象类abstract，接口interface
    - 抽象类可以有部分方法实现，接口所有方法不能有实现
    - 一个类只能继承(extends)一个(抽象)类，但可以实现(implements)多个接口
    - 接口可以继承(extends)多个接口
    - 抽象类可以有构造函数，接口没有构造函数
    - 抽象类可以有main，也能运行；接口没有main函数
    - 抽象类方法和成员变量可以有private/protected；接口方法和成员变量都是public
        

Main函数（PSVM）：
- 一个class最多只能有一个main函数，类可以没有main函数
- 程序的入口都是main函数
- main函数的修饰符public static void不能省略
- main函数无法被其他方法/类所调用
- String[] args是main函数的形参

package：
- 包名尽量唯一；域名是唯一的，因此常用域名做包名
- 类的完整名字：包名+类名，cn.edu.ecnu.PackageExample
- 包名：和目录层次一样，cn\edu\ecnu\PackageExample
- 域名逆序:cn.edu.ecnu

import规则：
- import必须全部放在package之后，类定义之前
- 多个import的顺序无关
- 可以用*来引入一个目录下的所有类，比如`import java.lang.*`，但不包括java.lang下面所有的子目录文件
- import尽量精确，不推荐yong*，以免新增的同名程序使得老程序报错

访问权限：
- private，只能本类访问
- default，同一个包内访问
- protected，同一个包，子类均可以访问
- public，所有类都可以访问

JCF（Java Collection Framework）：
- 容器：能够存放数据的空间结构，如数组...
- 容器框架：为表示和操作容器而规定的一种标准体系结构，包含：对外的接口、接口的实现、算法
- List：
    - ArrayList，不支持同步，利用索引快速定位，动态调整，适合变动不大，主要用于查询的数据
    - LinkedList，适用于经常变动的数据，频繁增删的数据
    - Vector，同步时采用
- Set：确定性、互异性、无序性
    - HashSet，无序的不支持同步但可设置；判定元素重复用hashCode和equals方法(hashCode、equals、toString一起重写)
    - TreeSet，按照大小升序输出，不支持同步，判定元素重复的原则：需要元素继承自Comparable接口。compareTo方法
    - LinkedHashSet，有序的HashSet。判定元素重复的原则同hashCode
- Map映射
    - Hashtable，同步，数据量小的
    - HashMap，不同步但可以设置，数据量大的
    - Properties，可以将K-V对保存到文件    

文件系统与文件操作：
- 文件目录分隔符，windows用\隔开，程序中需用/或\\；Linux/Unix用/隔开
- java.io.File是文件和目录的重要类(JDK6及以前是唯一的)；目录也是用File类
- Java 7提出的NIO包，支持文件复制和移动、文件相对路径、递归遍历或删除目录等
- Java读写文件，只能以(数据)流的形式进行读写
- java.io包中：节点类(直接对文件进行读写),包装类(转化类-字节/字符/数据类型的转化类，装饰类-装饰节点类)
    - 节点类：InputStream,OutputStream(字节FileInputStream,FileOutputStream)，Reader,Writer(字符)
    - 转换类：字符到字节之间的转化；InputStreamReader,OutputStreamWriter
    - 装饰类：DataInputStream,DataOutputStream，BufferInputStream,BufferOutputStream，BufferedReader,BufferedWriter
    - try-resource读写文件会自动关闭资源
- 二进制文件读写：
    - 写文件：FileOutputStream,BufferedOutputStream,DataOutputStream
    - 读文件：FileInputStream,BufferedInputStream,DataInputStream
    - 读文件是一一对应的
- Zip包：java.util.zip(java.io.InputStream,java.io.OutputStream的子类)
    - ZipInputStream,ZipOutputStream压缩文件输入/输出流
    - ZipEntry压缩项

tips：
- 常量设计：
    - 不能修改用final，不会修改/只读/只要一份用static，方便访问public -> public static final常量
    - 常量名字全部大写，多个单词用下划线连接
    - 一种特殊的常量：接口内定义的变量默认是常量
    - 常量池：相同的值值存储一份，节省内存，共享访问
        - 基本类型的包装类大都有常量池，Float、Double没有缓存(常量池)
        - Byte:-128~127，Character:0~127，Shot\Int\Long:-128~127
        - Java为常量字符串都建立常量池缓存机制
        - 常量式(字面量)赋值创建是放在栈内存中(将被常量化)，new对象创建放在堆中(不会常量化)



设计模式：
- 单例模式：单态模式，Singleton
    - 限定某一个类在整个程序运行过程中，只能保留一个实例对象在内存空间
    - GOF的23种设计模式中的一种，属于创建型模式类型
    - 保证一个类有且只有一个对象；static共享对象实例，private构造函数防止new











