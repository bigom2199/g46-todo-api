package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.domain.UserDTOForm;
import lexicon.se.g46todoapi.dto.UserDTOView;

public interface UserService {
              UserDTOView register(UserDTOForm userDTOForm);
              UserDTOView getByEmail(String email);
              void disableByEmail(String email);
              void enableByEmail(String email);

}
