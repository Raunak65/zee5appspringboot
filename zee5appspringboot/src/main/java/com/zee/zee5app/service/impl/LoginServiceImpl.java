package com.zee.zee5app.service.impl;

import java.sql.SQLException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginrepository ;
	@Override
	public String addCredentials(Login login) throws SQLException {
		// TODO Auto-generated method stub
		Login login2 = loginrepository.save(login);
		if(login2!=null) {
			return "Success";
		}
		else return "Failed";
	}

	@Override
	public String deleteCredentials(String username) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Login> optional = this.loginrepository.findById(username);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				loginrepository.deleteById(username);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}

}
