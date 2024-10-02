package com.ensias.scolarite.Modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Get all modules
    @GetMapping
    public List<Module> getModules() {
        return moduleService.getAllModules();
    }

    // Get a specific module by ID
    @GetMapping("/{id}")
    @RequestMapping("/modules/{id}")
    public Optional<Module> getModule(@PathVariable Integer id){
        return moduleService.getModule(id);
    }

    // Add a new module
    @PostMapping
    public ResponseEntity<Void> ajouterModule(@RequestBody Module module) {
        moduleService.ajouterModule(module);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update an existing module
    @PutMapping("/{id}")
    public ResponseEntity<Void> modifierModule(@RequestBody Module module, @PathVariable Integer id) {
        moduleService.modifierModule(id, module);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete a module by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerModule(@PathVariable Integer id) {
        moduleService.supprimerModule(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
