INSERT INTO persons (id, first_name, last_name, email) VALUES (1, 'Hahn', 'Booker', 'harn.booker@example.com');
INSERT INTO persons (id, first_name, last_name, email) VALUES (2, 'Kimberlee', 'Stiedemann', 'kimberlee.stiedemann@example.com');
INSERT INTO persons (id, first_name, last_name, email) VALUES (3, 'Rubi', 'Muller', 'rubi.muller@example.com');

INSERT INTO users (id, username, password, user_role, person_id) VALUES (1, 'admin', '$2y$12$ZrBfWY6v6xN6uo1BUdWmfeAfMBoCdlduskOffcXwRTxRD8NfkOENu', 'ADMIN', 1);
