package org.jetbrains.test.demomulticontext.coffee.common;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("orders")
public class PaymentProviderMCImpl implements PaymentProvider {
    @Override
    public String getPaymentSchemaName() {
        return "MasterCard";
    }
}
