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
CREATE TABLE comment(
    commentID INTEGER AUTO_INCREMENT PRIMARY KEY,
    commentUser VARCHAR(30) NOT NULL,
    content VARCHAR(255),
    articleID INTEGER NOT NULL,
    timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    commentRating INTEGER NOT NULL,
    CONSTRAINT comment_fk1 FOREIGN KEY(articleID) REFERENCES article(articleID) ON DELETE CASCADE
);