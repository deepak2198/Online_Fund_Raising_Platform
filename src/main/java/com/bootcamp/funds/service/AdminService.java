package com.bootcamp.funds.service;

import java.util.List;

import com.bootcamp.funds.dto.AdminDto;

public interface AdminService {
	
	List<AdminDto> getAllAdmins();
	AdminDto getAdminByName(String adminname);
	public AdminDto addAdmin(AdminDto dto);
	public AdminDto updateAdmin(String adminname, AdminDto dto);
	public String deleteAdmin(String adminname);



}
