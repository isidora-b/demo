ALTER TABLE comment
DROP FOREIGN KEY fk_comment_book;

ALTER TABLE comment
DROP COLUMN bookId;
