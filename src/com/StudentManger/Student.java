package com.StudentManger;

public class Student {

	private String name;   //姓名
	private String id;     //学号
	private int age;       //年龄
	private String address;//地址
	//无参构造方法
	public Student() {
		
	}
	//带参构造方法
	public Student(String id,String name,int age,String address) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.address=address;
	}
	//setXxx和getXxx方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	//重写equals方法,
	//判定同学号即为同一个人！！
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
