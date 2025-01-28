package org.jetbrains.test.demomulticontext.coffee.components;

import org.jetbrains.test.demomulticontext.coffee.components.model.Component;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ComponentsRepository extends CrudRepository<Component, Long> {

}
