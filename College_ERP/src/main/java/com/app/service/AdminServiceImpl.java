package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AdminRepository;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	//dependencies
	@Autowired
	private AdminRepository adminRepo;
	
	
	@Override
	public List<Admin> getAllAdmins() {
		// Method of JPA Repo
		return adminRepo.findAll();
	}


	@Override
	public Admin addAdminDetails(Admin transientAdmin) {
		// method to add admin
		return adminRepo.save(transientAdmin);
	}


	@Override
	public String deleteAdmin(String id) {
		//method to delete admin
		adminRepo.deleteById(id);
		return "Admin with ID: "+id+" deleted successfully";
	}


	@Override
	public Admin updateAdmin(Admin admin) {
		// method to update admin
		return adminRepo.save(admin);
		
	}


	@Override
	public Admin getAdmin(String id) {
		// TODO Auto-generated method stub
		return adminRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Admin by ID " + id + " not found!!!!"));
		//return adminRepo.getById(id);
	}

}
