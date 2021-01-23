package com.karvozavr.spinoza

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpinozaApplication


fun main(args: Array<String>) {
  @Suppress("SpreadOperator")
  runApplication<SpinozaApplication>(*args)
}
