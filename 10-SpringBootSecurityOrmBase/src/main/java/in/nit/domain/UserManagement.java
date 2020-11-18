package in.nit.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.Data;
@Data
public class UserManagement implements Serializable{
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userGender;
	private Date userDateofBirth;
	private List<String> roles;
}
