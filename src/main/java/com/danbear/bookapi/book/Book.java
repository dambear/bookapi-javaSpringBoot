package com.danbear.bookapi.book;


public record Book(

    Integer id,
    String bookName,
    String bookAuthor,
    String bookGenre,
    String yearPublish
) {}
