package com.tutorial.blog

import com.samskivert.mustache.Mustache
import com.tutorial.blog.domain.Article
import com.tutorial.blog.domain.User
import com.tutorial.blog.repositories.ArticleRepository
import com.tutorial.blog.repositories.UserRepository
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication

//fun main(args: Array<String>) {
//  runApplication<BlogApplication>(*args)
//}

/** https://spring.io/guides/tutorials/spring-boot-kotlin/ **/

@Bean
fun mustacheCompiler(loader: Mustache.TemplateLoader?) =
    Mustache.compiler().escapeHTML(false).withLoader(loader)

@Bean
fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = CommandLineRunner {
  val smaldini = User("smaldini", "Stephane", "Maldini")
  userRepository.save(smaldini)

  articleRepository.save(Article(
      "Reactor Bismuth is out",
      "Lorem ipsum",
      "dolor **sit** amet https://projectreactor.io/",
      smaldini,
      1
  ))

  articleRepository.save(Article(
      "Reactor Aluminium has landed",
      "Lorem ipsum",
      "dolor **sit** amet https://projectreactor.io/",
      smaldini,
      2
  ))
}

/** Customize app **/
fun main(args: Array<String>) {
  runApplication<BlogApplication>(*args) {
    setBannerMode(Banner.Mode.OFF)
  }
}