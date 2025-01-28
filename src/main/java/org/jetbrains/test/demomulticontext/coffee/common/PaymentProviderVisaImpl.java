package org.jetbrains.test.demomulticontext.coffee.common;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("components")
public class PaymentProviderVisaImpl implements PaymentProvider {
    @Override
    public String getPaymentSchemaName() {
        return "Visa";
    }
}
