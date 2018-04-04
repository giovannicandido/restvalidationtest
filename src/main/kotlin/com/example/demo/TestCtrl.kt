package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * @author Giovanni Silva
 */
@RestController
@RequestMapping("/test")
class TestCtrl {
    val logger = LoggerFactory.getLogger(TestCtrl::class.java)

    @RequestMapping(method = [RequestMethod.POST])
    fun test(@RequestBody @Valid test: TestClass) {
         logger.info(test.toString())
    }
}