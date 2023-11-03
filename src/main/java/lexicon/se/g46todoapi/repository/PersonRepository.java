package lexicon.se.g46todoapi.repository;

import lexicon.se.g46todoapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("select p from person p where SIZE(p.tasks) = 0 ")
    List<Person> findIdlePeople();



}
