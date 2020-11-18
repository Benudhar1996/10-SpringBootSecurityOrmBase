package in.nit.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.nit.domain.UserManagement;
import in.nit.entity.UserManagementEntity;
import in.nit.repo.UserManagementRepositary;
import in.nit.service.IUserManagementService;
@Service
public class UserServiceImpl implements IUserManagementService, UserDetailsService {
	@Autowired
	private UserManagementRepositary userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		org.springframework.security.core.userdetails.User user = null;
		Optional<UserManagement> opt = userRepo.findByUserEmail(username);
		if (opt.isEmpty()) {

		} else {
			UserManagement usermanagement = opt.get();
			user = new org.springframework.security.core.userdetails.User(username, usermanagement.getUserPassword(),
					usermanagement.getRoles().stream().map(role -> new SimpleGrantedAuthority(role))
							.collect(Collectors.toSet()));
		}

		return user;
	}

	@Override
	public boolean saveUser(UserManagement usermanagement) {
		UserManagementEntity entity = new UserManagementEntity();
		String userPassword = usermanagement.getUserPassword();
		String encodePwd = passwordEncoder.encode(userPassword);
		usermanagement.setUserPassword(encodePwd);
		BeanUtils.copyProperties(entity, usermanagement);
		UserManagementEntity isSave = userRepo.save(entity);
		return isSave.getUserId() != null;
	}

}
