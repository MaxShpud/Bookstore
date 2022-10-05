package com.example.bookstore.model.accounts.entities

import com.example.bookstore.model.EmptyFieldException
import com.example.bookstore.model.Field
import com.example.bookstore.model.PasswordMismatchException

data class SignUpData(
    val userName: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (userName.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}
