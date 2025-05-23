package model;

import java.sql.Date;

public class Appointment {
	private int aid, pid, pack_id, p_amount;
	private Date date;
	private String status, p_name, p_test;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPack_id() {
		return pack_id;
	}

	public void setPack_id(int pack_id) {
		this.pack_id = pack_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Appointment [aid=" + aid + ", pid=" + pid + ", pack_id=" + pack_id + ", p_amount=" + p_amount
				+ ", date=" + date + ", status=" + status + ", p_name=" + p_name + ", p_test=" + p_test + "]";
	}

}