package com.example.bookstore.model.accounts.room

import androidx.room.Dao
import androidx.room.Query
import com.example.bookstore.model.accounts.room.entities.AccountSignInTuples

@Dao
interface AccountsDao {

    //@Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email : String): AccountSignInTuples?

}