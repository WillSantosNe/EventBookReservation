package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
