package learn.web.po;

public class User {

	
	public String name;
	
//	public int age;

	public Integer age;
	
	public String sex;
	
	public String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getAge() {

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
//		return age;
//	}

//	public void setAge(int age) {
//		this.age = age;
//	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
