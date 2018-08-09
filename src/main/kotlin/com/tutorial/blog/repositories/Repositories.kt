package com.tutorial.blog.repositories

import com.tutorial.blog.domain.Article
import com.tutorial.blog.domain.User
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
  fun findAllByOrderByAddedAtDesc(): Iterable<Article>
}

interface UserRepository : CrudRepository<User, String>