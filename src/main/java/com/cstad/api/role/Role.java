package com.cstad.api.role;

import com.cstad.api.authorities.Authorities;
import com.cstad.api.user.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> usersRole;

    @ManyToMany
    @JoinTable( name="roles_authorities",
            joinColumns = @JoinColumn(name = "roles_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id",referencedColumnName = "id"))
    private List<Authorities> authorities;

}
