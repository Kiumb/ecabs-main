package com.ecabs.root.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.Set;



@Entity
@Table(name = "bookings")
public class BookingModel {
	
	private long id;
	private String passengerName;
	private String passengerContactNumber;
	private String pickupTime;
	private String asap;
	private String waitingTime;
	private String numberOfPassengers;
	private String price;
	private String rating;
	private String createdOn;
	private String lastModifiedOn;
	
	@OneToMany(
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	    private List<WaypointsModel> waypointsModel = new ArrayList<>();
	
//	 @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL)
//	 private Set waypointsModel;

	
	public BookingModel() {
	}
	
    public BookingModel(String passengerName, String passengerContactNumber ,
    					String pickupTime, String asap, String waitingTime,
    					String numberOfPassengers, String price, String rating
    					//String createdOn, String lastModifiedOn
    					//, List <WaypointsModel> tripWaypoints
    					) {

    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	System.out.println("timestamp:"+timestamp);
        this.passengerName = passengerName;
        this.passengerContactNumber = passengerContactNumber;
        this.pickupTime = pickupTime;
        this.asap = asap;
        this.waitingTime = waitingTime;
        this.numberOfPassengers = numberOfPassengers;
        this.price = price;
        this.rating = rating;
        this.createdOn = timestamp.toString();
        this.lastModifiedOn = timestamp.toString();
        //this.tripWaypoints = tripWaypoints;
   }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    

    @Column(name = "passenger_name", nullable = false)
	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	@Column(name = "passenger_contact_number", nullable = false)
	public String getPassengerContactNumber() {
		return passengerContactNumber;
	}

	public void setPassengerContactNumber(String passengerContactNumber) {
		this.passengerContactNumber = passengerContactNumber;
	}

	@Column(name = "pickup_time", nullable = false)
	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	@Column(name = "asap", nullable = false)
	public String getAsap() {
		return asap;
	}

	public void setAsap(String asap) {
		this.asap = asap;
	}

	@Column(name = "waiting_time", nullable = false)
	public String getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}

	@Column(name = "number_of_passengers", nullable = false)
	public String getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(String numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	@Column(name = "price", nullable = false)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "rating", nullable = false)
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Column(name = "created_on", nullable = false)
	public String getCreatedOn() {
		if(createdOn==null) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			createdOn=timestamp.toString();
		}
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "last_modified_on", nullable = false)
	public String getLastModifiedOn() {
		if(lastModifiedOn==null) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			lastModifiedOn=timestamp.toString();
		}
		return lastModifiedOn;
	}

	public void setLastModifiedOn(String lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	
	
//    public Set getWaypointsModel() {
//        return waypointsModel;
//    }
// 
//    public void setWaypointsModel(Set waypointsModel) {
//        this.waypointsModel = waypointsModel;
//    }


	
    @Override
    public String toString() {
        return "Booking [id=" + id + 
        	          ", passengerName=" + passengerName + 
        	          ", passengerContactNumber=" + passengerContactNumber + 
        	          ", pickupTime=" + pickupTime +
        	          ", asap=" + asap +
        	          ", waitingTime=" + waitingTime +
        	          ", numberOfPassengers=" + numberOfPassengers +
        	          ", price=" + price +
        	          ", rating=" + rating +
        	          ", createdOn=" + createdOn +
        	          ", lastModifiedOn=" + lastModifiedOn 
       + "]";
    }

//	public List<WaypointsModel> getWaypointsModel() {
//		return waypointsModel;
//	}
//
//	public void setWaypointsModel(List<WaypointsModel> waypointsModel) {
//		this.waypointsModel = waypointsModel;
//	}
    
    
	//private List <WaypointsModel> tripWaypoints;

}
