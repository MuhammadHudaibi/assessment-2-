package org.d3if3010.assessment_2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nilai")
data class NilaiEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var nama: String,
    var hadir : Float,
    var tugas : Float,
    var uts : Float,
    var uas : Float
)