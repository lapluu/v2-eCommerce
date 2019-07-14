/*
 * Copyright 2014-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lapluu.eCommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Oliver Gierke
 */
@Entity
@Data
@RequiredArgsConstructor
public class Address {

	@GeneratedValue @Id//
	private Long id;
	private final String street, city, state, zipCode, country;
	@Enumerated(EnumType.STRING)
	private final AddressType addressType;

	private @JsonIgnore
	@LastModifiedDate
	Timestamp modified_date;

	public static enum AddressType{
		SHIPPING,
		HOME
	}
	public Address() {

		this.street = null;
		this.zipCode = null;
		this.city = null;
		this.state = null;
		this.country=null;
		this.addressType=null;

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("%s, %s %s, %s %s",
				street, zipCode, city, state, country);
	}


}
