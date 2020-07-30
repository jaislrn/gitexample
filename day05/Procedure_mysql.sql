
-- Procedure 1 --

DELIMITER $$

CREATE PROCEDURE books_in_range(p1 DOUBLE, p2 DOUBLE)
BEGIN
	SELECT id, name, author, subject, price FROM books WHERE price BETWEEN p1 AND p2;
END;
$$

DELIMITER ;

-- Call Procedure 1
CALL books_in_range(100, 300);

-------------------------------------------------------------------------------------------

-- Procedure 2 --

DELIMITER $$

CREATE PROCEDURE book_price(id_val INT, OUT price_val DOUBLE)
BEGIN
	SELECT price INTO price_val FROM books WHERE id = id_val;
END;
$$

DELIMITER ;

-- Call Procedure 2
CALL book_price(11, @res);
SELECT @res;


