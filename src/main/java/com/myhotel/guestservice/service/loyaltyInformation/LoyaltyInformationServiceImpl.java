package com.myhotel.guestservice.service.loyaltyInformation;

import com.myhotel.guestservice.model.entity.PaymentEntity;
import com.myhotel.guestservice.model.request.PaymentInformationRequest;
import com.myhotel.guestservice.repository.PaymentInformationRepository;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyInformationServiceImpl implements LoyaltyInformationService{

    private final PaymentInformationRepository paymentInformationRepository;

    public LoyaltyInformationServiceImpl(PaymentInformationRepository paymentInformationRepository) {
        this.paymentInformationRepository = paymentInformationRepository;
    }

    @Override
    public String addLoyaltyInformationForGuest(final PaymentInformationRequest paymentInformation, boolean isUserWantToSavePaymentInformation) {

        String message;

        if (isUserWantToSavePaymentInformation) {
            paymentInformationRepository.save(
                    PaymentEntity.builder()
                            .phoneNumber(paymentInformation.getPhoneNumber())
                            .cardNumber(paymentInformation.getCardNumber())
                            .bankName(paymentInformation.getBankName())
                            .build()
            );
            message = "card has been added successfully ";
        }
        else {
            message = "user don't want to save bank details";
        }
        return message;
    }
}
