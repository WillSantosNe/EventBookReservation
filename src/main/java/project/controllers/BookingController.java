package project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.booking.CreateBookingDTO;
import project.dto.booking.ResponseBookingDTO;
import project.dto.booking.UpdateBookingDTO;
import project.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * Endpoint para criar uma nova reserva.
	 */
	@PostMapping
	public ResponseBookingDTO createBooking(@RequestBody CreateBookingDTO dto) {
		return bookingService.createBooking(dto);
	}

	/**
	 * Endpoint para atualizar uma reserva existente.
	 */
	@PutMapping("/{id}")
	public ResponseBookingDTO updateBooking(@PathVariable Long id, @RequestBody UpdateBookingDTO dto) {
		return bookingService.updateBooking(id, dto);
	}

	/**
	 * Endpoint para buscar uma reserva específica pelo ID.
	 */
	@GetMapping("/{id}")
	public ResponseBookingDTO findById(@PathVariable Long id) {
		return bookingService.findById(id);
	}

	/**
	 * Endpoint para listar todas as reservas.
	 */
	@GetMapping
	public List<ResponseBookingDTO> findAll() {
		return bookingService.findAll();
	}

	/**
	 * Endpoint para deletar uma reserva específica.
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		bookingService.delete(id);
	}
}
