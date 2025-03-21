package project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.booking.CreateBookingDTO;
import project.dto.booking.ResponseBookingDTO;
import project.dto.booking.UpdateBookingDTO;
import project.entities.Booking;
import project.entities.Room;
import project.entities.User;
import project.enums.BookingStatus;
import project.repositories.BookingRepository;
import project.repositories.RoomRepository;
import project.repositories.UserRepository;

/**
 * Service class for managing booking-related operations.
 */
@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoomRepository roomRepository;

	/**
	 * Creates a new booking based on the provided data.
	 *
	 * @param dto Object containing the necessary information to create a booking.
	 * @return Response DTO with the details of the created booking.
	 * @throws RuntimeException If the specified user or room is not found.
	 */
	public ResponseBookingDTO createBooking(CreateBookingDTO dto) {
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found with id " + dto.getUserId()));

		Room room = roomRepository.findById(dto.getRoomId())
				.orElseThrow(() -> new RuntimeException("Room not found with id " + dto.getRoomId()));

		Booking booking = new Booking();
		booking.setStartDateTime(dto.getStartDateTime());
		booking.setEndDateTime(dto.getEndDateTime());
		booking.setPurpose(dto.getPurpose());
		booking.setStatus(BookingStatus.ACTIVE);
		booking.setUser(user);
		booking.setRoom(room);

		return new ResponseBookingDTO(bookingRepository.save(booking));
	}

	/**
	 * Updates an existing booking's data based on the provided ID.
	 *
	 * @param id  Identifier of the booking to be updated.
	 * @param dto Object containing the data to update the booking with.
	 * @return Response DTO with the details of the updated booking.
	 * @throws RuntimeException If the specified booking is not found.
	 */
	public ResponseBookingDTO updateBooking(Long id, UpdateBookingDTO dto) {
		Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));

		if (dto.getStartDateTime() != null) {
			booking.setStartDateTime(dto.getStartDateTime());
		}
		if (dto.getEndDateTime() != null) {
			booking.setEndDateTime(dto.getEndDateTime());
		}
		if (dto.getPurpose() != null) {
			booking.setPurpose(dto.getPurpose());
		}
		if (dto.getStatus() != null) {
			booking.setStatus(dto.getStatus());
		}

		return new ResponseBookingDTO(bookingRepository.save(booking));
	}

	/**
	 * Retrieves booking details based on the provided ID.
	 *
	 * @param id Identifier of the booking to be retrieved.
	 * @return Response DTO with the details of the retrieved booking.
	 * @throws RuntimeException If the specified booking is not found.
	 */
	public ResponseBookingDTO findById(Long id) {
		Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
		return new ResponseBookingDTO(booking);
	}

	/**
	 * Retrieves a list of all bookings available in the system.
	 *
	 * @return List of response DTOs for all bookings.
	 */
	public List<ResponseBookingDTO> findAll() {
		
		return bookingRepository.findAll().stream().map(ResponseBookingDTO::new).collect(Collectors.toList());
	}

	/**
	 * Deletes a booking based on the provided ID.
	 *
	 * @param id Identifier of the booking to be deleted.
	 * @throws RuntimeException If the specified booking is not found.
	 */
	public void delete(Long id) {
		if (!bookingRepository.existsById(id)) {
			throw new RuntimeException("Booking not found with id: " + id);
		}
		bookingRepository.deleteById(id);
	}
}
