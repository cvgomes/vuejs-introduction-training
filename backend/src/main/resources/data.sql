DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  completed BOOLEAN NOT NULL
);

INSERT INTO tasks (title, completed) VALUES
('Task ONE', false),
('Task TWO', true),
('Task THREE', false);