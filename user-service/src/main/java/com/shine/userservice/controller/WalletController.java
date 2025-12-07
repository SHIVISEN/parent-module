package com.shine.userservice.controller;

import com.shine.userservice.model.Wallet;
import com.shine.userservice.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/wallet")
public class WalletController {

	private final WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Wallet> getWallet(@PathVariable Long userId) {
		return ResponseEntity.ok(walletService.getWallet(userId));
	}

	@PostMapping("/{userId}/credit/{amount}")
	public ResponseEntity<Wallet> credit(@PathVariable Long userId, @PathVariable Double amount) {
		return ResponseEntity.ok(walletService.credit(userId, amount));
	}

	@PostMapping("/{userId}/debit/{amount}")
	public ResponseEntity<Wallet> debit(@PathVariable Long userId, @PathVariable Double amount) {
		return ResponseEntity.ok(walletService.debit(userId, amount));
	}
}
