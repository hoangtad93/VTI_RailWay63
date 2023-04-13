package com.vti.backend;

import java.util.List;

import com.vti.DAO.AccountDAO;
import com.vti.entity.Account;

public class AccountBackend {
	private AccountDAO accountDAO;

	public AccountBackend() {
		accountDAO = new AccountDAO();
	}

	public void showListAccount() {
		List<Account> listAccounts = accountDAO.getAllAccount();
		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");

		for (Account acc : listAccounts) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------+%n");

	}

	public void showAccountById() {
		// TODO Auto-generated method stub

	}

	public void showAccountByName() {
		// TODO Auto-generated method stub

	}

	public void createNewAccount() {
		// TODO Auto-generated method stub

	}

}
