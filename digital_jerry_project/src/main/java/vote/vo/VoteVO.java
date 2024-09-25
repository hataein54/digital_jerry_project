package vote.vo;

//이름        널?       유형           
//--------- -------- ------------ 
//V_JUMUN   NOT NULL NUMBER(13)   
//V_NAME             VARCHAR2(20) 
//M_NO               VARCHAR2(1)  
//V_TIME             VARCHAR2(4)  
//V_AREA             VARCHAR2(20) 
//V_CONFIRM          VARCHAR2(1)  
public class VoteVO {
	private String v_name;
	private String birthDay;
	private String age;
	private String gender;
	private String m_no;
	private String v_time;
	private String v_confirm;
	
	public VoteVO(String v_name, String birthDay, String age, String gender, String m_no, String v_time, String v_confirm) {
		this.v_name = v_name;
		this.birthDay = birthDay;
		this.age = age;
		this.gender = gender;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_confirm = v_confirm;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getV_time() {
		return v_time;
	}

	public void setV_time(String v_time) {
		this.v_time = v_time;
	}

	public String getV_confirm() {
		return v_confirm;
	}

	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}
	
}
