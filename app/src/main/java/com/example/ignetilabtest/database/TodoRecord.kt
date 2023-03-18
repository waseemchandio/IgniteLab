package com.example.ignetilabtest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoRecord (@PrimaryKey(autoGenerate = true) val id: Long?,
                       @ColumnInfo(name = "title") val title: String,
                       @ColumnInfo(name = "content") val content: String)