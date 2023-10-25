package co.edu.uan.android.ejemplofinal106d.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import co.edu.uan.android.ejemplofinal106d.database.Notification

@Dao
interface NotificationDao {
    @Insert
    suspend fun create(notification: Notification)
    @Query("SELECT * FROM notifications")
    suspend fun findAll(): List<Notification>
    @Query("SELECT * FROM notifications WHERE uid = :uid")
    suspend fun findByUid(uid: Int): Notification
}