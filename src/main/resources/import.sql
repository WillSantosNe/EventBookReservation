
INSERT INTO user_tb (username, password, email, role) VALUES ('john_doe', 'password123', 'john.doe@example.com', 0); -- 0 for ADMIN
INSERT INTO user_tb (username, password, email, role) VALUES ('jane_smith', 'mypassword', 'jane.smith@example.com', 1); -- 1 for USER

-- Insertions for the 'tb_room' table
INSERT INTO tb_room (name, location, capacity, status) VALUES ('Conference Room A', 'First Floor', 10, 0); -- 0 for AVAILABLE
INSERT INTO tb_room (name, location, capacity, status) VALUES ('Meeting Room B', 'Second Floor', 5, 1); -- 1 for UNAVAILABLE

-- Insertions for the 'tb_booking' table
INSERT INTO tb_booking (start_date_time, end_date_time, purpose, status, user_id, room_id) VALUES ('2025-03-09T10:00:00Z', '2025-03-09T12:00:00Z', 'Project discussion', 0, 1, 1); -- 0 for PENDING
INSERT INTO tb_booking (start_date_time, end_date_time, purpose, status, user_id, room_id) VALUES ('2025-03-10T14:00:00Z', '2025-03-10T15:00:00Z', 'Team meeting', 1, 2, 2); -- 1 for CONFIRMED
