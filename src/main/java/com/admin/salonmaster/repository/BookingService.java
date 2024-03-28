package com.admin.salonmaster.repository;

import com.admin.salonmaster.entity.Booking;
import org.springframework.http.ResponseEntity;

public interface BookingService {

    ResponseEntity<Object> addBooking(Booking booking);
    ResponseEntity<Object> updateBooking(Booking booking);
    ResponseEntity<Object> viewAllBookingsBySalonId(Long salonId);
    ResponseEntity<Object> viewBookingById(Long bookingId);

}
