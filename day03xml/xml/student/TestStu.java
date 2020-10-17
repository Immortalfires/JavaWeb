package day03xml.xml.student;

/**
 * @author:Aurevoir
 * @date: 2020/2/18  15:26
 */
public class TestStu {
    public static void main(String[] args) {
//        testAdd();
//        testRemove();
        testSearch();
    }

    //测试添加方法
    public static void testAdd(){
        Student student = new Student("003","Red","59");
        StudentService.addStudent(student);
        System.out.println("添加成功！");
    }

    //测试删除方法
    public static void testRemove(){
        StudentService.removeStu("004");
        System.out.println("删除成功！");
    }

    //测试查询方法
    public static void testSearch(){
        Student student = StudentService.searchStu("001");
        System.out.println(student.toString());
    }
}
