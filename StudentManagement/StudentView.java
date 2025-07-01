package Project.StudentManagement;;

import java.util.Scanner;

public class StudentView {

   Scanner sc=new Scanner(System.in);

   int count=0;
   //老数组
   Student[] students=new Student[50];
   //新数组
    Student[] newStudents=new Student[students.length-1];




    //为什么不给加静态
    public void start(){
        while (true){
            System.out.println("-----------学生管理系统-------------");
            System.out.println("1.添加学生");
            System.out.println("2.修改学生");
            System.out.println("3.删除学生");
            System.out.println("4.查看学生");
            System.out.println("5.退出系统");
            System.out.println("请选择：（1-5）");

            int num=sc.nextInt();
            switch (num){
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    findAllStudent();
                    break;
                case 5:
                    System.out.println("按0退出，按9取消：");
                    int key=sc.nextInt();

                    if(key==0){
                        System.out.println("再见");
                        return;
                    }else if(key==9){
                        break;
                    }



            }

        }






    }

    private void findAllStudent() {
        System.out.println("学号"+"\t"+"姓名"+"\t"+"年龄"+"\t"+"性别");

        //把排序和打印输出分开
            for (int j=0;j<count-1;j++) {
                for (int i = 0; i < count - 1 - j; i++) {
                    if (students[i].getId() > students[i + 1].getId()) {
                        Student temp = students[i];
                        students[i] = students[i + 1];
                        students[i + 1] = temp;
                    }
                }
            }

        if (count==0){
            System.out.println("没有学生，等待开班");
        }else {
            for (int i=0;i<count;i++) {
                System.out.println(students[i].getId()+"\t"+students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getSex());
            }
        }

    }

    private void deleteStudent() {

        System.out.println("请输入要删除的学生学号： ");
        int id=sc.nextInt();

        //获取学号对应的索引
        int deleteIndex=ArrayUtils.findIndexById(students,id,count);

        //使用数组复制方法填充新数组 分两次
        System.arraycopy(students,0,newStudents,0,deleteIndex);
        System.arraycopy(students,deleteIndex+1,newStudents,deleteIndex,students.length-deleteIndex-1);

        students=newStudents;

        count--;






    }

    private void updateStudent() {

        System.out.println("请输入要修改的学生的学号：");
        int id=sc.nextInt();
        //使用学号找到所在的索引
        int updateIndex=ArrayUtils.findIndexById(students,id,count);

        System.out.println("请输入新姓名：");
        String name=sc.next();
        System.out.println("请输入新年龄： ");
        int age=sc.nextInt();
        System.out.println("请输入新性别： ");
        String sex=sc.next();

        //把新的这些信息赋值给新的学生对象
        Student student = new Student(id, name, age, sex);

        //将新的学生对象存入对象数组
        students[updateIndex]=student;

        System.out.println("修改成功 ");
    }

    private void addStudent() {

        System.out.println("请您输入学生学号");
        int id=sc.nextInt();
        System.out.println("请您输入学生姓名");
        String name=sc.next();
        System.out.println("请您输入学生年龄");
        int age=sc.nextInt();
        System.out.println("请您输入学生性别");
        String sex=sc.next();

        Student student = new Student(id, name, age, sex);
        students[count]=student;
        count++;
        System.out.println("添加成功！");



    }
}
