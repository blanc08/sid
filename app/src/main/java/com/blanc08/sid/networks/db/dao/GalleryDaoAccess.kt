package com.blanc08.sid.networks.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blanc08.sid.menu.gallery.models.GalleryModel

@Dao
interface GalleryDaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGallery(galleryModel: GalleryModel)

    @Query("SELECT * FROM galleries")
    suspend fun galleries(): List<GalleryModel>

    @Query("DELETE FROM galleries")
    suspend fun deleteAllGallery()

}