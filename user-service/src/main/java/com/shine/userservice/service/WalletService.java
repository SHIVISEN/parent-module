package com.shine.userservice.service;

import com.shine.userservice.model.Wallet;
import com.shine.userservice.model.WalletTransaction;
import com.shine.userservice.repository.WalletRepository;
import com.shine.userservice.repository.WalletTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WalletService {

	 private final WalletRepository walletRepo;
	    private final WalletTransactionRepository txRepo;

	    public WalletService(WalletRepository walletRepo, WalletTransactionRepository txRepo) {
	        this.walletRepo = walletRepo;
	        this.txRepo = txRepo;
	    }

	    public Wallet getWallet(Long userId) {
	        return walletRepo.findById(userId).orElse(Wallet.builder().userId(userId).balance(0.0).build());
	    }

	    public Wallet credit(Long userId, Double amount) {
	        Wallet wallet = getWallet(userId);
	        wallet.setBalance(wallet.getBalance() + amount);
	        walletRepo.save(wallet);

	        txRepo.save(WalletTransaction.builder()
	                .walletId(userId)
	                .amount(amount)
	                .type(WalletTransaction.Type.CREDIT)
	                .createdAt(LocalDateTime.now())
	                .build());

	        return wallet;
	    }
	    
	    public Wallet debit(Long userId, Double amount) {
	        Wallet wallet = getWallet(userId);
	        if (wallet.getBalance() < amount)
	            throw new RuntimeException("Insufficient balance");

	        wallet.setBalance(wallet.getBalance() - amount);
	        walletRepo.save(wallet);

	        txRepo.save(WalletTransaction.builder()
	                .walletId(userId)
	                .amount(amount)
	                .type(WalletTransaction.Type.DEBIT)
	                .createdAt(LocalDateTime.now())
	                .build());

	        return wallet;
	    }
}
