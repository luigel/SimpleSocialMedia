package com.luigel.spring.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.luigel.spring.defines.Defines;

@Entity
@Table(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3325017381635365648L;

	@Id
	@Column(name=Defines.COLUMN_USER_USERNAME)
	@Size(min=3, max=30)
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@NotEmpty
	private String username;
	
	@Column(name=Defines.COLUMN_USER_PASSWORD)
	@NotEmpty
	private String password;
	
	@Column(name=Defines.COLUMN_USER_FIRSTNAME)
	@Size(min=3, max=30)
	@Pattern(regexp="^[a-zA-Z ]*$")
	@NotEmpty
	private String firstName;
	
	@Column(name=Defines.COLUMN_USER_MIDDLENAME)
	@Size(max=30)
	@Pattern(regexp="^[a-zA-Z ]*$")
	private String middleName;
	
	@Column(name=Defines.COLUMN_USER_LASTNAME)
	@NotEmpty
	@Size(min=3, max=30)
	@Pattern(regexp="^[a-zA-Z ]*$")
	private String lastName;
	
	@Column(name=Defines.COLUMN_USER_EMAIL)
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = Defines.COLUMN_USER_DATE_CREATED)
	private String dateCreated;
	
	
//	private String birthday;
//	private String image_url;
	
	@Column(name=Defines.COLUMN_USER_AUTHORITY)
	private String authority;
	
	@Column(name=Defines.COLUMN_USER_ENABLED)
	private boolean enabled;
	
	public User() {
		
	}
	
	
public User(String username, String password, String firstName, String middleName, String lastName, String email, String dateCreated,
			String authority) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.dateCreated = dateCreated;
		this.authority = authority;
		this.enabled = true;
	}


//	public User(String username, String password, String firstName, String middleName, String lastName, String email,
//			String birthday, String image_url,String authority, boolean enabled) {
//		this.username = username;
//		this.password = password;
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.email = email;
//		this.birthday = birthday;
//		this.image_url = image_url;
//		this.authority = authority;
//		this.enabled = enabled;
//	}



	public String getUsername() {
		return username;
	}

	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(String birthday) {
//		this.birthday = birthday;
//	}
//
//	public String getImage_url() {
//		return image_url;
//	}
//
//	public void setImage_url(String image_url) {
//		this.image_url = image_url;
//	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", email=" + email + ", dateCreated=" + dateCreated
				+ ", authority=" + authority + ", enabled=" + enabled + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled != other.enabled)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
