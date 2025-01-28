package org.jetbrains.test.demomulticontext.coffee.components;

import org.jetbrains.test.demomulticontext.coffee.common.PaymentProvider;
import org.jetbrains.test.demomulticontext.coffee.common.PaymentStatus;
import org.jetbrains.test.demomulticontext.coffee.components.model.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class ComponentsService {

    private static final Logger log = LoggerFactory.getLogger(ComponentsService.class);
    private final ComponentsRepository componentsRepository;
    private final PaymentProvider paymentProvider;

    public ComponentsService(ComponentsRepository componentsRepository, PaymentProvider paymentProvider) {
        this.componentsRepository = componentsRepository;
        this.paymentProvider = paymentProvider;
    }

    @Transactional(readOnly = true)
    public Iterable<Component> findAll() {
        return componentsRepository.findAll();
    }

    @Transactional
    public PaymentStatus buyComponent(Long componentId) {
        Component component = componentsRepository.findById(componentId).orElseThrow(IllegalArgumentException::new);
        log.info("Buying {} using {}", component, paymentProvider.getPaymentSchemaName());
        if (componentId%2==0) {
            return PaymentStatus.SUCCESS;
        } else {
            return PaymentStatus.FAILED;
        }
    }

}
