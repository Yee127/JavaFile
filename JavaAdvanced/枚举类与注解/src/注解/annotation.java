package 注解;
/*
示例二:在编译时进行格式检查(JDK内置的三个基本注解)
    @Override:限定重写父类方法，该注解只能用于方法
    @Deprecated:用于表示所修饰的元素(类方法等) 已过时。通常是因为所修饰的结构危险或
    @SuppressWarnings:抑制编译器警告
示例三:跟踪代码依赖性，实现替代配置文件功能
    3.如何自定义注解:参照@SuppressWarnings定义
     ①注解声明为: @interface
    *②内部定义成员，通常使用value表示
    *③可以指定成员的默认值，使用default定义
    *④如果自定义注解没有成员，表明是一个标识作用。

    如果注解有成员，在使用注解时，需要指明成员的值。

    4. jdk提供的4种元注解
        元注解:对现有的注解进行解释说明的注解
        Retention:指定所修饰的Annotation 的生命周期: SOURCE\CLASS (默认行为) \RUNTIME
        只有声明为RUNTIME生命周期的注解，力才 能通过反射获取。
        Target:用チ指定被參怖的Annotation能用于参怖娜些程序元素
        **** * **
        :出現的頻率校低* *****
        Documented:表示所修怖的注解在被javadoc解析吋，保留下来。
        Inherited:被它修飾怖的Annotation将具有継承性。
        5.通辻反射荻取注解信息---到反射内容吋系統#解
        6. jdk 8中注解的新特性:可重夐注解、炎型注解
        6.1 可重复注解: ①在MyAnnotation上声明@Repeatable, 成員値かMyAnnotations. class
                        ②MyAnnotation的Target和Retention和MyAnnotations相同。
        6.2类型注解:
            ElementType. TYPE_ _PARAMETER 表示该注解能写在类型变量的声明语句中(如:泛型声明)。
            ELementType. TYPE_ USE表示该注解能写在使用类型的任何语句中。
*/
public class annotation {
}
