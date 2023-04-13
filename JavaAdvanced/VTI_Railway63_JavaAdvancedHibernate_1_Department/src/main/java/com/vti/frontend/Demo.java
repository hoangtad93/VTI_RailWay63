package com.vti.frontend;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entiy.Department;
import com.vti.ultis.ScannerUltis;

public class Demo {
	public static void main(String[] args) {
//		Tạo ra các Session
		Session session = null;

		System.out.println("Mời bạn chọn chức năng");
		System.out.println("1. Danh sách phòng ban");
		System.out.println("2. Lấy phòng ban theo ID");
		System.out.println("3. Tạo mới phòng ban");
		System.out.println("4. Lấy phòng ban theo Name");
		int choose = ScannerUltis.inputIntPositive();

		switch (choose) {
		case 1:
			try {
				session = buildSessionFactory().openSession();

//				Hiển thị danh sách phòng ban đang có trên hệ thống
				String hqlSelectDepartment = "FROM Department";
				Query<Department> query = session.createQuery(hqlSelectDepartment);

				List<Department> listDepartments = query.list();

				for (Department department : listDepartments) {
					System.out.println("Thông tin bảng Department");
					System.out.println(department.toString());
				}
			} finally {
				session.close();
			}
			break;
		case 2:
			System.out.println("Mời bạn nhập vào Id của phòng ban");
			int idFind = ScannerUltis.inputIntPositive();
			try {
				session = buildSessionFactory().openSession();
//				SELECT * FROM department WHERE DepartmentID = 5; sql
//				String hqlSelectDepartment = "FROM Department WHERE id = :idParam"; // hql
//				Query<Department> query = session.createQuery(hqlSelectDepartment);
//				query.setParameter("idParam", (short) idFind);

//				Department department = query.uniqueResult();

//				Lây theo id 
				Department department = session.get(Department.class, (short) idFind);

				System.out.println(department.toString());

			} finally {
				session.close();
			}
			break;

		case 3:
			System.out.println("Tạo mới phòng ban");
			System.out.println("Mời bạn nhập vào thông tin phòng ban cần tạo");
			String nameDep = ScannerUltis.inputString();

			try {
				session = buildSessionFactory().openSession();
				session.beginTransaction();

				Department department = new Department();
				department.setName(nameDep);

				session.save(department);

				session.getTransaction().commit();
			} finally {
				session.close();
			}

			break;
		case 4:

			break;
		default:

			break;
		}

	}

//	Hàm tạo ra SessionFactory sử dụng quản lý các session trong chương trình
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

//		Đăng ký các đối tượng Pojo trong chương trình
		configuration.addAnnotatedClass(Department.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}
//
}
