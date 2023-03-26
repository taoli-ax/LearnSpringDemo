### spring 可以解耦啦
不用再写impl方法了，只要声明哪个接口就行，这就叫解耦

#### spring 环境搭建和创建第一个实例
加载配置文件applicationContext.xml就可以创建实例

#### BeanFactory和ApplicationContext 两个容器
IoC都是先读取xml文件并获取标签id和class的值，再反射clazz生成实例

