package org.d3if3010.assessment_2.model

import org.d3if3010.assessment_2.db.NilaiEntity

fun NilaiEntity.hitung() : Hasil{
    val nama = nama
    val hasil = (0.20 * hadir) + (0.25 * tugas) + (0.25 * uts) + (0.30 * uas)
    val huruf =
        when {
            hasil >= 85 -> Kategori.A
            hasil >= 70 && hasil <= 85 -> Kategori.B
            else -> Kategori.C
        }
    return Hasil(nama, hasil, huruf)
}