package lexicon.se.g46todoapi.repository;

import lexicon.se.g46todoapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
    @Query("update User u set u.expired = :status where u.email = :email")
    void updateExpiredByEmail ( @Param("email") String email,@Param("status")boolean status);

    @Modifying
    @Query("update User u set u.password = : password where u.email = : email")

    void updatePassword(@Param("email") String email,@Param("password")String newPassword);

}
