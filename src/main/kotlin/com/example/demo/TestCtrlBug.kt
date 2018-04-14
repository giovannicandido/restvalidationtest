package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.rest.webmvc.BasePathAwareController
import javax.validation.Valid

@RestController
@BasePathAwareController
@RequestMapping("/test-bug")
class TestCtrlBug {

    val logger = LoggerFactory.getLogger(TestCtrl::class.java)

    @RequestMapping(method = [RequestMethod.POST])
    fun test(@RequestBody @Valid test: TestClass) {
        logger.info(test.toString())
    }
}