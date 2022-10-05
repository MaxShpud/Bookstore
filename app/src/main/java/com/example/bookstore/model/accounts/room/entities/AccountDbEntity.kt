package com.example.bookstore.model.accounts.room.entities

import android.accounts.Account
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.bookstore.model.accounts.entities.SignUpData

@Entity(
    tableName = "account", //название таблицы
    indices = [
        Index("email",unique = true) //
    ]
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true) val id:Long,//первичный ключ, параметр будет генериться автоматически библой room
    @ColumnInfo(collate = ColumnInfo.NOCASE) val email:String,// collate - значит что поле не будет чувствительно к регистру
    val username: String,
    val password: String,
    @ColumnInfo(name = "created_at") val createdAt: Long // колонка в бд будет называться created_at, а не createdAd
) {
    fun toAccount(): Account = Account (
        id = id,
        email = email,
        username = username,
        createdAt = createdAt
    )


    companion object {
        fun fromSignUpData(signUpData: SignUpData) = AccountDbEntity(
            id = 0,
            email = signUpData.email,
            username = signUpData.userName,
            password = signUpData.password,
            createdAt = System.currentTimeMillis()
        )
    }
}