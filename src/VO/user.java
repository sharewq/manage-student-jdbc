package VO;

public class user {
	private String id;
	private String name;
	private String password;
	private String power;
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setPower(String pwoer){
		this.power=power;
	}
	public String getPower(){
		return power;
	}
}
