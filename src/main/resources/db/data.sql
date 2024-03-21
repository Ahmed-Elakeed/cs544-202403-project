-- Insert dummy data for Role
INSERT INTO role (id, role) VALUES
                                (1, 'Faculty'),
                                (2, 'Student'),
                                (3, 'Staff'),
                                (4, 'Administrator'),
                                (5, 'Librarian'),
                                (6, 'Technician'),
                                (7, 'Manager'),
                                (8, 'Assistant'),
                                (9, 'Researcher'),
                                (10, 'Intern');

-- Insert dummy data for Member
INSERT INTO member (id, barcode, email, first_name, last_name) VALUES
                                                                   (1, 1234067, 'john.doe@example.com', 'John', 'Doe'),
                                                                   (2, 2345678, 'alice.smith@example.com', 'Alice', 'Smith'),
                                                                   (3, 3456789, 'bob.johnson@example.com', 'Bob', 'Johnson'),
                                                                   (4, 4567899, 'emily.brown@example.com', 'Emily', 'Brown'),
                                                                   (5, 5678901, 'michael.jones@example.com', 'Michael', 'Jones'),
                                                                   (6, 6789012, 'sarah2.wilson@example.com', 'Sarah', 'Wilson'),
                                                                   (7, 7890123, 'david.martinez@example.com', 'David', 'Martinez'),
                                                                   (8, 8901237, 'laura.jackson@example.com', 'Laura', 'Jackson'),
                                                                   (9, 9012378, 'matthew.thomas@example.com', 'Matthew', 'Thomas'),
                                                                   (10, 1267899, 'oliver.taylor@example.com', 'Oliver', 'Taylor'),
-- Add more rows as needed
                                                                   (11, 2367880, 'victoria.adams@example.com', 'Victoria', 'Adams'),
                                                                   (12, 345611, 'chris.robinson@example.com', 'Chris', 'Robinson'),
                                                                   (13, 458912, 'jessica.wood@example.com', 'Jessica', 'Wood'),
                                                                   (14, 5678933, 'samuel.perez@example.com', 'Samuel', 'Perez'),
                                                                   (15, 6781244, 'michelle.lee@example.com', 'Michelle', 'Lee'),
                                                                   (16, 7890355, 'daniel.green@example.com', 'Daniel', 'Green'),
                                                                   (17, 8904566, 'amanda.wright@example.com', 'Amanda', 'Wright'),
                                                                   (18, 9012677, 'ryan.hill@example.com', 'Ryan', 'Hill'),
                                                                   (19, 123568, 'emily.evans@example.com', 'Emily', 'Evans'),
                                                                   (20, 2345679, 'nathan.sanchez@example.com', 'Nathan', 'Sanchez'),
                                                                   (21, 345678, 'lauren.roberts@example.com', 'Lauren', 'Roberts'),
                                                                   (22, 4567121, 'derek.phillips@example.com', 'Derek', 'Phillips'),
                                                                   (23, 567832, 'julia.scott@example.com', 'Julia', 'Scott'),
                                                                   (24, 678943, 'kevin.miller@example.com', 'Kevin', 'Miller'),
                                                                   (25, 781234, 'hannah.collins@example.com', 'Hannah', 'Collins'),
                                                                   (26, 890165, 'lucaas.lee@example.com', 'Lucas', 'Lee'),
                                                                   (27, 901256, 'natalie.ward@example.com', 'Natalie', 'Ward'),
                                                                   (28, 123457, 'andrew.cook@example.com', 'Andrew', 'Cook'),
                                                                   (29, 23458908, 'alexander.turner@example.com', 'Alexander', 'Turner'),
                                                                   (30, 36789019, 'melissa.morgan@example.com', 'Melissa', 'Morgan'),
-- Add more rows as needed
                                                                   (31, 7890120, 'michael.hall@example.com', 'Michael', 'Hall'),
                                                                   (32, 5690131, 'jennifer.carter@example.com', 'Jennifer', 'Carter'),
                                                                   (33, 6789342, 'dylan.hughes@example.com', 'Dylan', 'Hughes'),
                                                                   (34, 7890453, 'grace2.white@example.com', 'Grace', 'White'),
                                                                   (35, 8904564, 'brandon.king@example.com', 'Brandon', 'King'),
                                                                   (36, 9045675, 'emma.roberts@example.com', 'Emma', 'Roberts'),
                                                                   (37, 137896, 'ethan.baker@example.com', 'Ethan', 'Baker'),
                                                                   (38, 2348907, 'sophia.wilson@example.com', 'Sophia', 'Wilson'),
                                                                   (39, 3459018, 'luke.collins@example.com', 'Luke', 'Collins'),
                                                                   (40, 4567129, 'zoe.johnston@example.com', 'Zoe', 'Johnston'),
                                                                   (41, 5678230, 'chloe.murphy@example.com', 'Chloe', 'Murphy'),
                                                                   (42, 6789341, 'jake.stewart@example.com', 'Jake', 'Stewart'),
                                                                   (43, 7801452, 'rebecca.morris@example.com', 'Rebecca', 'Morris'),
                                                                   (44, 8901563, 'bradley.smith@example.com', 'Bradley', 'Smith'),
                                                                   (45, 9014574, 'lily.robinson@example.com', 'Lily', 'Robinson'),
                                                                   (46, 137895, 'connor.wood@example.com', 'Connor', 'Wood'),
                                                                   (47, 2348906, 'natalie.martin@example.com', 'Natalie', 'Martin'),
                                                                   (48, 3456717, 'carter.hill@example.com', 'Carter', 'Hill'),
                                                                   (49, 4567890, 'jennifer.green@example.com', 'Jennifer', 'Green'),
                                                                   (50, 8901239, 'molly.roberts@example.com', 'Molly', 'Roberts'),
