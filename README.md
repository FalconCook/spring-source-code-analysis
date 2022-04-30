## 个人的Spring源码学习笔记

- 源码分析分为IoC、AOP等几大模块
- 剔除了测试代码，只保留必要部分

## 源码分析前的工作

	操作系统：Mac os
	源码下载：spring的GitHub上克隆最新的版本
	编译工具：本地的gradle 4.10
	开发工具：intelliJ IDEA 2018
	JDK：1.8
	Spring版本：5.0.20.RELEASE

## Spring Ioc

Resource相关类 封装 配置文件 -> XmlBeanDefinitionReader 读取
Resource相关类 封装 配置文件 -> XmlBeanFactory构造方法 ->this.reader.loadBeanDefinitions(resource) 才是真正实现

进入XmlBeanDefinitionReader.loadBeanDefinitions后，使用EncodedResource类进行封装。->获取输入流->构造InputSource->doLoadBeanDefinitions() 真正的解析逻辑

进入doLoadBeanDefinitions() 真正的解析逻辑 -> 分2步：第一步doLoadDocument()。其中获取了XML的
验证方式，然后DefaultDocumentLoader#loadDocument()。其中XmlBeanDefinitionReader#getEntityResolver()具体获取了XML的验证方式。第二步registerBeanDefinitions() BeanDefinition的加载和注册工作。一直到DefaultBeanDefinitionDocumentReader#registerBeanDefinitions()方法，再到doRegisterBeanDefinitions() 真正开始进行解析了。

真正的解析 DefaultBeanDefinitionDocumentReader#doRegisterBeanDefinitions() -> 解析xml的profile属性，生产环境还是开发环境->parseBeanDefinitions() xml读取 -> parseDefaultElement() 默认标签的解析 -> parseBeanDefinitionElement#parseBeanDefinitionElement() 元素解析及信息提取，最后封装到BeanDefinitionHolder实例中 -> BeanDefinitionParserDelegate#parseBeanDefinitionElement()

接下来，我们继续一些复杂标签的解析 -> BeanDefinitionReaderUtils#createBeanDefinition() 创建承载属性实例的具体实现 -> 
BeanDefinitionParserDelegate#parseBeanDefinitionAttributes() bean的各种属性解析
							parseMetaElements() 解析元数据
							parseLookupOverrideSubElements() 解析lookup-method属性
							parseReplacedMethodSubElements() 解析replaced-method属性
							parseConstructorArgElements() 解析构造函数参数
							parsePropertyElements() 解析property子元素
							parseQualifierElements() 解析qualifier子元素









## 其他

build.gradle中的gradleVersion = "4.4.1"，记录了gradle版本

方法 XmlValidationModeDetector#detectValidationMode()
while continue break

一个类要么面向继承设计，要么用final修饰。里面的方法可能是为子类设计的，比如解析前后的处理。

少用if嵌套，改成else if

代码间隔
if (isCandidateElement(node) && nodeNameEquals(node, META_ELEMENT)) {

常量的定义
public static final String CONSTRUCTOR_ARG_ELEMENT = "constructor-arg";

Map的定义、初始化、泛型
private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256)

字符串的定义
private String factoryMethodName;

字符串数组的定义
private String[] dependsOn;

布尔类型的定义、初始化
private boolean lenientConstructorResolution = true;

引用类型的定义
private ConstructorArgumentValues constructorArgumentValues;

int类型的定义
private int role = BeanDefinition.ROLE_APPLICATION;

## 参考资料
https://www.bilibili.com/video/BV1Fh411Z7kJ