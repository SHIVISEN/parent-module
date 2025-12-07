package com.shine.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {

	@Id
	private Long userId; // from Auth Service

	private String fullName;
	private String avatarUrl;
	private String gender;
	private String dob;

	@OneToOne
	@JoinColumn(name = "default_address_id")
	private Address defaultAddress;

	@Column(columnDefinition = "json")
	private String preferences;

}
