package com.example.librarybookmanagementsystem.repository;

import com.example.librarybookmanagementsystem.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
