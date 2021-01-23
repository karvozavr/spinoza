package com.karvozavr.spinoza.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

  @GetMapping("/")
  fun getHelloMessage(): ResponseEntity<String> {
    return ResponseEntity<String>("<h1>Hello, this is Spinoza server v0.0.1</h1>", HttpStatus.OK)
  }
}
