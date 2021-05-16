package com.ecabs.root.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "waypoints_model")
public class WaypointsModel {
	
	private long wpId;
	private String locality;
	private String latitude;
	private String longitude;
	
	
	public WaypointsModel() {
	}
	
	public WaypointsModel(String locality , String latitude , String longitude ) {
        this.locality = locality;
        this.latitude = latitude;
        this.longitude = longitude;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        public long getWpId() {
        return wpId;
    }
    public void setWpId(long wpId) {
    	this.wpId = wpId;
    }
	
    @Column(name = "locality", nullable = false)
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	@Column(name = "latitude", nullable = false)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

    @Override
    public String toString() {
        return "WaypointsModel [id=" + wpId + ", locality=" + locality + ", latitude=" + latitude + ", longitude=" + longitude
       + "]";
    }

}
