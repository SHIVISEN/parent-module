package com.shine.userservice.controller;

import com.shine.userservice.model.UserProfile;
import com.shine.userservice.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/profile")
public class ProfileController {

	private final ProfileService service;

	public ProfileController(ProfileService service) {
		this.service = service;
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {
		return ResponseEntity.ok(service.getProfile(userId));
	}

	@PostMapping
	public ResponseEntity<UserProfile> createOrUpdate(@RequestBody UserProfile profile) {
		return ResponseEntity.ok(service.saveProfile(profile));
	}

	@GetMapping
	public ResponseEntity<List<UserProfile>> getAll() {
		return ResponseEntity.ok(service.getAllProfiles());
	}
}
