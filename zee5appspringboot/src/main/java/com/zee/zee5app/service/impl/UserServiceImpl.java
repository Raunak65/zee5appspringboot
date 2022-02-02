package com.zee.zee5app.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userrepository ;
	@Autowired
	private LoginService loginservice ;


	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Register register2 = userrepository.save(register);
		if(register2!=null) {
		 Login login = new Login();
		 login.setRegId(register.getId());
		 login.setUsername(register.getEmail());
		 login.setPassword(register.getPassword());
		 login.setRole(ROLE.ROLE_USER);
		 try {
			loginservice.addCredentials(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "Success";
		}
		else return "Failed";
	}





	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return userrepository.findById(id);
	}


	@Override
	public Register[] getAllUsers() throws InvalidNameException, IdNotFoundException, InvalidPasswordException,
			InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		List<Register> list = userrepository.findAll();
		Register [] array = new Register[list.size()];
		return list.toArray(array);
	}


	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional = this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				userrepository.deleteById(id);
				loginservice.deleteCredentials(id);
				return "Success";
			}
		} catch (InvalidNameException | IdNotFoundException | InvalidPasswordException | InvalidEmailException
				| IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		
	}


	@Override
	public Optional<List<Register>> getAllUsersDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userrepository.findAll());
	}
}
