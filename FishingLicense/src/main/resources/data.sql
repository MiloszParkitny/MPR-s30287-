INSERT INTO users (first_name, last_name, phone, email) VALUES
( 'Jan', 'Kowalski', '123-456-789', 'jan.kowalski@example.com'),
( 'Anna', 'Nowak', '987-654-321', 'anna.nowak@example.com'),
( 'Piotr', 'Zieliński', '456-789-123', 'piotr.zielinski@example.com'),
( 'Magda', 'Wiśniewska', '321-654-987', 'magda.wisniewska@example.com'),
( 'Tomasz', 'Wójcik', '789-123-456', 'tomasz.wojcik@example.com'),
( 'Katarzyna', 'Lewandowska', '654-321-789', 'katarzyna.lewandowska@example.com'),
( 'Marek', 'Dąbrowski', '987-123-654', 'marek.dabrowski@example.com');

INSERT INTO fishing_area ( name, location) VALUES
( 'Jezioro Śniardwy', 'Warmińsko-Mazurskie'),
( 'Jezioro Mamry', 'Pomorskie'),
( 'Jezioro Wigry', 'Podlaskie'),
( 'Jezioro Solińskie', 'Podkarpackie'),
( 'Jezioro Rożnowskie', 'Małopolskie'),
( 'Jezioro Żywieckie', 'Śląskie'),
( 'Jezioro Nyskie', 'Opolskie');

INSERT INTO license ( license_number, issue_date, expiry_date, user_id, fishing_area_id) VALUES
( 'LIC10001', '2025-01-01', '2025-12-31', 1, 1),
( 'LIC10002', '2025-01-02', '2025-12-31', 2, 2),
( 'LIC10003', '2025-01-03', '2025-12-31', 3, 3),
( 'LIC10004', '2025-01-04', '2025-12-31', 4, 4),
( 'LIC10005', '2025-01-05', '2025-12-31', 5, 5),
( 'LIC10006', '2025-01-06', '2025-12-31', 6, 5),
( 'LIC10007', '2025-01-07', '2025-12-31', 7, 7);