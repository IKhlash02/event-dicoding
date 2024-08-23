package com.example.capstone1.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity(
    @ColumnInfo(name = "summary")
    val summary: String,

    @ColumnInfo(name = "media_cover")
    val mediaCover: String,

    @ColumnInfo(name = "registrants")
    val registrants: Int,

    @ColumnInfo(name = "image_logo")
    val imageLogo: String,

    @ColumnInfo(name = "link")
    val link: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "owner_name")
    val ownerName: String,

    @ColumnInfo(name = "city_name")
    val cityName: String,

    @ColumnInfo(name = "quota")
    val quota: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "begin_time")
    val beginTime: String,

    @ColumnInfo(name = "end_time")
    val endTime: String,

    @ColumnInfo(name = "category")
    val category: String,
)