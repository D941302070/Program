package XueXiJiLu.Api.generic;
/*
含有泛型的接口第二种使用方法：接口使用什么泛型，实现类就是用什么泛型，类跟着接口走
就相当于定义了一个含有泛型的类，创建对象的时候确定泛型的类型
 */
public class GenericInterfaceImpl2<I> implements GenericInterface<I>{
    @Override
    public void method(I i) {

    }
}
