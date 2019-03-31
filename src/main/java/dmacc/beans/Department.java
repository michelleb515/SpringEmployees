package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Department {
    private int deptno;
    private String deptname;  
    private String deptloc;
    
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int deptno, String deptname, String deptloc) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.deptloc = deptloc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptloc() {
		return deptloc;
	}

	public void setDeptloc(String deptloc) {
		this.deptloc = deptloc;
	}

	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + ", deptloc=" + deptloc + "]";
	}
	
}
