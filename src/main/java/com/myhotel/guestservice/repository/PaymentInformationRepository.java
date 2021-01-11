package com.myhotel.guestservice.repository;

import com.myhotel.guestservice.model.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentInformationRepository extends CrudRepository<PaymentEntity, Long> {
}
