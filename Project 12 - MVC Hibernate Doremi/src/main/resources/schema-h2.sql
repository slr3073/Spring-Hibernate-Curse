DROP TABLE IF EXISTS articles;

CREATE TABLE articles
(
    id    INT PRIMARY KEY,
    title VARCHAR(50),
    type  VARCHAR(50)
)