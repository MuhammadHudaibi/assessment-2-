package org.d3if3010.assessment_2.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3010.assessment_2.db.NilaiDao
import org.d3if3010.assessment_2.db.NilaiEntity
import org.d3if3010.assessment_2.model.Hasil
import org.d3if3010.assessment_2.model.Kategori
import org.d3if3010.assessment_2.model.hitung

class HitungViewModel (private val db: NilaiDao) : ViewModel() {
    private val hasilNilai = MutableLiveData<Hasil?>()
    private val navigasi = MutableLiveData<Kategori?>()

    fun hitungNilai(nama: String, hadir: Float, tugas: Float, uts: Float, uas : Float) {
        val dataNilai = NilaiEntity(
            nama = nama,
            hadir = hadir,
            tugas = tugas,
            uts = uts,
            uas = uas
        )
        hasilNilai.value = dataNilai.hitung()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataNilai)
            }
        }
    }

    fun selesaiNavigasi(){
        navigasi.value = null
    }

    fun getNavigasi() : LiveData<Kategori?> = navigasi

    fun mulaiNavigasi(){
        navigasi.value = hasilNilai.value?.kategoriNilai
    }

    fun getHasilNilai(): LiveData<Hasil?> = hasilNilai
}