DROP TABLE IF EXISTS article;
DROP TABLE IF EXISTS category;

CREATE TABLE category(
    name VARCHAR(35) PRIMARY KEY NOT NULL

);
CREATE TABLE article(
    articleID INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(60),
    timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    content VARCHAR(2000) NOT NULL,
    imagelink TEXT,
    important BOOLEAN,
    rating INTEGER,
    categoryName VARCHAR(35),
    CONSTRAINT article_fk1 FOREIGN KEY (categoryName) REFERENCES category(name)
);