-- Add more rows as needed
                                                                   (51, 6789040, 'andrew.morgan@example.com', 'Andrew', 'Morgan'),
                                                                   (52, 7890151, 'emily.adams@example.com', 'Emily', 'Adams'),
                                                                   (53, 8901562, 'david.johnson@example.com', 'David', 'Johnson'),
                                                                   (54, 9012673, 'sarah.wilson@example.com', 'Sarah', 'Wilson'),
                                                                   (55, 123894, 'michael.smith@example.com', 'Michael', 'Smith'),
                                                                   (56, 2348905, 'amanda.carter@example.com', 'Amanda', 'Carter'),
                                                                   (57, 3456716, 'laura.morris@example.com', 'Laura', 'Morris'),
                                                                   (58, 4567897, 'charlie.2brown@example.com', 'Charlie', 'Brown'),
                                                                   (59, 5671238, 'kelly.jones@example.com', 'Kelly', 'Jones'),
                                                                   (60, 6782349, 'ethan.miller@example.com', 'Ethan', 'Miller'),
                                                                   (61, 7801450, 'madison.hill@example.com', 'Madison', 'Hill'),
                                                                   (62, 8904561, 'jacob.evans@example.com', 'Jacob', 'Evans'),
                                                                   (63, 9045672, 'olivia.taylor@example.com', 'Olivia', 'Taylor'),
                                                                   (64, 104893, 'lucas.lee@example.com', 'Lucas', 'Lee'),
                                                                   (65, 2345904, 'zoe.williams@example.com', 'Zoe', 'Williams'),
                                                                   (66, 3459015, 'ethan.adams@example.com', 'Ethan', 'Adams'),
                                                                   (67, 45890126, 'grace.white@example.com', 'Grace', 'White'),
                                                                   (68, 5690127, 'connor.jones@example.com', 'Connor', 'Jones'),
                                                                   (69, 6789348, 'sophia.clark@example.com', 'Sophia', 'Clark'),
                                                                   (70, 7893459, 'alexandeer.turner@example.com', 'Alexander', 'Turner'),
-- Add more rows as needed
                                                                   (71, 8904560, 'madison.roberts@example.com', 'Madison', 'Roberts'),
                                                                   (72, 9015671, 'charlie.brown@example.com', 'Charlie', 'Brown'),
                                                                   (73, 17892, 'zoe.wilson@example.com', 'Zoe', 'Wilson'),
                                                                   (74, 2345603, 'daniel.thomas@example.com', 'Daniel', 'Thomas'),
                                                                   (75, 3459014, 'emily.johnson@example.com', 'Emily', 'Johnson'),
                                                                   (76, 4560125, 'jack.smith@example.com', 'Jack', 'Smith'),
                                                                   (77, 5601236, 'sophia.martin@example.com', 'Sophia', 'Martin'),
                                                                   (78, 6712347, 'noah.adams@example.com', 'Noah', 'Adams'),
                                                                   (79, 7893458, 'oliiver.taylor@example.com', 'Oliver', 'Taylor'),
                                                                   (80, 8904569, 'ellie.king@example.com', 'Ellie', 'King'),
                                                                   (81, 9012370, 'emily.robinson@example.com', 'Emily', 'Robinson'),
                                                                   (82, 1237891, 'michael.turner@example.com', 'Michael', 'Turner'),
                                                                   (83, 23402, 'ellie.collins@example.com', 'Ellie', 'Collins'),
                                                                   (84, 3456013, 'nathan.smith@example.com', 'Nathan', 'Smith'),
                                                                   (85, 4560124, 'anna.williams@example.com', 'Anna', 'Williams'),
                                                                   (86, 5671235, 'etthan.miller@example.com', 'Ethan', 'Miller'),
                                                                   (87, 6782346, 'sophia.jackson@example.com', 'Sophia', 'Jackson'),
                                                                   (88, 7823457, 'hannah.white@example.com', 'Hannah', 'White'),
                                                                   (89, 8901268, 'molly.davis@example.com', 'Molly', 'Davis'),
                                                                   (90, 234569, 'ryan.garcia@example.com', 'Ryan', 'Garcia'),
-- Add more rows as needed
                                                                   (91, 1267890, 'isabella.smith@example.com', 'Isabella', 'Smith'),
                                                                   (92, 2348901, 'ethan.hall@example.com', 'Ethan', 'Hall'),
                                                                   (93, 3456012, 'olivia.morris@example.com', 'Olivia', 'Morris'),
                                                                   (94, 4590123, 'michael.davis@example.com', 'Michael', 'Davis'),
                                                                   (95, 5678234, 'zoee.williams@example.com', 'Zoe', 'Williams'),
                                                                   (96, 6789345, 'charlie.martin@example.com', 'Charlie', 'Martin'),
                                                                   (97, 0123456, 'sophia.thomas@example.com', 'Sophia', 'Thomas'),
                                                                   (98, 1234567, 'jack.roberts@example.com', 'Jack', 'Roberts'),
                                                                   (99, 9345678, 'emily.collins@example.com', 'Emily', 'Collins'),
                                                                   (100, 9873210, 'nathan.harris@example.com', 'Nathan', 'Harris');
-- Add more rows as needed

-- Insert dummy data for Account
INSERT INTO account (id, account_type, description, name, balance) VALUES
                    (1, 'DINING', 'Main', 'Dining', 30),
                    (2, 'CLASS', 'Educational', 'Class', 60),
                    (3, 'GYM', 'Fitness', 'Gym', 28);

