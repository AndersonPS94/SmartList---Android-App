package com.teamkode.smartlist.data.converters

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


class LocalDateTimeConverter {
    @TypeConverter
    fun fromTimesTamp(value:Long?): LocalDateTime?{
        return  value?.let {
            Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDateTime()
        }
    }
    @TypeConverter
    fun localDateTimeToTimestamp(date: LocalDateTime?):Long?{
        return date?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }
}