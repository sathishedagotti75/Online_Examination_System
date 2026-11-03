package com.sathish.demo.security;
import com.sathish.demo.entity.Student; import com.sathish.demo.repository.StudentRepository;
import org.springframework.security.core.userdetails.*; import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service; import java.util.List;
@Service
public class CustomUserDetailsService implements UserDetailsService {
 private final StudentRepository repository;
 public CustomUserDetailsService(StudentRepository repository){this.repository=repository;}
 @Override public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  Student s=repository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Student not found: "+email));
  return new org.springframework.security.core.userdetails.User(s.getEmail(),s.getPassword(),
   List.of(new SimpleGrantedAuthority("ROLE_"+s.getRole())));
 }
}
