package com.myhotel.guestservice.service;

import com.myhotel.guestservice.exception.GuestNotFoundException;
import com.myhotel.guestservice.model.entity.AddressEntity;
import com.myhotel.guestservice.model.entity.GuestEntity;
import com.myhotel.guestservice.model.response.GuestDetails;
import com.myhotel.guestservice.repository.GuestDetailsRepository;
import com.myhotel.guestservice.service.guestdetails.GuestDetailsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class GuestServiceImplTest {

    @Mock
    private GuestDetailsRepository guestDetailsRepository;

    static long guestId = 1231231231;

    private GuestDetailsServiceImpl guestDetailsService;

    @Before
    public void setup(){
        initMocks(this);
        guestDetailsService = new GuestDetailsServiceImpl(guestDetailsRepository);

    }

    @Test(expected = GuestNotFoundException.class)
    public void shouldNotReturnGuestDetails_ifGuestIdIsNull(){

        when(guestDetailsRepository.findById(guestId)).thenReturn(getGuestDetails());

        GuestDetails guestDetails = guestDetailsService.getGuestDetails(null);

    }

    @Test
    public void shouldReturnGuestDetails(){

        when(guestDetailsRepository.findById(guestId)).thenReturn(getGuestDetails());

        GuestDetails guestDetails = guestDetailsService.getGuestDetails(guestId);

        Assert.assertNotNull(guestDetails);
        Assert.assertEquals(guestId, guestDetails.getPhoneNumber());


    }


    @Test(expected = GuestNotFoundException.class)
    public void shouldNotReturnGuestDetails_ifGuestIdNotFound(){

        when(guestDetailsRepository.findById(guestId)).thenReturn(Optional.empty());

        guestDetailsService.getGuestDetails(guestId);

    }

    private Optional<GuestEntity> getGuestDetails() {

        GuestEntity guestEntity = GuestEntity.builder()
                .firstName("Jon")
                .lastName("Watson")
                .email("jon@xyz.com")
                .phoneNumber(guestId)
                .address(AddressEntity.builder()
                        .buildingName("River side Wing")
                        .city("Leeds")
                        .state("Liverpool")
                        .country("UK")
                        .pin(112233)
                        .build()).build();

        return Optional.of(guestEntity);
    }
}
