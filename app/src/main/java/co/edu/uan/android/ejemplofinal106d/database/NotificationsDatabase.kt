package co.edu.uan.android.ejemplofinal106d.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Notification::class), version = 2)
abstract class NotificationsDatabase : RoomDatabase() {
    abstract fun notificationsDao(): NotificationDao

    companion object {
        fun getInstance(ctx: Context): NotificationsDatabase {
            val db =
                Room.databaseBuilder(ctx, NotificationsDatabase::class.java, "notifications_db")
                    .build()
            return db
        }
    }
}