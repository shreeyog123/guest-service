package com.myhotel.guestservice.service.loyaltyInformation;

import com.myhotel.guestservice.model.request.PaymentInformationRequest;

public interface LoyaltyInformationService {
    String addLoyaltyInformationForGuest(final PaymentInformationRequest paymentInformation,
                                         boolean isUserWantToSavePaymentInformation);
}
