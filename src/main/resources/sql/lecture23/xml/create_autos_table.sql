CREATE TABLE autos (
    id SERIAL UNIQUE,
    model varchar(100),
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
