package com.application.courselibrary.repository.service;


import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id) {
        Author author;
        author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find author "));
        return author;
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author author;
        author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find author "));
        authorRepository.deleteById(author.getId());
    }
}
