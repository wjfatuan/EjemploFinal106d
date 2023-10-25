package co.edu.uan.android.ejemplofinal106d.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName="notifications")
data class Notification(
    val message: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

/**
 * table notifications
 *    column uid integer pk
 *    column message varchar
 *    column notification_date date
 */