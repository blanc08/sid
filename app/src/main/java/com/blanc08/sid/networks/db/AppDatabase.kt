package com.blanc08.sid.networks.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blanc08.sid.data.DB_NAME
import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.menu.listplace.models.PlaceModel
import com.blanc08.sid.menu.maps.models.PinModel
import com.blanc08.sid.networks.db.dao.GalleryDaoAccess
import com.blanc08.sid.networks.db.dao.PinDaoAccess
import com.blanc08.sid.networks.db.dao.PlaceDaoAccess

@Database(entities = [PlaceModel::class, GalleryModel::class, PinModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placeDaoAccess(): PlaceDaoAccess

    abstract fun galleryDaoAccess(): GalleryDaoAccess

    abstract fun pinDaoAccess(): PinDaoAccess

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}