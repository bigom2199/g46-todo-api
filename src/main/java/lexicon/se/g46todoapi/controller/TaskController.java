package lexicon.se.g46todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TaskController {



    private  final TaskController taskController;
@Autowired
    public TaskController(TaskController taskController) {
        this.taskController = taskController;
    }
    @GetMapping
    public ResponseEntity<Optional<TaskDTOView>> findById(@PathVariable Long id){
  return ResponseEntity.ok().body(taskService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Optional<TaskDTOView>> createOrUpdate(TaskDTOForm form ){
  return ResponseEntity.ok().body(taskService.createOrUpdate(from));
    }
    @GetMapping
    public ResponseEntity<List<TaskDTOview>> getAll(){
    return ResponseEntity.ok().body(taskService.getAll());
    }
}
