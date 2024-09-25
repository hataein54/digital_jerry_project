package golf.vo;

public class TeacherVO {
	private String teacher_code;
	private String teacher_name;
	private String class_name;
	private int class_price;
	private String teacher_resist_date;
	
	public TeacherVO(String teacher_code, String teacher_name, String class_name, int class_price, String teacher_resist_date) {
		this.teacher_code = teacher_code;
		this.teacher_name = teacher_name;
		this.class_name = class_name;
		this.class_price = class_price;
		this.teacher_resist_date = teacher_resist_date;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getClass_price() {
		return class_price;
	}

	public void setClass_price(int class_price) {
		this.class_price = class_price;
	}

	public String getTeacher_resist_date() {
		return teacher_resist_date;
	}

	public void setTeacher_resist_date(String teacher_resist_date) {
		this.teacher_resist_date = teacher_resist_date;
	}
	
	
	
}
