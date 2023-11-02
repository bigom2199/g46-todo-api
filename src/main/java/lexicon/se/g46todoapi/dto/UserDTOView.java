package lexicon.se.g46todoapi.dto;

import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTOView {
    private String email;
    private Set<RoleDToView> roles;
}
