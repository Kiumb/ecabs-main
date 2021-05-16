package com.ecabs.root.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecabs.root.exception.ResourceNotFoundException;
import com.ecabs.root.models.BookingModel;
import com.ecabs.root.models.WaypointsModel;
import com.ecabs.root.repository.BookingRepository;


	@RestController @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/api/v1")
	public class BookingController {
	    @Autowired
	    private BookingRepository bookingRepository;

	    @GetMapping("/bookings")
	    public List<BookingModel> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    @GetMapping("/bookings/{id}")
	    public ResponseEntity<BookingModel> getBookingById(@PathVariable(value = "id") Long bookingId)
	        throws ResourceNotFoundException {
	        BookingModel booking = bookingRepository.findById(bookingId)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + bookingId));
	        return ResponseEntity.ok().body(booking);
	    }
	    
	    @PostMapping("/bookings")
	    public BookingModel createBooking(@Valid @RequestBody BookingModel booking) {
	        return bookingRepository.save(booking);
	    }

	    @PutMapping("/bookings/{id}")
	    public ResponseEntity<BookingModel> updateBooking(@PathVariable(value = "id") Long bookingId,
	         @Valid @RequestBody BookingModel bookingDetails) throws ResourceNotFoundException {
	    	BookingModel booking = bookingRepository.findById(bookingId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + bookingId));

	    	booking.setId(bookingDetails.getId());
	    	booking.setPassengerName (bookingDetails.getPassengerName ());
	    	booking.setPassengerContactNumber (bookingDetails.getPassengerContactNumber ());
	    	booking.setPickupTime (bookingDetails.getPickupTime ());
	    	booking.setAsap (bookingDetails.getAsap ());
	    	booking.setWaitingTime (bookingDetails.getWaitingTime ());
	    	booking.setNumberOfPassengers (bookingDetails.getNumberOfPassengers ());
	    	booking.setPrice (bookingDetails.getPrice ());
	    	booking.setRating (bookingDetails.getRating ());
	    	booking.setCreatedOn (bookingDetails.getCreatedOn ());
	    	booking.setLastModifiedOn (bookingDetails.getLastModifiedOn ());
	    	
	    	 List <WaypointsModel> TripWaypoints = createWPList();
	    	 
	    	//booking.setWaypointsModel(TripWaypoints);
	    	
	        final BookingModel updatedBooking = bookingRepository.save(booking);
	        return ResponseEntity.ok(updatedBooking);
	    }

	    @DeleteMapping("/bookings/{id}")
	    public Map<String, Boolean> deleteBooking(@PathVariable(value = "id") Long bookingId)
	         throws ResourceNotFoundException {
	    	BookingModel employee = bookingRepository.findById(bookingId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + bookingId));

	        bookingRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
		private static List<WaypointsModel> createWPList() {
			List<WaypointsModel> wpTempList = new ArrayList<>();
			WaypointsModel wp1 = new WaypointsModel();
			
			wp1.setLocality("emp2");
			wp1.setLatitude("emp2");
			wp1.setLongitude("emp2");
			
			WaypointsModel wp2 = new WaypointsModel();
			
			wp2.setLocality("emp2");
			wp2.setLatitude("emp2");
			wp2.setLongitude("emp2");
			
			WaypointsModel wp3 = new WaypointsModel();
			
			wp3.setLocality("emp2");
			wp3.setLatitude("emp2");
			wp3.setLongitude("emp2");
			
			
			wpTempList.add(wp1);
			wpTempList.add(wp2);
			return wpTempList;
		}
	}