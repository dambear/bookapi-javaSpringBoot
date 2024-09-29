package com.danbear.bookapi.book;


import jakarta.validation.constraints.NotEmpty;

public record Book(
    @NotEmpty
    Integer id,
    @NotEmpty
    String bookName,
    @NotEmpty
    String bookAuthor,
    @NotEmpty
    String bookGenre,
    @NotEmpty
    String yearPublish
) {}
