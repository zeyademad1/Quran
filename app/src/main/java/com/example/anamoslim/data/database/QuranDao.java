package com.example.anamoslim.data.database;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.anamoslim.data.pojo.Aya;
import com.example.anamoslim.data.pojo.Jozz;
import com.example.anamoslim.data.pojo.Sora;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface QuranDao {

    @Query("SELECT * FROM quran WHERE page = :page")
    List<Aya> getAyaByPage(int page);

    @Query("SELECT sora as soraNumber,MIN(page) as startPage,MAX(page)as endPage" +
            ",sora_name_ar as arabicName,sora_name_en as englishName FROM quran WHERE sora = :soraNumber")
    Sora GetSoraByNumber(int soraNumber);


    @Query("SELECT jozz as jozzNumber,MIN(page) as startPage,MAX(page)as endPage FROM quran WHERE jozz = :jozzNumber ")
    Jozz GetJozzByNUmber(int jozzNumber);

    @Query("SELECT * FROM quran WHERE aya_text_emlaey LIKE '%' || :key  || '%' ")
    List<Aya> GetAyaBySubText(String key);


}
