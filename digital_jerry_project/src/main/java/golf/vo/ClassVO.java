package golf.vo;

public class ClassVO {
	private String resist_month;
	private String c_no;
	private String class_name;
	private String class_area;
	private String teacher_code;
	
	public ClassVO(String resist_month, String c_no, String class_name, String class_area, String teacher_code) {

		this.resist_month = resist_month;
		this.c_no = c_no;
		this.class_name = class_name;
		this.class_area = class_area;
		this.teacher_code = teacher_code;
	}

	public String getResist_month() {
		return resist_month;
	}

	public void setResist_month(String resist_month) {
		this.resist_month = resist_month;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}
	
	
	
}

