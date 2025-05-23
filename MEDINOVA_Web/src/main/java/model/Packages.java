package model;

public class Packages {
	private int p_id,did,p_amount;
	private String p_name,p_test;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getP_amount() {
		return p_amount;
	}
	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_test() {
		return p_test;
	}
	public void setP_test(String p_test) {
		this.p_test = p_test;
	}
	@Override
	public String toString() {
		return "DoctorPackages [p_id=" + p_id + ", did=" + did + ", p_amount=" + p_amount + ", p_name=" + p_name
				+ ", p_test=" + p_test + "]";
	}
	
}