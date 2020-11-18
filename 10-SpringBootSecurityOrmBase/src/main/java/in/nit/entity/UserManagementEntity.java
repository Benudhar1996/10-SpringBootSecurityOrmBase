package in.nit.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERMANAGEMENT")
@Data
public class UserManagementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String userGender;
	private Date userDateofBirth;
	@ElementCollection
	@CollectionTable(name = "rolsetable",joinColumns = @JoinColumn(name="uid"))
	private List<String> roles;

}
