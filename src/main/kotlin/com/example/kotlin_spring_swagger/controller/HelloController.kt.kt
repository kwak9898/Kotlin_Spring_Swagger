package com.example.kotlin_spring_swagger.controller

import com.example.kotlin_spring_swagger.bean.Greeting
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api(value = "user", description = "Rest API for user operations", tags = arrayOf("User API"))
class HelloController {

    @RequestMapping(
        value = ["/hello/{name}"],
        method = arrayOf(RequestMethod.GET),
        produces = arrayOf("application/json")
    )
    @ApiOperation(value = "Display greeting message to non-admin user", response = Greeting::class)
    @ApiResponses(
        value = *arrayOf(
            ApiResponse(code = 200, message = "OK !!"),
            ApiResponse(code = 404, message = "The resource not found")
        )
    )
    fun message(@PathVariable name: String): Greeting {
        return Greeting(name, "Hello!!"+name)
    }
}