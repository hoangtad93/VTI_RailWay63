package com.vti.frontend;

import com.vti.backend.AccountBackend;
import com.vti.ultis.ScannerUltis;

public class Demo {
	public static void main(String[] args) {
		AccountBackend accountBackend = new AccountBackend();
		while (true) {
			System.out.println("------MỜI BẠN CHỌN CHỨC NĂNG------");
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Lấy danh sách tất cả các Account trên hệ thống");
			System.out.format(leftAlignFormat, "2. Tìm Account theo ID");
			System.out.format(leftAlignFormat, "3. Tìm Account theo Name");
			System.out.format(leftAlignFormat, "4. Tạo mới 1 Account");
			System.out.format("+--------------------------------------------------------------------------+%n");
			int chooseMenu = ScannerUltis.inputIntPositive();

			switch (chooseMenu) {
			case 1:
				accountBackend.showListAccount();
				break;
			case 2:
				accountBackend.showAccountById();
				break;
			case 3:
				accountBackend.showAccountByName();
				break;

			case 4:
				accountBackend.createNewAccount();
				break;

			default:
				System.out.println("Nhập lại:");
				break;
			}

		}
	}

}
