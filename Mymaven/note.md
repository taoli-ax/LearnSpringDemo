### spring 可以解耦啦
不用再写impl方法了，只要声明哪个接口就行，这就叫解耦

#### spring 环境搭建和创建第一个实例
加载配置文件applicationContext.xml就可以创建实例

#### BeanFactory和ApplicationContext 两个容器
IoC都是先读取xml文件并获取标签id和class的值，再反射clazz生成实例

#### 创建Bean对象三种方式
静态工厂，实例工厂，构造器


#### 注入的两种方式
setter 和 constructor
ps:自动装配没有成功


#### FactoryBean
服务变成了工厂方法，不需要关注复杂的内部逻辑

#### spring 注解 和 mybatis 注解
有点酷的注解，好看又好玩
@Service("yourService") @Autowired
@Repository
@select("select * from table")

#### 数据库逆向生成dao，pojo和mybatisMapper.xml ,需要下载intellij专业版
插件名 mybatis-generator