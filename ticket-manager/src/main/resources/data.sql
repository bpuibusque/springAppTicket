CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users (username, password) VALUES ('user1', 'password1');
INSERT INTO users (username, password) VALUES ('user2', 'password2');

CREATE TABLE IF NOT EXISTS tickets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO tickets (title, description, status, user_id) VALUES ('Ticket 1', 'Description 1', 'new', 1);
INSERT INTO tickets (title, description, status, user_id) VALUES ('Ticket 2', 'Description 2', 'in_progress', 1);
INSERT INTO tickets (title, description, status, user_id) VALUES ('Ticket 3', 'Description 3', 'completed', 2);
