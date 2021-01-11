package com.myhotel.guestservice.contract.loyaltyInformation;

import com.myhotel.guestservice.model.request.PaymentInformationRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Api("loyalty-details")
public interface LoyaltyInformationContract {

    @ApiOperation(
            value = "add",
            response = String.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    ResponseEntity<String> addPaymentInformation(final boolean isUserWantToSavePaymentInformation,
                                                  final PaymentInformationRequest paymentInformation
                                                );


}
