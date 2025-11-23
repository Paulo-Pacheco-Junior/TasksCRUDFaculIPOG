package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.repository.TaskRepository;
import com.br.exception.ResourceNotFoundException;
import com.br.model.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



//http://localhost:8080/api/tarefas

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/tarefas")
@RestController
public class TaskController {

    @Autowired
    private TaskRepository tRep;
    
    @GetMapping
    public List<Task> listar(){
        return this.tRep.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> consultar(@PathVariable Long id){
        Task task = this.tRep.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Tarefa não encontrada: " + id));
        return ResponseEntity.ok(task);
    }
    
    @PostMapping
    public Task inserir(@RequestBody Task task) {
        return this.tRep.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> alterar(@PathVariable Long id, @RequestBody Task task){
        Task tsk = this.tRep.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Tarefa nao encontrada: " + id));
        tsk.setId(id);
        tsk.setTitle(task.getTitle());
        tsk.setDescription(task.getDescription());
        tsk.setCompleted(task.getCompleted());
        Task taskAtualizada = tRep.save(tsk);
        return ResponseEntity.ok(taskAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id){
        Task task = this.tRep.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Tarefa nao encontrada: " + id));
        this.tRep.delete(task);
        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Tarefa excluida", Boolean.TRUE);
        return ResponseEntity.ok(resposta);
    }
}
