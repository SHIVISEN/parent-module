package com.shine.userservice.service;

import com.shine.userservice.model.UserProfile;
import com.shine.userservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfileService {
	private final UserProfileRepository repo;

	public ProfileService(UserProfileRepository repo) {
		this.repo = repo;
	}

	public UserProfile getProfile(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
	}

	public UserProfile saveProfile(UserProfile profile) {
		return repo.save(profile);
	}

	public List<UserProfile> getAllProfiles() {
		return repo.findAll();
	}
}
