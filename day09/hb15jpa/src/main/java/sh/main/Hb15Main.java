package sh.main;

import sh.daos.DeptDao;
import sh.entities.Dept;
import sh.util.JpaUtil;

public class Hb15Main {
	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		
//		Dept d = dao.findById(10);
//		System.out.println("Found: " + d);
		
		Dept d = new Dept(0, "Training", "Pune");
		dao.addDept(d);
		
		JpaUtil.shutdown();
	}
}
