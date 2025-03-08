package project.enums;

public enum RoomStatus {
	ACTIVE(0), 
	INACTIVE(1);

	private int code;

	RoomStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static RoomStatus valueOf(int code) {
		for (RoomStatus value : RoomStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid RoomStatus code: " + code);
	}
}
