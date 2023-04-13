package com.vti.backend;

import java.util.List;

import com.vti.DAO.DepartmentDAO;
import com.vti.entity.Department;

public class DepartmentBackend {
	private DepartmentDAO departmentDAO;

	public DepartmentBackend() {
		departmentDAO = new DepartmentDAO();
	}

//Hiển thị danh sách phòng ban
	public void showListDepartment() {
		System.out.println("Chức năng hiển thị danh sách phòng ban trên hệ thống");
		List<Department> listDepartments = departmentDAO.getListDepartment();

		for (Department department : listDepartments) {
			System.out.println(department.toString());
		}
	}

//Hiển thị phòng ban theo ID
	public void showDepartmentById() {
		// TODO Auto-generated method stub

	}

	// Hiển thị phòng ban theo Name
	public void showDepartmentByName() {
		// TODO Auto-generated method stub

	}

//	Tạo mới phòng ban
	public void createNewDepartment() {
		// TODO Auto-generated method stub

	}

}
