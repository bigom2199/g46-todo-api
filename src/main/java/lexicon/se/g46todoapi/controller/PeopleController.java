package lexicon.se.g46todoapi.controller;

import lexicon.se.g46todoapi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/people")
public class PeopleController {
    private final personService personService;

    @Autowired

    public PeopleController(personService personService) {
        this.personService = personService;
    }
    @GetMapping
    public RersponEntity <Optional<PersonDtoview>> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(personService.findByid(id));

    }
    @PostMapping
    public ResponseEntity<Optional<personDTOView>> createOrUpdate(@RequestBody PersonDTOForm form){
        return ResponseEntity.ok().body(personService.createOrUpdate(form));

    }
    @GetMapping
    public ResponseEntity<List<PersonDTOView>> getAll(){
        return ResponseEntity.ok().body(personService.getAll());
    }
}
