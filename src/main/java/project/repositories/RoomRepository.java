package project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.entities.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	@EntityGraph(attributePaths = "bookings") 
    Optional<Room> findById(Long id);
}
