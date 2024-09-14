package com.example.restaurantmanagementsystem.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@jakarta.persistence.Table(name = "user_table")
@SequenceGenerator(name = "generator1", sequenceName = "gen1", initialValue = 1000)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name", length = 20)
    @NotEmpty(message = "First name is required")
    @Size(min = 3, message = "First name must contain at least 3 characters")
    private String firstName;

    @Column(name = "last_name", length = 20)
    @NotEmpty(message = "Last name is required")
    @Size(min = 2, message = "Last name must contain at least 2 characters")
    private String lastName;

    @Column(name = "date_of_birth")
    @Past(message = "Date of birth must be in the past")
    private Date dateOfBirth;

    @Column(name = "phone_number")
    @NotEmpty(message = "Phone number is required")
    @Size(min = 10, max = 10, message = "Phone number must contain 10 digits")
    private String phoneNumber;

    @Column(name = "address")
    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @Column(name = "district", length = 20)
    @NotEmpty(message = "District is required")
    @Size(min = 3, message = "District must contain at least 3 characters")
    private String district;

    @Column(name = "state", length = 20)
    @NotEmpty(message = "State is required")
    @Size(min = 3, message = "State must contain at least 3 characters")
    private String state;

    @Column(name = "zip_code")
    @NotEmpty(message = "Zip code is required")
    @Size(min = 6, max = 6, message = "Zip code must contain 6 digits")
    private String zipCode;

    @Column(name = "email_id", unique = true, length = 30)
    @NotEmpty(message = "Email ID is required")
    @Email(message = "Email is not valid")
	public String emailId;

    @Column(name = "gender", length = 30)
    @NotEmpty(message = "Gender is required")
    @Size(min = 4, message = "Gender must contain at least 4 characters")
    private String gender;

    @Column(name = "password", length = 20)
    @NotEmpty(message = "Password is required")
    @Size(min = 8, message = "Password length must be at least 8 characters")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain uppercase, lowercase, and digits")
	public String password;

    @Column(name = "role")
    @NotEmpty(message = "Role is required")
    private String role;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
		super();
	}

	public User(long userId,
			@NotEmpty(message = "First name is required") @Size(min = 3, message = "First name must contain at least 3 characters") String firstName,
			@NotEmpty(message = "Last name is required") @Size(min = 2, message = "Last name must contain at least 2 characters") String lastName,
			@Past(message = "Date of birth must be in the past") Date dateOfBirth,
			@NotEmpty(message = "Phone number is required") @Size(min = 10, max = 10, message = "Phone number must contain 10 digits") String phoneNumber,
			@NotEmpty(message = "Address cannot be empty") String address,
			@NotEmpty(message = "District is required") @Size(min = 3, message = "District must contain at least 3 characters") String district,
			@NotEmpty(message = "State is required") @Size(min = 3, message = "State must contain at least 3 characters") String state,
			@NotEmpty(message = "Zip code is required") @Size(min = 6, max = 6, message = "Zip code must contain 6 digits") String zipCode,
			@NotEmpty(message = "Email ID is required") @Email(message = "Email is not valid") String emailId,
			@NotEmpty(message = "Gender is required") @Size(min = 4, message = "Gender must contain at least 4 characters") String gender,
			@NotEmpty(message = "Password is required") @Size(min = 8, message = "Password length must be at least 8 characters") @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Password must contain uppercase, lowercase, and digits") String password,
			@NotEmpty(message = "Role is required") String role) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.district = district;
		this.state = state;
		this.zipCode = zipCode;
		this.emailId = emailId;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}
}
