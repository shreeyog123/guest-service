package com.myhotel.guestservice.repository;

import com.myhotel.guestservice.model.entity.GuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuestDetailsRepository extends CrudRepository<GuestEntity, Long> {
}
