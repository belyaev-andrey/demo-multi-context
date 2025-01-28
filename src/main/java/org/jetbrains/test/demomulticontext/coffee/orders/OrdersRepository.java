package org.jetbrains.test.demomulticontext.coffee.orders;

import org.jetbrains.test.demomulticontext.coffee.orders.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrdersRepository extends CrudRepository<Order, Long> {
}
