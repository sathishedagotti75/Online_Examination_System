package com.sathish.demo.dto;
import jakarta.validation.constraints.*;
public class StudentRequestDTO {
 @NotBlank private String name; @Email @NotBlank private String email;
 @NotBlank @Size(min=6) private String password; private String department; private String phone;
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
}
