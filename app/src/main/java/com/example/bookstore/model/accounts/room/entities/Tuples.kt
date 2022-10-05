package com.example.bookstore.model.accounts.room.entities
//вытягивание определенных данных из room

data class AccountSignInTuples(
    val id: Long,
    val password: String
)

class AccountUpdateUserNameTuples(
    val id: Long,
    val username: String
)