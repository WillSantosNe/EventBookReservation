package project.enums;

public enum BookingStatus {
	ACTIVE(0), 
	CANCELLED(1), 
	COMPLETED(2);

	private int code;

	// Constructor to associate a specific code with the booking
	BookingStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	// Static method to get the Booking enum value based on its code
	public static BookingStatus valueOf(int code) {
		for (BookingStatus value : BookingStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid BookingStatus code: " + code);
	}
}
