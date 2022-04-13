package com.app.service;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminService {

	List<Admin> getAllAdmins();
	Admin addAdminDetails(Admin transientAdmin);
	String deleteAdmin(String id);
	Admin updateAdmin(Admin admin);
	Admin getAdmin(String id);
}
