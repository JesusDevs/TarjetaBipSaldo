package com.jesusdev.tarjetabipsaldo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jesusdev.tarjetabipsaldo.entitycard.TarjetaBip

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(tarjetaBip: TarjetaBip)

    @Query("SELECT * FROM bip_card ")
    fun getAllDataBase(id: String): LiveData<List<TarjetaBip>>

    @Query("SELECT * FROM bip_card WHERE id = :id")
    fun getBipID(id: String): LiveData<TarjetaBip>
}