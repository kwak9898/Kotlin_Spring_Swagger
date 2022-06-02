package com.example.kotlin_spring_swagger.controller

import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK !!"),
        ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
        ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
        ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    )
    @GetMapping("/hello")
    fun hello(
        @Parameter(
            description = "이름",
            required = true,
            example = "Park"
        ) @RequestParam name: String
    ): ResponseEntity<String> {
        return ResponseEntity.ok("hello $name")
    }
}