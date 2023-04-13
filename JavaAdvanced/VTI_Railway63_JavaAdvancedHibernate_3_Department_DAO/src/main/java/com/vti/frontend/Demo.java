package com.vti.frontend;

import com.vti.backend.DepartmentBackend;
import com.vti.ultis.ScannerUltis;

public class Demo {

	public static void main(String[] args) {
		DepartmentBackend departmentBackend = new DepartmentBackend();
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Lấy danh sách tất cả các phòng ban trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm phòng ban theo ID");
			System.out.format(leftAlignFormat, "3. Tìm phòng ban theo Name");
			System.out.format(leftAlignFormat, "4. Tạo mới 1 phòng");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int chooseMenu = ScannerUltis.inputIntPositive();

			switch (chooseMenu) {
			case 1:
				departmentBackend.showListDepartment();
				break;
			case 2:
				departmentBackend.showDepartmentById();
				break;
			case 3:
				departmentBackend.showDepartmentByName();
				break;

			case 4:
				departmentBackend.createNewDepartment();
				break;

			default:
				System.out.println("Nhập lại:");
				break;
			}

		}

	}
}
