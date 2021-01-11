package com.myhotel.guestservice.contract.loyaltyInformation;

import com.myhotel.guestservice.model.request.PaymentInformationRequest;
import com.myhotel.guestservice.service.loyaltyInformation.LoyaltyInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loyalty-details")
public class LoyaltyInformationController implements LoyaltyInformationContract{

    private final LoyaltyInformationService loyaltyInformationService;

    public LoyaltyInformationController(LoyaltyInformationService loyaltyInformationService) {
        this.loyaltyInformationService = loyaltyInformationService;
    }

    @Override
    @PostMapping(value = "/add")
    public ResponseEntity<String> addPaymentInformation(
            @RequestParam(name = "isUserWantToSave", defaultValue = "false") final boolean isUserWantToSavePaymentInformation,
            @RequestBody final PaymentInformationRequest paymentInformation) {

            String message = loyaltyInformationService.addLoyaltyInformationForGuest(paymentInformation,isUserWantToSavePaymentInformation);

        return ResponseEntity.ok().body(message);

    }
}
