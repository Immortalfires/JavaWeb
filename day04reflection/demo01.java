package day04reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author:Aurevoir
 * @date: 2020/2/19  13:10
 */
public class demo01 {
    public static void main(String[] args) throws Exception {
//        获取Class类
//        Class class1 = Person.class;
//        Class class2 = new Person().getClass();
//        Class class3 = Class.forName("day04reflection.Person");
    }

    /**
     * 测试方法，操作无参构造
     * @throws Exception
     */
    @Test
    public void noArgument() throws Exception{
        Class class1 = Class.forName("day04reflection.Person");
        //得到Person实例
        Person person = (Person) class1.newInstance();
        person.setAge(2);
        System.out.println(person.getAge());
    }

    /**
     * 测试方法，操作有参构造
     * @throws Exception
     */
    @Test
    public void argumentConstructor() throws Exception{
        Class class1 = Class.forName("day04reflection.Person");
//        class1.getConstructors();     //获取所有构造方法
        Constructor c1 = class1.getConstructor(String.class,int.class,String.class);
        Person person = (Person) c1.newInstance("zhang",23,"99");
        System.out.println(person.toString());
    }

    /**
     * 测试方法，操作属性
     * @throws Exception
     */
    @Test
    public void fieldTest(){
        try {
            Class class1 = Class.forName("day04reflection.Person");
        //class1.getDeclaredFields();//得到所有属性
            Person person = (Person) class1.newInstance();
            Field name = class1.getDeclaredField("name");
            //设置可以操作私有属性
            name.setAccessible(true);
            name.set(person,"Chapman");
            System.out.println(person.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试方法，操作方法
     * @throws Exception
     */
    @Test
    public void methodTest() throws Exception{
        Class class1 = Class.forName("day04reflection.Person");
        Method setName = class1.getDeclaredMethod("setName", String.class);
        Person person = (Person) class1.newInstance();
        setName.invoke(person,"right");
        System.out.println(person.getName());
    }
}
