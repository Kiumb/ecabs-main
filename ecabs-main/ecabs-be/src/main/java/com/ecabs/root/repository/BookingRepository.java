package com.ecabs.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecabs.root.models.BookingModel;


@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long>{

}
