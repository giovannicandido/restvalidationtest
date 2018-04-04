package com.example.demo

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

/**
 * @author Giovanni Silva
 */
class TestClass(
        @NotEmpty
        @Email
        val email: String
) {
    override fun toString(): String {
        return email
    }
}