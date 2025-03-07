package project.enums;

/*
Enum indicating the type of user in the application.
It can either be an ADMIN or a USER with common characteristics.
 */
public enum Role {
    ADMIN(0),
    USER(1);
    
    private int code;
    
    // Constructor to associate a specific code with the role
    Role(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
    
    // Static method to get the Role enum value based on its code
    public static Role valueOf(int code) {
        for(Role value : Role.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Role code: " + code);
    }
}
