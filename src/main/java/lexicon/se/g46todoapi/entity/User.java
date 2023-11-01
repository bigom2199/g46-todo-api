package lexicon.se.g46todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
public class User {
    @Id
    @Column(updatable = false)
    private String email;
    @Column(nullable = false,length = 100)
    private String password;
    private boolean expired;
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")

    )
    private Set<Role> roles ;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void addRole(Role role){
        if(role ==null) throw new IllegalAccessException("Role is null.");
        if(roles == null) roles= new HashSet<>();
        roles.add(role);

    }
    public void removeRole(Role role){
        if(role == null) throw new IllegalAccessException("Role is null.");
        if (roles != null){
            roles.remove(role);
        }
    }
}
