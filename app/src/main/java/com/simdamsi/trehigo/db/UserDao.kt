package com.simdamsi.trehigo.db

import androidx.room.*
import com.simdamsi.trehigo.models.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(userModel: UserEntity): Long

    @Update
    suspend fun updateUser(userModel: UserEntity)

    @Delete
    suspend fun deleteUser(userModel: UserEntity)

    @Query("DELETE FROM tbl_user")
    suspend fun removeAllUsers()

    @Query("SELECT * FROM tbl_user")
    suspend fun getUsers(): List<UserEntity>
}
