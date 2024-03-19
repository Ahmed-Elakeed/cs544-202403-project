-- Insert dummy data for Account
INSERT INTO account (id, account_type, description, name) VALUES
                    (1, 'DINING', 'Main dining account', 'Dining Account'),
                    (2, 'CLASS', 'Educational account', 'Class Account'),
                    (3, 'GYM', 'Fitness center account', 'Gym Account');

-- Insert dummy data for Location
INSERT INTO location (id, description, location_type, name) VALUES
                     (1, 'Main dining facility','DINING', 'Dining Hall'),
                     (2, 'Educational facility', 'CLASS', 'Classroom'),
                     (3, 'Gym and fitness facility','GYM', 'Fitness Center'),
                     (4, 'Study and research facility', 'LIBRARY', 'Library');

-- Insert dummy data for Event
INSERT INTO event (id, description, end_date_time, name, start_date_time, schedule_id) VALUES
                (1, 'Annual campus festival', '2024-04-03', 'Spring Festival', '2024-04-01', 1),
                (2, 'Guest lecture on software engineering', '2024-03-20', 'Software Engineering Lecture', '2024-03-20', 2),
                (3, 'Campus-wide fitness event', '2024-05-31', 'Fitness Challenge', '2024-05-01', 3);

-- Insert dummy data for Schedule
INSERT INTO schedule (id, end_date_time, start_date_time, description) VALUES
                     (1, '2024-04-03', '2024-04-01', 'Spring Festival Schedule'),
                     (2, '2024-03-20', '2024-03-20', 'Software Engineering Lecture Schedule'),
                     (3, '2024-05-31', '2024-05-01', 'Fitness Challenge Schedule');

-- Insert dummy data for Member
INSERT INTO member (id, barcode, email, first_name, last_name) VALUES
                   (1, 123456, 'johndoe@example.com', 'John', 'Doe'),
                   (2, 654321, 'alicesmith@example.com', 'Alice', 'Smith'),
                   (3, 'Bob', 987654, 'bobjohnson@example.com', 'Johnson');

-- Insert dummy data for Role
INSERT INTO role (id, role) VALUES
                 (1, 'Faculty'),
                 (2, 'Student'),
                 (3, 'Staff');

-- Insert dummy data for Session
INSERT INTO session (id, description, end_date_time, name, start_date_time, event_id, schedule_id) VALUES
                    (1, 'Spring Festival Opening Ceremony', '2024-04-01 12:00:00', 'Kickoff event for Spring Festival', '2024-04-01 10:00:00', 1, 1),
                    (2, 'Software Engineering Lecture', '2024-03-20 14:00:00', 'Guest lecture on software engineering', '2024-03-22 16:00:00', 2, 2),
                    (3, 'Fitness Challenge Kickoff', '2024-05-01 08:00:00', 'Start of the fitness challenge', '2024-05-03 10:00:00', 3, 3);

-- Insert dummy data for Scanner
INSERT INTO scanner (id, account_type, scanner_code, location_id, event_id) VALUES
                    (1, 1, 'Scanner1', 1, 1),
                    (2, 2, 'Scanner2', 2, 2),
                    (3, 3, 'Scanner3', 3, 3);

-- Insert dummy data for ScanRecord
INSERT INTO scan_records (id, scan_date_time, record_owner_id, scanner_id, record_scanner_id) VALUES
                         (1, '2024-04-01 10:30:00', 1, 1, 1),
                         (2, '2024-03-20 14:30:00', 2, 2, 2),
                         (3, '2024-05-01 08:30:00', 3, 3, 3);
