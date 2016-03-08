package com.webage.travel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@Column(name="id")
	private long bookingId;

	private long packageId;
	private String userId;
	private String forDate;
}
