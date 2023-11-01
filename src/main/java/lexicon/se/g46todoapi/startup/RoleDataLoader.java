package lexicon.se.g46todoapi.startup;

import lexicon.se.g46todoapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataLoader  implements CommandLineRunner {
  private RoleRepository getRoleRepository;

  public RoleRepository getRoleRepository(){
      return roleRepository;
  }

  @Autowired
  public void setRoleRepository(RoleRepository roleRepository){
      this.roleRepository = roleRepository;
  }

    @Override
    public void run(String... args) throws Exception {

    roleRepository.save(new Role("ADMIN"));
    roleRepository.sava(new Role("USER"));
    roleRepository.save(new Role("GUEST"));
    

    }
}
