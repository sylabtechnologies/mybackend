-- Drop table if it exists to ensure a clean start in development (optional, but useful for H2)

DROP TABLE IF EXISTS userr;

 

-- Create the 'userr' table DO NOT USE user keyword

CREATE TABLE userr (

    id BIGINT AUTO_INCREMENT PRIMARY KEY, -- Maps to @Id and @GeneratedValue

    name VARCHAR(255) NOT NULL,            -- Maps to 'name' field

    email VARCHAR(255) NOT NULL UNIQUE     -- Maps to 'email' field, assuming it should be unique

);
