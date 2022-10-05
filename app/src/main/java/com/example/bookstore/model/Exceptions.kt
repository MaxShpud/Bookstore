package com.example.bookstore.model

import java.lang.reflect.Field

open class AppException : RuntimeException()

class EmptyFieldException(
    val field: com.example.bookstore.model.Field
) : AppException()

class PasswordMismatchException : AppException()

class AccountAlreadyExistsException : AppException()

class AuthException : AppException()

class StorageException: AppException()