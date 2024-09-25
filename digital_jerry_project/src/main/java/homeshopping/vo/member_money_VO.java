package homeshopping.vo;

import java.sql.Timestamp;

public class member_money_VO {
	private int saleno;
	private int custno;
	private int pcost;
	private int amount;
	private int price;
	private String pcode;
	private Timestamp sdate;
	
	private String custname;
	
	private String grade;
	
	public member_money_VO() {}
	
	public member_money_VO(int custno, String custname, String grade, int price) {
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.price = price;
	}

	public member_money_VO(int saleno, int custno, int pcost, int amount, int price, String pcode, Timestamp sdate, String custname, String grade) {
		this.saleno = saleno;
		this.custno = custno;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
		this.custname = custname;
		this.grade = grade;
	}

	public int getSaleno() {
		return saleno;
	}

	public void setSaleno(int saleno) {
		this.saleno = saleno;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public int getPcost() {
		return pcost;
	}

	public void setPcost(int pcost) {
		this.pcost = pcost;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public Timestamp getSdate() {
		return sdate;
	}

	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
