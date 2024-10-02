package com.ensias.scolarite.Modules;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Optional, Spring will treat it as a repository automatically.
public interface ModuleRepository extends CrudRepository<Module, Integer> {
}
