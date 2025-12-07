package com.shine.userservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "wallet_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalletTransaction {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long walletId;
	    private Double amount;

	    @Enumerated(EnumType.STRING)
	    private Type type;

	    private String reference;
	    private LocalDateTime createdAt;

	    public enum Type {
	        CREDIT, DEBIT
	    }
}
