package itxiejin_04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManger {
    public static void main(String[] args) {

        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
//                    System.out.println("查看所有学生");
                    findStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);

            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> array) {


        Scanner sc = new Scanner(System.in);

        String sid;
        while (true) {
            System.out.print("请输入学生学号：");
            sid = sc.nextLine();
            Boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号有误会，请重新输入：");
            } else {
                break;
            }
        }

        System.out.print("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.print("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.print("请输入学生居住地：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功");

    }

    /*public static void addStudent(ArrayList<Student> array) {


        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");

        String sid = sc.nextLine();
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功");

    }*/
    public static boolean isUsed(ArrayList<Student> array, String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    //删除学生
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要删除的学生学号：");
        String sid = sc.nextLine();
        int index = -1;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {

                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该信息不存在，请重新输入");
        } else {
            array.remove(index);
            System.out.println("删除学生成功");
        }

    }

    //修改学生
    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student q = new Student();
        System.out.print("请输入你要修改的学生学号：");
        String sid = sc.nextLine();

        int index = -1;
        for (int x = 0; x < array.size(); x++) {
            Student s = array.get(x);
            if (sid.equals(s.getSid())) {
                index = x;
                break;
            }
        }

        if (index == -1) {
            System.out.println("该信息不存在，请重新输入");
        } else {
//            Student q =array.get(index);


            System.out.print("请输入新学生姓名：");
            String name = sc.nextLine();
            System.out.print("请输入新学生年龄：");
            String age = sc.nextLine();
            System.out.print("请输入新学生居住地：");
            String address = sc.nextLine();
            //创建新学生对象

            q.setSid(sid);
            q.setName(name);
            q.setAge(age);
            q.setAddress(address);

            //修改
            for (int i = 0; i < array.size(); i++) {
                Student student = array.get(i);
                if (student.getSid().equals(sid)) {
                    array.set(index, q);
                    System.out.println("修改学生成功");
                    index = i;
                    break;
                }
            }


        }

    }

    //查看所有学生
    public static void findStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
        } else {
            System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getAddress());

            }
        }
    }
}
