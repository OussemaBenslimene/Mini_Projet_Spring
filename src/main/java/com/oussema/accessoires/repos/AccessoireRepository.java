package com.oussema.accessoires.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oussema.accessoires.entities.Accessoire;


public interface AccessoireRepository extends JpaRepository<Accessoire , Long> {

}
