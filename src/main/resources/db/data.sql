INSERT INTO BOOKS (title, author, genre, price, quantity) VALUES
('The Great Gatsby', 'F. Scott Fitzgerald', 'Classic', 10.99, 100),
('To Kill a Mockingbird', 'Harper Lee', 'Fiction', 9.99, 150),
('1984', 'George Orwell', 'Dystopian', 8.99, 120),
('The Catcher in the Rye', 'J.D. Salinger', 'Coming-of-Age', 7.99, 200),
('Pride and Prejudice', 'Jane Austen', 'Romance', 11.99, 180),
('The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 12.99, 90),
('The Da Vinci Code', 'Dan Brown', 'Mystery', 13.99, 110);

-- User user/pass
INSERT INTO users (username, password, email, address, authority, enabled)
  values ('user',
    '$2a$12$j3l55hnRu5IFDx/BK0J4LeyS56.ARehJyiI/lmCdJ6izdyxPtjAGq',
    'user@email.com',
    'address',
    'user',
    1),
    ('admin','$2a$12$EYxKQHG2Dq5VriTUdv8NVOSboyLv/myj6BE3mUQf6DOaDbzkpydUK','admin@email.com','address','admin',2);

INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER'),
  ('admin', 'ROLE_ADMIN');