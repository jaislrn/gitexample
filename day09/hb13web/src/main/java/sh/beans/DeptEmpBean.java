package sh.beans;

import java.util.ArrayList;
import java.util.List;

import sh.daos.DeptEmpDao;
import sh.entities.Dept;
import sh.entities.Emp;
import sh.util.HbUtil;

public class DeptEmpBean {
	private int deptno;
	private Dept dept;
	private List<Dept> deptList;
	private List<Emp> empList;
	
	public DeptEmpBean() {
		this.dept = null;
		this.deptList = new ArrayList<Dept>();
		this.empList = new ArrayList<Emp>();
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public List<Dept> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Dept> list) {
		this.deptList = list;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	public void fetchDept() {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			this.dept = dao.findDeptById(this.deptno);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
	}
	
	public void fetchAllDepts() {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			this.deptList = dao.findAllDept();
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
	}
	
	public void fetchAllEmps() {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			this.empList = dao.findAllEmp();
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
	}
}
