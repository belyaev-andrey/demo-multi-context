package org.jetbrains.test.demomulticontext.coffee.components.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsRepository extends CrudRepository<Component, Long> {



}