INSERT INTO location (id, description, location_type, name) VALUES
                                                                (1, 'Main dining facility', 'Dining', 'Dining Hall'),
                                                                (2, 'Educational facility', 'Class', 'Classroom'),
                                                                (3, 'Gym and fitness facility', 'Gym', 'Fitness Center'),
                                                                (4, 'Study and research facility', 'Library', 'Library'),
                                                                (5, 'Conference facility', 'Library', 'Conference Room'),
                                                                (6, 'Administrative office', 'Class', 'Administration Office'),
                                                                (7, 'Entertainment facility', 'Library', 'Entertainment Hall'),
                                                                (8, 'Healthcare facility', 'Class', 'Medical Center'),
                                                                (9, 'Technology facility', 'Library', 'Tech Lab'),
                                                                (10, 'Outdoor recreational facility', 'Library', 'Outdoor Park'),
                                                                (11, 'Art and creative facility', 'Class', 'Art Studio'),
                                                                (12, 'Transportation facility', 'Gym', 'Bus Terminal'),
                                                                (13, 'Retail and shopping facility', 'Gym', 'Shopping Mall'),
                                                                (14, 'Financial facility', 'Gym', 'Bank'),
                                                                (15, 'Religious facility', 'Class', 'Chapel');

-- Insert dummy data for Schedule
INSERT INTO schedule (id, description, end_date_time, start_date_time) VALUES
                                                                           (1, 'Spring Festival Schedule', '2024-04-03', '2024-04-01'),
                                                                           (2, 'Software Engineering Lecture Schedule', '2024-03-20', '2024-03-20'),
                                                                           (3, 'Fitness Challenge Schedule', '2024-05-31', '2024-05-01'),
                                                                           (4, 'Welcome Week Schedule', '2024-08-30', '2024-08-28'),
                                                                           (5, 'Codeathon Schedule', '2024-06-15', '2024-06-10'),
                                                                           (6, 'Mindfulness Retreat Schedule', '2024-07-10', '2024-07-05'),
                                                                           (7, 'Career Fair Schedule', '2024-09-25', '2024-09-23'),
                                                                           (8, 'Startup Summit Schedule', '2024-11-15', '2024-11-10'),
                                                                           (9, 'FitStart Workshop Schedule', '2024-06-30', '2024-06-25'),
                                                                           (10, 'Creative Arts Showcase Schedule', '2024-07-20', '2024-07-15'),
                                                                           (11, 'STEM Expo Schedule', '2024-04-30', '2024-04-25'),
                                                                           (12, 'Marathon Prep Course Schedule', '2024-10-20', '2024-10-15'),
                                                                           (13, 'Summer Sounds Schedule', '2024-08-15', '2024-08-10'),
                                                                           (14, 'Book Fest Schedule', '2024-05-20', '2024-05-15'),
                                                                           (15, 'Zumba Mania Schedule', '2024-09-10', '2024-09-05'),
                                                                           (16, 'CodeCamp Schedule', '2024-06-30', '2024-06-25'),
                                                                           (17, 'AI Summit Schedule', '2024-11-30', '2024-11-25'),
                                                                           (18, 'Muscle Mania Schedule', '2024-08-25', '2024-08-20'),
                                                                           (19, 'Drama Night Schedule', '2024-07-25', '2024-07-20'),
                                                                           (20, 'Speak Up Seminar Schedule', '2024-10-10', '2024-10-05');
-- Insert dummy data for Event
INSERT INTO event (id, account_type, description, end_date_time, name, start_date_time, schedule_id) VALUES
                                                                                                         (1, 'CLASS', 'Annual campus festival', '2024-04-03', 'Spring Festival', '2024-04-01', 1),
                                                                                                         (2, 'CLASS', 'Guest lecture on software engineering', '2024-03-20', 'Software Engineering Lecture', '2024-03-20', 2),
                                                                                                         (3, 'GYM', 'Campus-wide fitness event', '2024-05-31', 'Fitness Challenge', '2024-05-01', 3),
                                                                                                         (4, 'CLASS', 'Semester commencement event', '2024-08-30', 'Welcome Week', '2024-08-28', 4),
                                                                                                         (5, 'CLASS', 'Programming competition', '2024-06-15', 'Codeathon', '2024-06-10', 5),
                                                                                                         (6, 'GYM', 'Yoga and meditation workshop', '2024-07-10', 'Mindfulness Retreat', '2024-07-05', 6),
                                                                                                         (7, 'CLASS', 'Industry networking event', '2024-09-25', 'Career Fair', '2024-09-23', 7),
                                                                                                         (8, 'CLASS', 'Panel discussion on entrepreneurship', '2024-11-15', 'Startup Summit', '2024-11-10', 8),
                                                                                                         (9, 'GYM', 'Fitness seminar for beginners', '2024-06-30', 'FitStart Workshop', '2024-06-25', 9),
                                                                                                         (10, 'CLASS', 'Art exhibition', '2024-07-20', 'Creative Arts Showcase', '2024-07-15', 10),
                                                                                                         (11, 'CLASS', 'Science fair', '2024-04-30', 'STEM Expo', '2024-04-25', 11),
                                                                                                         (12, 'GYM', 'Marathon training program', '2024-10-20', 'Marathon Prep Course', '2024-10-15', 12),
                                                                                                         (13, 'CLASS', 'Music concert', '2024-08-15', 'Summer Sounds', '2024-08-10', 13),
                                                                                                         (14, 'CLASS', 'Literature festival', '2024-05-20', 'Book Fest', '2024-05-15', 14),
                                                                                                         (15, 'GYM', 'Zumba party', '2024-09-10', 'Zumba Mania', '2024-09-05', 15),
                                                                                                         (16, 'CLASS', 'Coding workshop', '2024-06-30', 'CodeCamp', '2024-06-25', 16),
                                                                                                         (17, 'CLASS', 'Artificial Intelligence conference', '2024-11-30', 'AI Summit', '2024-11-25', 17),
                                                                                                         (18, 'GYM', 'Bodybuilding competition', '2024-08-25', 'Muscle Mania', '2024-08-20', 18),
                                                                                                         (19, 'CLASS', 'Theater performance', '2024-07-25', 'Drama Night', '2024-07-20', 19),
                                                                                                         (20, 'CLASS', 'Workshop on communication skills', '2024-10-10', 'Speak Up Seminar', '2024-10-05', 20);

