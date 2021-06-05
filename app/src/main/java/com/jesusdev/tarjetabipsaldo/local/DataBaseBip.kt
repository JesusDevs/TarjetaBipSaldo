package com.jesusdev.tarjetabipsaldo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jesusdev.tarjetabipsaldo.entitycard.TarjetaBip

@Database(entities = [TarjetaBip::class],version = 1)
abstract class DataBaseBip() : RoomDatabase(){
    abstract fun getBipDao( ):Dao

    companion object {
        @Volatile
        private var INSTANCE : DataBaseBip? = null

        fun getDataBase(context: Context):  DataBaseBip{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    DataBaseBip::class.java,
                    "Dao")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }



}