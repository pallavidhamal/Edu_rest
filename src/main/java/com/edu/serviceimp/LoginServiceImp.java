// package com.edu.serviceimp;

// import javax.servlet.http.HttpServletRequest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.edu.bean.User;
// //import com.edu.dao.CustomerDao;
// import com.edu.dao.LoginDao;
// import com.edu.service.LoginService;
// import com.fasterxml.jackson.databind.node.ObjectNode;
// import javax.servlet.http.HttpServletRequest;

// @Service
// public class LoginServiceImp implements LoginService {

// 	@Autowired
// 	LoginDao loginDao;
// //	create an object of LoginDao
// //	so we'll be calling methods from LoginDaoImplementation
	
// 	@Override
// 	public ObjectNode checkLoginCredential(User user,HttpServletRequest req) {
		
// 		ObjectNode flag=loginDao.checkLoginCredential(user, req);
// 		return flag;
// 	}

// 	@Override
// 	public boolean checkEmailExistance(User user) {


// 		boolean flag=loginDao.checkEmailExistance(user);
// 		return flag;
// 	}

// 	@Override
// 	public ObjectNode checkSILoginCredential(User user) {
// 		// TODO Auto-generated method stub
// 		ObjectNode list=loginDao.checkSILoginCredential(user);
// 		return list;
// 	}

// 	@Override
// 	public ObjectNode changePswd(User user) {
// 		// TODO Auto-generated method stub
// 		ObjectNode list=loginDao.changePswd(user);
// 		return list;
// 	}

// 	@Override
// 	public boolean saveUserKey(User user) {
// 		// TODO Auto-generated method stub
// 		boolean list=loginDao.saveUserKey(user);
// 		return list;
// 	}

// }