-- Insert dummy data for Session
INSERT INTO session (id, description, end_date_time, name, start_date_time, schedule_id) VALUES
                                                                                             (1, 'Spring Festival Opening Ceremony', '2024-04-01 12:00:00', 'Kickoff event for Spring Festival', '2024-04-01 10:00:00', 1),
                                                                                             (2, 'Software Engineering Lecture', '2024-03-20 14:00:00', 'Guest lecture on software engineering', '2024-03-22 16:00:00', 2),
                                                                                             (3, 'Fitness Challenge Kickoff', '2024-05-01 08:00:00', 'Start of the fitness challenge', '2024-05-03 10:00:00', 3),
                                                                                             (4, 'Annual Conference Day 1', '2024-06-01 09:00:00', 'Conference Day 1', '2024-06-01 08:00:00', 4),
                                                                                             (5, 'Annual Conference Day 2', '2024-06-02 09:00:00', 'Conference Day 2', '2024-06-02 08:00:00', 4),
                                                                                             (6, 'Annual Conference Day 3', '2024-06-03 09:00:00', 'Conference Day 3', '2024-06-03 08:00:00', 4),
                                                                                             (7, 'Summer Camp Registration', '2024-07-01 09:00:00', 'Registration for Summer Camp', '2024-07-01 08:00:00', 5),
                                                                                             (8, 'Summer Camp Week 1', '2024-07-08 09:00:00', 'Summer Camp Week 1', '2024-07-08 08:00:00', 5),
                                                                                             (9, 'Summer Camp Week 2', '2024-07-15 09:00:00', 'Summer Camp Week 2', '2024-07-15 08:00:00', 5),
                                                                                             (10, 'Summer Camp Week 3', '2024-07-22 09:00:00', 'Summer Camp Week 3', '2024-07-22 08:00:00', 5),
                                                                                             (11, 'Summer Camp Week 4', '2024-07-29 09:00:00', 'Summer Camp Week 4', '2024-07-29 08:00:00', 5),
                                                                                             (12, 'Summer Camp Week 5', '2024-08-05 09:00:00', 'Summer Camp Week 5', '2024-08-05 08:00:00', 5),
                                                                                             (13, 'Summer Camp Week 6', '2024-08-12 09:00:00', 'Summer Camp Week 6', '2024-08-12 08:00:00', 6),
                                                                                             (14, 'Summer Camp Week 7', '2024-08-19 09:00:00', 'Summer Camp Week 7', '2024-08-19 08:00:00', 6),
                                                                                             (15, 'Summer Camp Week 8', '2024-08-26 09:00:00', 'Summer Camp Week 8', '2024-08-26 08:00:00', 6),
                                                                                             (16, 'Summer Camp Week 9', '2024-09-02 09:00:00', 'Summer Camp Week 9', '2024-09-02 08:00:00', 6),
                                                                                             (17, 'Summer Camp Week 10', '2024-09-09 09:00:00', 'Summer Camp Week 10', '2024-09-09 08:00:00', 5),
                                                                                             (18, 'Summer Camp Week 11', '2024-09-16 09:00:00', 'Summer Camp Week 11', '2024-09-16 08:00:00', 15),
                                                                                             (19, 'Summer Camp Week 12', '2024-09-23 09:00:00', 'Summer Camp Week 12', '2024-09-23 08:00:00', 15),
                                                                                             (20, 'Summer Camp Week 13', '2024-09-30 09:00:00', 'Summer Camp Week 13', '2024-09-30 08:00:00', 15),
                                                                                             (21, 'Summer Camp Week 14', '2024-10-07 09:00:00', 'Summer Camp Week 14', '2024-10-07 08:00:00', 15),
                                                                                             (22, 'Summer Camp Week 15', '2024-10-14 09:00:00', 'Summer Camp Week 15', '2024-10-14 08:00:00', 15),
                                                                                             (23, 'Summer Camp Week 16', '2024-10-21 09:00:00', 'Summer Camp Week 16', '2024-10-21 08:00:00', 15),
                                                                                             (24, 'Summer Camp Week 17', '2024-10-28 09:00:00', 'Summer Camp Week 17', '2024-10-28 08:00:00', 15),
                                                                                             (25, 'Summer Camp Week 18', '2024-11-04 09:00:00', 'Summer Camp Week 18', '2024-11-04 08:00:00', 5),
                                                                                             (26, 'Summer Camp Week 19', '2024-11-11 09:00:00', 'Summer Camp Week 19', '2024-11-11 08:00:00', 5),
                                                                                             (27, 'Summer Camp Week 20', '2024-11-18 09:00:00', 'Summer Camp Week 20', '2024-11-18 08:00:00', 5),
                                                                                             (28, 'Summer Camp Week 21', '2024-11-25 09:00:00', 'Summer Camp Week 21', '2024-11-25 08:00:00', 15),
                                                                                             (29, 'Summer Camp Week 22', '2024-12-02 09:00:00', 'Summer Camp Week 22', '2024-12-02 08:00:00', 5),
                                                                                             (30, 'Summer Camp Week 23', '2024-12-09 09:00:00', 'Summer Camp Week 23', '2024-12-09 08:00:00', 8),
                                                                                             (31, 'Summer Camp Week 24', '2024-12-16 09:00:00', 'Summer Camp Week 24', '2024-12-16 08:00:00', 8),
                                                                                             (32, 'Summer Camp Week 25', '2024-12-23 09:00:00', 'Summer Camp Week 25', '2024-12-23 08:00:00', 8),
                                                                                             (33, 'Summer Camp Week 26', '2024-12-30 09:00:00', 'Summer Camp Week 26', '2024-12-30 08:00:00', 8),
                                                                                             (34, 'Summer Camp Week 27', '2025-01-06 09:00:00', 'Summer Camp Week 27', '2025-01-06 08:00:00', 10),
                                                                                             (35, 'Summer Camp Week 28', '2025-01-13 09:00:00', 'Summer Camp Week 28', '2025-01-13 08:00:00', 10),
                                                                                             (36, 'Summer Camp Week 29', '2025-01-20 09:00:00', 'Summer Camp Week 29', '2025-01-20 08:00:00', 10),
                                                                                             (37, 'Summer Camp Week 30', '2025-01-27 09:00:00', 'Summer Camp Week 30', '2025-01-27 08:00:00', 11),
                                                                                             (38, 'Summer Camp Week 31', '2025-02-03 09:00:00', 'Summer Camp Week 31', '2025-02-03 08:00:00', 11),
                                                                                             (39, 'Summer Camp Week 32', '2025-02-10 09:00:00', 'Summer Camp Week 32', '2025-02-10 08:00:00', 11),
                                                                                             (40, 'Summer Camp Week 33', '2025-02-17 09:00:00', 'Summer Camp Week 33', '2025-02-17 08:00:00', 7),
                                                                                             (41, 'Summer Camp Week 34', '2025-02-24 09:00:00', 'Summer Camp Week 34', '2025-02-24 08:00:00', 7),
                                                                                             (42, 'Summer Camp Week 35', '2025-03-03 09:00:00', 'Summer Camp Week 35', '2025-03-03 08:00:00', 19),
                                                                                             (43, 'Summer Camp Week 36', '2025-03-10 09:00:00', 'Summer Camp Week 36', '2025-03-10 08:00:00', 20),
                                                                                             (44, 'Summer Camp Week 37', '2025-03-17 09:00:00', 'Summer Camp Week 37', '2025-03-17 08:00:00', 20),
                                                                                             (45, 'Summer Camp Week 38', '2025-03-24 09:00:00', 'Summer Camp Week 38', '2025-03-24 08:00:00', 18),
                                                                                             (46, 'Summer Camp Week 39', '2025-03-31 09:00:00', 'Summer Camp Week 39', '2025-03-31 08:00:00', 5),
                                                                                             (47, 'Summer Camp Week 40', '2025-04-07 09:00:00', 'Summer Camp Week 40', '2025-04-07 08:00:00', 5),
                                                                                             (48, 'Summer Camp Week 41', '2025-04-14 09:00:00', 'Summer Camp Week 41', '2025-04-14 08:00:00', 20),
                                                                                             (49, 'Summer Camp Week 42', '2025-04-21 09:00:00', 'Summer Camp Week 42', '2025-04-21 08:00:00', 5),
                                                                                             (50, 'Summer Camp Week 43', '2025-04-28 09:00:00', 'Summer Camp Week 43', '2025-04-28 08:00:00', 5),
                                                                                             (51, 'Summer Camp Week 44', '2025-05-05 09:00:00', 'Summer Camp Week 44', '2025-05-05 08:00:00', 5),
                                                                                             (52, 'Summer Camp Week 45', '2025-05-12 09:00:00', 'Summer Camp Week 45', '2025-05-12 08:00:00', 15),
                                                                                             (53, 'Summer Camp Week 46', '2025-05-19 09:00:00', 'Summer Camp Week 46', '2025-05-19 08:00:00', 5),
                                                                                             (54, 'Summer Camp Week 47', '2025-05-26 09:00:00', 'Summer Camp Week 47', '2025-05-26 08:00:00', 5),
                                                                                             (55, 'Summer Camp Week 48', '2025-06-02 09:00:00', 'Summer Camp Week 48', '2025-06-02 08:00:00', 15),
                                                                                             (56, 'Summer Camp Week 49', '2025-06-09 09:00:00', 'Summer Camp Week 49', '2025-06-09 08:00:00', 5),
                                                                                             (57, 'Summer Camp Week 50', '2025-06-16 09:00:00', 'Summer Camp Week 50', '2025-06-16 08:00:00', 15),
                                                                                             (58, 'Summer Camp Week 51', '2025-06-23 09:00:00', 'Summer Camp Week 51', '2025-06-23 08:00:00', 15),
                                                                                             (59, 'Summer Camp Week 52', '2025-06-30 09:00:00', 'Summer Camp Week 52', '2025-06-30 08:00:00', 15),
                                                                                             (60, 'Summer Camp Week 53', '2025-07-07 09:00:00', 'Summer Camp Week 53', '2025-07-07 08:00:00', 3),
                                                                                             (61, 'Summer Camp Week 54', '2025-07-14 09:00:00', 'Summer Camp Week 54', '2025-07-14 08:00:00', 3),
                                                                                             (62, 'Summer Camp Week 55', '2025-07-21 09:00:00', 'Summer Camp Week 55', '2025-07-21 08:00:00', 3),
                                                                                             (63, 'Summer Camp Week 56', '2025-07-28 09:00:00', 'Summer Camp Week 56', '2025-07-28 08:00:00', 3),
                                                                                             (64, 'Summer Camp Week 57', '2025-08-04 09:00:00', 'Summer Camp Week 57', '2025-08-04 08:00:00', 3),
                                                                                             (65, 'Summer Camp Week 58', '2025-08-11 09:00:00', 'Summer Camp Week 58', '2025-08-11 08:00:00', 3),
                                                                                             (66, 'Summer Camp Week 59', '2025-08-18 09:00:00', 'Summer Camp Week 59', '2025-08-18 08:00:00', 3),
                                                                                             (67, 'Summer Camp Week 60', '2025-08-25 09:00:00', 'Summer Camp Week 60', '2025-08-25 08:00:00', 3),
                                                                                             (68, 'Summer Camp Week 61', '2025-09-01 09:00:00', 'Summer Camp Week 61', '2025-09-01 08:00:00', 3),
                                                                                             (69, 'Summer Camp Week 62', '2025-09-08 09:00:00', 'Summer Camp Week 62', '2025-09-08 08:00:00', 5),
                                                                                             (70, 'Summer Camp Week 63', '2025-09-15 09:00:00', 'Summer Camp Week 63', '2025-09-15 08:00:00', 3),
                                                                                             (71, 'Summer Camp Week 64', '2025-09-22 09:00:00', 'Summer Camp Week 64', '2025-09-22 08:00:00', 2),
                                                                                             (72, 'Summer Camp Week 65', '2025-09-29 09:00:00', 'Summer Camp Week 65', '2025-09-29 08:00:00', 2),
                                                                                             (73, 'Summer Camp Week 66', '2025-10-06 09:00:00', 'Summer Camp Week 66', '2025-10-06 08:00:00', 2),
                                                                                             (74, 'Summer Camp Week 67', '2025-10-13 09:00:00', 'Summer Camp Week 67', '2025-10-13 08:00:00', 2),
                                                                                             (75, 'Summer Camp Week 68', '2025-10-20 09:00:00', 'Summer Camp Week 68', '2025-10-20 08:00:00', 2),
                                                                                             (76, 'Summer Camp Week 69', '2025-10-27 09:00:00', 'Summer Camp Week 69', '2025-10-27 08:00:00', 1),
                                                                                             (77, 'Summer Camp Week 70', '2025-11-03 09:00:00', 'Summer Camp Week 70', '2025-11-03 08:00:00', 1),
                                                                                             (78, 'Summer Camp Week 71', '2025-11-10 09:00:00', 'Summer Camp Week 71', '2025-11-10 08:00:00', 1),
                                                                                             (79, 'Summer Camp Week 72', '2025-11-17 09:00:00', 'Summer Camp Week 72', '2025-11-17 08:00:00', 9),
                                                                                             (80, 'Summer Camp Week 73', '2025-11-24 09:00:00', 'Summer Camp Week 73', '2025-11-24 08:00:00', 9),
                                                                                             (81, 'Summer Camp Week 74', '2025-12-01 09:00:00', 'Summer Camp Week 74', '2025-12-01 08:00:00', 9),
                                                                                             (82, 'Summer Camp Week 75', '2025-12-08 09:00:00', 'Summer Camp Week 75', '2025-12-08 08:00:00', 9),
                                                                                             (83, 'Summer Camp Week 76', '2025-12-15 09:00:00', 'Summer Camp Week 76', '2025-12-15 08:00:00', 9),
                                                                                             (84, 'Summer Camp Week 77', '2025-12-22 09:00:00', 'Summer Camp Week 77', '2025-12-22 08:00:00', 9),
                                                                                             (85, 'Summer Camp Week 78', '2025-12-29 09:00:00', 'Summer Camp Week 78', '2025-12-29 08:00:00', 12),
                                                                                             (86, 'Summer Camp Week 79', '2026-01-05 09:00:00', 'Summer Camp Week 79', '2026-01-05 08:00:00', 12),
                                                                                             (87, 'Summer Camp Week 80', '2026-01-12 09:00:00', 'Summer Camp Week 80', '2026-01-12 08:00:00', 12),
                                                                                             (88, 'Summer Camp Week 81', '2026-01-19 09:00:00', 'Summer Camp Week 81', '2026-01-19 08:00:00', 14),
                                                                                             (89, 'Summer Camp Week 82', '2026-01-26 09:00:00', 'Summer Camp Week 82', '2026-01-26 08:00:00', 14),
                                                                                             (90, 'Summer Camp Week 83', '2026-02-02 09:00:00', 'Summer Camp Week 83', '2026-02-02 08:00:00', 14),
                                                                                             (91, 'Summer Camp Week 84', '2026-02-09 09:00:00', 'Summer Camp Week 84', '2026-02-09 08:00:00', 5),
                                                                                             (92, 'Summer Camp Week 85', '2026-02-16 09:00:00', 'Summer Camp Week 85', '2026-02-16 08:00:00', 4),
                                                                                             (93, 'Summer Camp Week 86', '2026-02-23 09:00:00', 'Summer Camp Week 86', '2026-02-23 08:00:00', 4),
                                                                                             (94, 'Summer Camp Week 87', '2026-03-02 09:00:00', 'Summer Camp Week 87', '2026-03-02 08:00:00', 4),
                                                                                             (95, 'Summer Camp Week 88', '2026-03-09 09:00:00', 'Summer Camp Week 88', '2026-03-09 08:00:00', 5),
                                                                                             (96, 'Summer Camp Week 89', '2026-03-16 09:00:00', 'Summer Camp Week 89', '2026-03-16 08:00:00', 5),
                                                                                             (97, 'Summer Camp Week 90', '2026-03-23 09:00:00', 'Summer Camp Week 90', '2026-03-23 08:00:00', 5),
                                                                                             (98, 'Summer Camp Week 91', '2026-03-30 09:00:00', 'Summer Camp Week 91', '2026-03-30 08:00:00', 5),
                                                                                             (99, 'Summer Camp Week 92', '2026-04-06 09:00:00', 'Summer Camp Week 92', '2026-04-06 08:00:00', 7),
                                                                                             (100, 'Summer Camp Week 93', '2026-04-13 09:00:00', 'Summer Camp Week 93', '2026-04-13 08:00:00', 5);



