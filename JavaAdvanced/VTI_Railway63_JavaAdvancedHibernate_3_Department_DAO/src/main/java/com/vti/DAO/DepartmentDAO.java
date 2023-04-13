package com.vti.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vti.entity.Department;
import com.vti.ultis.HibernateUtils;

public class DepartmentDAO {
	private HibernateUtils hibernateUtils;

	public DepartmentDAO() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Department> getListDepartment() {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			String hqlSelectDepartment = "FROM Department";
			Query<Department> query = session.createQuery(hqlSelectDepartment);

			List<Department> listDepartments = query.list();
			return listDepartments;
		} finally {
			session.close();
		}
	}

}
