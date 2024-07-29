package com.mtrm.BitacoraSena.controllers;

import com.mtrm.BitacoraSena.models.Aprendiz;
import com.mtrm.BitacoraSena.repositories.AprendizRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/aprendiz")
public class AprendizController {
    
    @Autowired
    private AprendizRepository aprendizRepository;
        
    @CrossOrigin
    @GetMapping
    public List<Aprendiz> getAllAprendiz(){
        return aprendizRepository.findAll();
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Aprendiz> getAprendizById(@PathVariable Long id){
        Optional<Aprendiz> aprendiz = aprendizRepository.findById(id);
        return aprendiz.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    
    @CrossOrigin
    @PostMapping()
    public ResponseEntity<Aprendiz> createAprendiz(@RequestBody Aprendiz aprendiz){
        Aprendiz savedAprendiz = aprendizRepository.save(aprendiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAprendiz);
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAprendiz(@PathVariable Long id){
       if(!aprendizRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }
       aprendizRepository.deleteById(id);
       return ResponseEntity.noContent().build();
    }
    
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Aprendiz> updateAprendiz(@PathVariable Long id, @RequestBody Aprendiz updatedAprendiz){
        if(!aprendizRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updatedAprendiz.setId(id);
        Aprendiz savedAprendiz = aprendizRepository.save(updatedAprendiz);
        return ResponseEntity.ok(savedAprendiz);
    }
    
    
    
}
