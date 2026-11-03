package com.sathish.demo.entity;
import jakarta.persistence.*;
@Entity @Table(name="students")
public class Student {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer studentId;
 @Column(nullable=false) private String name;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String password;
 private String department; private String phone;
 @Column(nullable=false) private String role="STUDENT";
 public Integer getStudentId(){return studentId;} public void setStudentId(Integer v){studentId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
}
