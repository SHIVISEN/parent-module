package com.shine.userservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wallet {
	
	   @Id
	    private Long userId;

	    private Double balance;
}
