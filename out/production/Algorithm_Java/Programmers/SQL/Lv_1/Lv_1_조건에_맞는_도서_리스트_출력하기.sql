SELECT book_id, date_format(published_date, '%Y-%m-%d')
FROM book
WHERE date_format(published_date, '%Y') = 2021 AND category = '인문'
ORDER BY PUBLISHED_DATE ASC