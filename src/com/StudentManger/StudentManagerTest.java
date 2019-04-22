package com.StudentManger;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 步骤分析：
 * A:定义学生类
 * B:创建主页面
 * C:创建查看全部学生方法
 * D:创建添加学生方法(查重)
 * E:修改学生信息
 * F:删除学生
 */
public class StudentManagerTest {

	//使用ArrayList集合来实现
	public static void main(String[] args) {
		//创建集合对象
		ArrayList<Student> array=new ArrayList<Student>();
		while(true) {
			System.out.println("------欢迎来到学生管理系统------");
			System.out.println("------1.查看全部学生信息--------");
			System.out.println("------2.添加新的学生------------");
			System.out.println("------3.修改学生信息------------");
			System.out.println("------4.删除指定学生------------");
			System.out.println("------5.退出系统----------------");
			System.out.println("请选择你要使用的功能:");
			//创建键盘录入对象
			Scanner sc=new Scanner(System.in);
			int functionChoose=sc.nextInt();
			switch(functionChoose){
			case 1:
				//查看全部学生方法
				showAllStudent(array);
				break;
			case 2:
				//添加学生方法
				addStudent(array);
				break;
			case 3:
				//修改学生方法
				resetStudent(array);
				break;
			case 4:
				//删除学生方法
				deletStudent(array);
				break;
			case 5:
				//退出系统
				System.out.println("期待您的下次使用！");
				System.exit(0);
				break;
			default:
				//选择非1-5的错误提示
				System.out.println("您的功能选择有误，请重新选择");
				System.out.println();
			}
		}
	}
	
	//查看全部学生方法
	public static void showAllStudent(ArrayList<Student> array) {
		
		if(array.size()==0) {
			System.out.println("对不起，还没有学生信息，需要您添加");
		}
		else {
			System.out.println("学号"+"\t\t"+"姓名"+"\t"+"年龄"+"\t"+"地址");
			for(int i=0;i<array.size();i++) {
				Student s=array.get(i);  //使用Student对象来接收集合元素
				System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+
						"\t"+s.getAddress());
			}
		}
	}
	//添加学生信息方法
	public static void addStudent(ArrayList<Student> array) {
		//创建键盘录入对象
		Scanner sc=new Scanner(System.in);
		String studentId="";
		Student temp=new Student();
		while(true) {
			System.out.println("请输入学生的学号:");
			studentId=sc.nextLine();
			temp.setId(studentId);
			/*
			 * 因为学号是唯一的，所以使用学号来作为查重的标记
			 * 在Student类中我重写了equals，判定相同学号即为同一个人
			 */
			if(!array.contains(temp)) {
				//没有重复，则结束循环
				break;
			}
			System.out.println("对不起，此学号已经存在，请检查后重新输入");
		}
		Student s=new Student();
		System.out.println("请输入学生姓名:");
		String name=sc.nextLine();
		System.out.println("请输入学生年龄:");
		int age=sc.nextInt();
		sc.nextLine();    //加入一个nextLine()来消除nextInt()语句遗留下来的"空白符"
		System.out.println("请输入学生住址:");
		String address=sc.nextLine();  
		s.setId(studentId);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		array.add(s);
		System.out.println("学号"+"\t\t"+"姓名"+"\t"+"年龄"+"\t"+"住址");
		System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+
				"\t"+s.getAddress());
	}
	//修改学生信息
	public static void resetStudent(ArrayList<Student> array) {
		Scanner sc=new Scanner(System.in);
		Student temp=new Student();
		System.out.println("请输入要修改学生的学号:");
		String flagId=sc.nextLine();
		temp.setId(flagId);
		//判断学生是否存在
		if(!array.contains(temp)) {
			//不存在则停止方法
			System.out.println("学生不存在，请核实");
			return;
		}
		//存在则返回元素索引
		int index=array.indexOf(temp);
		Student s=array.get(index);
		System.out.println("要修改的学生已经找到，信息如下");
		System.out.println("学号"+"\t\t"+"姓名"+"\t"+"年龄"+"\t"+"住址");
		System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+
				"\t"+s.getAddress());
		System.out.println("请输入修改后的学生姓名:");
		String name=sc.nextLine();
		System.out.println("请输入修改后的学生年龄:");
		int age=sc.nextInt();
		sc.nextLine();    //加入一个nextLine()来消除nextInt()语句遗留下来的"空白符"
		System.out.println("请输入修改后的学生住址:");
		String address=sc.nextLine();  
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		array.set(index, s);
		System.out.println("修改后的信息如下:");
		System.out.println("学号"+"\t\t"+"姓名"+"\t"+"年龄"+"\t"+"住址");
		System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+
				"\t"+s.getAddress());
	}
	//删除学生方法
	public static void deletStudent(ArrayList<Student> array) {
		Scanner sc=new Scanner(System.in);
		Student temp=new Student();
		System.out.println("请输入要删除的学生学号:");
		String flagId=sc.nextLine();
		temp.setId(flagId);
		//判断学生是否存在
		if(!array.contains(temp)) {
			//不存在则停止方法
			System.out.println("学生不存在，请核实");
			return;
		}
		//存在则返回元素索引
		int index=array.indexOf(temp);
		Student s=array.get(index);
		System.out.println("学号为 "+s.getId()+"的学生已经被删除");
		array.remove(s);
	}
}
