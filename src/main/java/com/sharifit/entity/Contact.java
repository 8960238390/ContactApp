package com.sharifit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CONTCT_DTLS")
public class Contact {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private long phno;
}
