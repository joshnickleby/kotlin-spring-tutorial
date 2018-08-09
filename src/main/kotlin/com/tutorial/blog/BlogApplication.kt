package com.tutorial.blog

import com.samskivert.mustache.Mustache
import org.springframework.boot.Banner
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

/** Customize app **/
fun main(args: Array<String>) {
  runApplication<BlogApplication>(*args) {
    setBannerMode(Banner.Mode.OFF)
  }
}