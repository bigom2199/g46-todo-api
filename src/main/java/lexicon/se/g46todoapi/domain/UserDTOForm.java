package lexicon.se.g46todoapi.domain;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTOForm {
    private String email;
    private String password;
    private Set<RoleDToView> roles;
}
