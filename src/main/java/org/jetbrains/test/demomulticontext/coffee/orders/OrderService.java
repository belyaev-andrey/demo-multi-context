package org.jetbrains.test.demomulticontext.coffee.orders;

import org.jetbrains.test.demomulticontext.coffee.common.PaymentProvider;
import org.jetbrains.test.demomulticontext.coffee.orders.dto.OrderDto;
import org.jetbrains.test.demomulticontext.coffee.orders.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final OrdersRepository ordersRepository;
    private final PaymentProvider paymentProvider;

    public OrderService(OrdersRepository ordersRepository, PaymentProvider paymentProvider) {
        this.ordersRepository = ordersRepository;
        this.paymentProvider = paymentProvider;
    }

    @Transactional(readOnly = true)
    public Iterable<Order> findAll() {
        return ordersRepository.findAll();
    }

    @Transactional
    public Order createOrder(OrderDto order) {
        log.info("Creating paid order using provider: {}", paymentProvider.getPaymentSchemaName());
        return ordersRepository.findById(order.id()).orElseThrow(IllegalArgumentException::new);
    }
}
