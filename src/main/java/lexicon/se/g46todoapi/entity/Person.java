package lexicon.se.g46todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"tasks","user"})
@Builder


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
@OneToOne
@JoinColumn(name = "email")
private User user;
@OneToMany(mappedBy = "person")
private List<Task> tasks = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }
    public void addTask(Task... tasks){
        if(Object.task);

    }
    public void removeTask(Task... tasks){
  if(Object.requireNonNull(tasks).length == 0)
      throw new IllegalAccessException("Tasks is empty.");
  for(Task task : tasks){
      if(this.tasks.remove(task) && task.getPerson() == this){
          task.setPerson(null);
      }
  }
    }
}
