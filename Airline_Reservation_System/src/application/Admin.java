package application;

public class Admin {
	private String Name,Address,Gender,Phone,Username,Password;
	private int Age,Admin_ID;
	
	
	public Admin(String name,String address,String gender,String phone,String username,String password,int age,int cid){
		Name=name;
		Address=address;
		Gender=gender;
		Phone=phone;
		Username=username;
		Password=password;
		Age=age;
		Admin_ID=cid;
		
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}

}
