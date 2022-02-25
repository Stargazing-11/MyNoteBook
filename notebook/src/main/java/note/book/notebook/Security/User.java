package note.book.notebook.Security;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User implements UserDetails{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
	@Column(unique = true)
   private String username;
   private String password;
   private String fullName;
   private String phone;
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
}
@Override
public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
}
@Override
public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
}
@Override
public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
}
@Override
public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
}
}