-- Insert dummy data for Scanner
INSERT INTO scanner (id, account_type, scanner_code, event_id, location_id)
VALUES
    (1, 'CLASS', 'A-123', 1, 1),
    (2, 'GYM', 'Class-456', 2, 2),
    (3, 'GYM', 'Lib-789', 3, 3),
    (4, 'CLASS', 'A-124', 4, 4),
    (5, 'GYM', 'Class-457', 5, 5),
    (6, 'GYM', 'Lib-790', 6, 6),
    (7, 'CLASS', 'A-125', 7, 7),
    (8, 'GYM', 'Class-458', 8, 8),
    (9, 'GYM', 'Lib-791', 9, 9),
    (10, 'CLASS', 'A-126', 10, 10);


-- Insert dummy data for ScanRecord
INSERT INTO scan_records (id, scan_date_time, event_id, member_id, session_id, scanner_id)
VALUES
    -- Event 1
    (1, '2024-04-01 10:30:00', 1, 1, 1, 1),
    (2, '2024-04-02 11:45:00', 1, 2, 1, 2),
    (3, '2024-04-03 09:15:00', 1, 3, 1, 3),
    -- Event 2
    (4, '2024-04-04 14:30:00', 2, 1, 2, 1),
    (5, '2024-04-05 13:00:00', 2, 2, 2, 2),
    (6, '2024-04-06 12:15:00', 2, 3, 2, 3),
    -- Event 3
    (7, '2024-04-07 16:45:00', 3, 1, 3, 1),
    (8, '2024-04-08 17:30:00', 3, 2, 3, 2),
    (9, '2024-04-09 18:00:00', 3, 3, 3, 3),
    -- Repeat the pattern for 180 more records
    (10, '2024-04-10 10:30:00', 1, 1, 1, 1),
    (11, '2024-04-11 11:45:00', 1, 2, 1, 2),
    (12, '2024-04-12 09:15:00', 1, 3, 1, 3),
    (13, '2024-04-13 14:30:00', 2, 1, 2, 1),
    (14, '2024-04-14 13:00:00', 2, 2, 2, 2),
    (15, '2024-04-15 12:15:00', 2, 3, 2, 3),
    (16, '2024-04-16 16:45:00', 3, 1, 3, 1),
    (17, '2024-04-17 17:30:00', 3, 2, 3, 2),
    (18, '2024-04-18 18:00:00', 3, 3, 3, 3),
    (19, '2024-04-19 10:30:00', 1, 1, 1, 1),
    (20, '2024-04-20 11:45:00', 1, 2, 1, 2),
    -- Repeat the pattern for 9 more times (totaling 200 records)
    (21, '2024-04-01 10:30:00', 1, 1, 1, 1),
    (22, '2024-04-02 11:45:00', 1, 2, 1, 2),
    (23, '2024-04-03 09:15:00', 1, 3, 1, 3),
    (24, '2024-04-04 14:30:00', 2, 1, 2, 1),
    (25, '2024-04-05 13:00:00', 2, 2, 2, 2),
    (26, '2024-04-06 12:15:00', 2, 3, 2, 3),
    (27, '2024-04-07 16:45:00', 3, 1, 3, 1),
    (28, '2024-04-08 17:30:00', 3, 2, 3, 2),
    (29, '2024-04-09 18:00:00', 3, 3, 3, 3),
    (30, '2024-04-10 10:30:00', 1, 1, 1, 1),
    -- Add 170 more records with similar patterns
    (31, '2024-04-11 11:45:00', 1, 2, 1, 2),
    (32, '2024-04-12 09:15:00', 1, 3, 1, 3),
    (33, '2024-04-13 14:30:00', 2, 1, 2, 1),
    (34, '2024-04-14 13:00:00', 2, 2, 2, 2),
    (35, '2024-04-15 12:15:00', 2, 3, 2, 3),
    -- Repeat the pattern for 159 more times (totaling 200 records)
    (36, '2024-04-16 16:45:00', 3, 1, 3, 1),
    (37, '2024-04-17 17:30:00', 3, 2, 3, 2),
    (38, '2024-04-18 18:00:00', 3, 3, 3, 3),
    (39, '2024-04-19 10:30:00', 1, 1, 1, 1),
    (40, '2024-04-20 11:45:00', 1, 2, 1, 2),
    -- Repeat the pattern for 20 more times (totaling 60 records)
    (41, '2024-04-01 10:30:00', 1, 1, 1, 1),
    (42, '2024-04-02 11:45:00', 1, 2, 1, 2),
    (43, '2024-04-03 09:15:00', 1, 3, 1, 3),
    (44, '2024-04-04 14:30:00', 2, 1, 2, 1),
    (45, '2024-04-05 13:00:00', 2, 2, 2, 2),
    (46, '2024-04-06 12:15:00', 2, 3, 2, 3),
    (47, '2024-04-07 16:45:00', 3, 1, 3, 1),
    (48, '2024-04-08 17:30:00', 3, 2, 3, 2),
    (49, '2024-04-09 18:00:00', 3, 3, 3, 3),
    (50, '2024-04-10 10:30:00', 1, 1, 1, 1),
    -- Repeat the pattern for 10 more times (totaling 70 records)
    (51, '2024-04-11 11:45:00', 1, 2, 1, 2),
    (52, '2024-04-12 09:15:00', 1, 3, 1, 3),
    (53, '2024-04-13 14:30:00', 2, 1, 2, 1),
    (54, '2024-04-14 13:00:00', 2, 2, 2, 2),
    (55, '2024-04-15 12:15:00', 2, 3, 2, 3),
    (56, '2024-04-16 16:45:00', 3, 1, 3, 1),
    (57, '2024-04-17 17:30:00', 3, 2, 3, 2),
    (58, '2024-04-18 18:00:00', 3, 3, 3, 3),
    (59, '2024-04-19 10:30:00', 1, 1, 1, 1),
    (60, '2024-04-20 11:45:00', 1, 2, 1, 2),
    -- Repeat the pattern for 5 more times (totaling 75 records)
    (61, '2024-04-01 10:30:00', 1, 1, 1, 1),
    (62, '2024-04-02 11:45:00', 1, 2, 1, 2),
    (63, '2024-04-03 09:15:00', 1, 3, 1, 3),
    (64, '2024-04-04 14:30:00', 2, 1, 2, 1),
    (65, '2024-04-05 13:00:00', 2, 2, 2, 2),
    (66, '2024-04-06 12:15:00', 2, 3, 2, 3),
    -- Repeat the pattern for 3 more times (totaling 78 records)
    (67, '2024-04-07 16:45:00', 3, 1, 3, 1),
    (68, '2024-04-08 17:30:00', 3, 2, 3, 2),
    (69, '2024-04-09 18:00:00', 3, 3, 3, 3),
    -- Repeat the pattern for 1 more time (totaling 79 records)
    (70, '2024-04-10 10:30:00', 1, 1, 1, 1),
    (71, '2024-04-11 11:45:00', 1, 2, 1, 2),
    (72, '2024-04-12 09:15:00', 1, 3, 1, 3),
    (73, '2024-04-13 14:30:00', 2, 1, 2, 1),
    (74, '2024-04-14 13:00:00', 2, 2, 2, 2),
    (75, '2024-04-15 12:15:00', 2, 3, 2, 3),
    (76, '2024-04-16 16:45:00', 3, 1, 3, 1),
    (77, '2024-04-17 17:30:00', 3, 2, 3, 2),
    (78, '2024-04-18 18:00:00', 3, 3, 3, 3),
    (79, '2024-04-19 10:30:00', 1, 1, 1, 1),
    (80, '2024-04-20 11:45:00', 1, 2, 1, 2),
    (81, '2024-04-01 10:30:00', 1, 1, 1, 1),
    (82, '2024-04-02 11:45:00', 1, 2, 1, 2),
    (83, '2024-04-03 09:15:00', 1, 3, 1, 3),
    (84, '2024-04-04 14:30:00', 2, 1, 2, 1),
    (85, '2024-04-05 13:00:00', 2, 2, 2, 2),
    (86, '2024-04-06 12:15:00', 2, 3, 2, 3),
    (87, '2024-04-07 16:45:00', 3, 1, 3, 1),
    (88, '2024-04-08 17:30:00', 3, 2, 3, 2),
    (89, '2024-04-09 18:00:00', 3, 3, 3, 3),
    (90, '2024-04-10 10:30:00', 1, 1, 1, 1),
    (91, '2024-04-11 11:45:00', 1, 2, 1, 2),
    (92, '2024-04-12 09:15:00', 1, 3, 1, 3),
    (93, '2024-04-13 14:30:00', 2, 1, 2, 1),
    (94, '2024-04-14 13:00:00', 2, 2, 2, 2),
    (95, '2024-04-15 12:15:00', 2, 3, 2, 3),
    (96, '2024-04-16 16:45:00', 3, 1, 3, 1),
    (97, '2024-04-17 17:30:00', 3, 2, 3, 2),
    (98, '2024-04-18 18:00:00', 3, 3, 3, 3),
    (99, '2024-04-19 10:30:00', 1, 1, 1, 1),
    (100, '2024-04-20 11:45:00', 1, 2, 1, 2);

