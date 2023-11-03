package lexicon.se.g46todoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode(exclude = "person")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "person")
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String title;

private String description;

private LocalDate deadLine;
private boolean done;
@ManyToOne
@JoinColumn(name = "Persob_id")
private Person person;
   public Person(String name){
       this.name = name;
   }
   public void addPerson(Person person){

   }
   public void removePerson(Person person){

   }
}
