package day04reflection;

/**
 * @author:Aurevoir
 * @date: 2020/2/19  12:35
 */
public class Person {
//    属性
    private String name;
    private int age;
    private String id;
//    无参构造
    public Person() {
    }
//    有参构造
    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
//    普通方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}