-- Insert dummy data for event_members
# INSERT INTO event_members (event_id, member_id) VALUES
#                                 (1, 1),
#                                 (2, 2),
#                                 (3, 3);
-- Insert dummy data for Event-Member relationships
INSERT INTO event_members (event_id, member_id)
SELECT
    e.id AS event_id,
    m.id AS member_id
FROM
    event e
        CROSS JOIN
    member m;

# -- Insert dummy data for member_roles
# INSERT INTO member_roles (member_id, role_id) VALUES
#                           (1, 1),
#                           (2, 2),
#                           (3, 3);
-- Insert dummy data for member_roles
INSERT INTO member_roles (member_id, role_id)
SELECT
    m.id AS member_id,
    r.id AS role_id
FROM
    member m
        CROSS JOIN
    role r;

# -- Insert dummy data for member_sessions
# INSERT INTO member_sessions (session_id, member_id) VALUES
#                              (1, 1),
#                              (2, 2),
#                              (3, 3);
-- Insert dummy data for member_sessions
INSERT INTO member_sessions (session_id, member_id)
SELECT
    s.id AS session_id,
    m.id AS member_id
FROM
    session s
        CROSS JOIN
    member m;

# -- Insert dummy data for role_accounts
# INSERT INTO role_accounts (role_id, account_id) VALUES
#                           (1, 1),
#                           (2, 2),
#                           (3, 3);
-- Insert dummy data for member_sessions
INSERT INTO role_accounts (role_id, account_id)
SELECT
    r.id AS role_id,
    a.id AS account_id
FROM
    role r
        CROSS JOIN
    account a;

