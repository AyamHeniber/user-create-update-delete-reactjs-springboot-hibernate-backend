package com.novelti.usercreate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "First name is required")
//    @Size(min = 5, message = "First name must be at least 5 characters long")
    @Column(name = "first_name", nullable = false)
    private String firstName;

//    @NotBlank(message = "Last name is required")
//    @Size(min = 5, message = "Last name must be at least 5 characters long")
    @Column(name = "last_name", nullable = false)
    private String lastName;

//    @NotBlank(message = "Email is required")
//    @Email(message = "Invalid email format")
    @Column(name = "email_id", nullable = false)
    private String email;

    // Custom mobile number validation
//    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
    @Column(name = "mobile")
    private String mobile;

//    @NotBlank(message = "Address 1 is required")
    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2")
    private String address2;

//    @NotBlank(message = "Country is required")
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state")
    private String state;

//    @Digits(integer = 5, fraction = 0, message = "Zip code must be a 5-digit number")
    @Column(name = "zipCode")
    private String zipCode;

    public UserCreate() {}
    
	public UserCreate(Long id, String firstName, String lastName, String email, String mobile, String address1,
		String address2, String country, String state, String zipCode) {

	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.mobile = mobile;
	this.address1 = address1;
	this.address2 = address2;
	this.country = country;
	this.state = state;
	this.zipCode = zipCode;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
    
    
}

