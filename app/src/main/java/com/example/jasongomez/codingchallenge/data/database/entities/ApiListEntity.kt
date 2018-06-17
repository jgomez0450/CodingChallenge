package com.example.jasongomez.codingchallenge.data.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.jasongomez.codingchallenge.data.Remote.models.Main
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather

@Entity(tableName = "ApiListTable")
class ApiListEntity(@ColumnInfo(name = "Dt") var dt: Int, @ColumnInfo(name = "Main") var main: Main, @ColumnInfo(name = "Weather") var weather: List<Weather>) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}