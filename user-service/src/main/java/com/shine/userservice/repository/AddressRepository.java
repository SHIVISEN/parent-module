package com.shine.userservice.repository;


import com.shine.userservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository {

    List<Address> findByUserId(Long userId);

}
