-- Insert dummy data for Account
INSERT INTO account (id, account_type, description, name) VALUES
                    (15, 'DINING', 'Main', 'Dining'),
                    (16, 'CLASS', 'Educational', 'Class'),
                    (17, 'GYM', 'Fitness', 'Gym');

-- Insert dummy data for Location
INSERT INTO location (id, description, location_type, name) VALUES
                     (1, 'Main dining facility','Dining', 'Dining Hall'),
                     (2, 'Educational facility', 'Class', 'Classroom'),
                     (3, 'Gym and fitness facility','Gym', 'Fitness Center'),
                     (4, 'Study and research facility', 'Library', 'Library');

-- Insert dummy data for Schedule
INSERT INTO schedule (id, end_date_time, start_date_time, description) VALUES
                     (4, '2024-04-03', '2024-04-01', 'Spring Festival Schedule'),
                     (5, '2024-03-20', '2024-03-20', 'Software Engineering Lecture Schedule'),
                     (6, '2024-05-31', '2024-05-01', 'Fitness Challenge Schedule');

-- Insert dummy data for Member
INSERT INTO member (id, barcode, email, first_name, last_name) VALUES
                   (4, 123456, 'johndoe@example.com', 'John', 'Doe'),
                   (5, 654321, 'alicesmith@example.com', 'Alice', 'Smith'),
                   (6, 987654, 'Bob', 'bobjohnson@example.com', 'Johnson');

-- Insert dummy data for Role
INSERT INTO role (id, role) VALUES
                 (4, 'Faculty'),
                 (5, 'Student'),
                 (6, 'Staff');

-- Insert dummy data for Session
INSERT INTO session (id, description, end_date_time, name, start_date_time, schedule_id) VALUES
                    (1, 'Spring Festival Opening Ceremony', '2024-04-01 12:00:00', 'Kickoff event for Spring Festival', '2024-04-01 10:00:00', 4),
                    (2, 'Software Engineering Lecture', '2024-03-20 14:00:00', 'Guest lecture on software engineering', '2024-03-22 16:00:00', 5),
                    (3, 'Fitness Challenge Kickoff', '2024-05-01 08:00:00', 'Start of the fitness challenge', '2024-05-03 10:00:00', 5);

-- Insert dummy data for Event
INSERT INTO event (id, description, end_date_time, name, start_date_time, schedule_id) VALUES
                  (4, 'Annual campus festival', '2024-04-03', 'Spring Festival', '2024-04-01', 4),
                  (5, 'Guest lecture on software engineering', '2024-03-20', 'Software Engineering Lecture', '2024-03-20', 5),
                  (6, 'Campus-wide fitness event', '2024-05-31', 'Fitness Challenge', '2024-05-01', 6);

-- Insert dummy data for Scanner
INSERT INTO scanner (id, account_type, scanner_code, event_id, location_id) VALUES
                    (1, 1, '123', 4, 1),
                    (2, 2, '456', 5, 2),
                    (3, 3, '789', 6, 3);

-- Insert dummy data for ScanRecord
INSERT INTO scan_records (scan_date_time, id, member_id, session_id, event_id,scanner_id) VALUES
                         ('2024-04-01 10:30:00', 1, 4, 1, 4, 1),
                         ('2024-03-20 14:30:00', 2, 2, 2, 2),
                         ('2024-05-01 08:30:00', 3, 3, 3, 3);
