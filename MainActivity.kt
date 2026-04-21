package com.example.tugas3_mobile

import com.example.tugas3_mobile.R
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rbPerempuan)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnTampilkan = findViewById<Button>(R.id.btnTampilkan)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampilkan.setOnClickListener {
            val nama = etNama.text.toString()

            // 1. Validasi Nama
            if (nama.trim().isEmpty()) {
                etNama.error = "Nama wajib diisi!"
                return@setOnClickListener
            }

            // 2. Logika Jenis Kelamin
            var jenisKelamin = ""
            if (rbLaki.isChecked) {
                jenisKelamin = "Laki-laki"
            } else if (rbPerempuan.isChecked) {
                jenisKelamin = "Perempuan"
            }

            if (jenisKelamin == "") {
                Toast.makeText(this, "Pilih jenis kelamin dulu ya!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. Logika Hobi
            val listHobi = mutableListOf<String>()
            if (cbMembaca.isChecked) listHobi.add("Membaca")
            if (cbCoding.isChecked) listHobi.add("Coding")
            if (cbOlahraga.isChecked) listHobi.add("Olahraga")

            val hobiStr = if (listHobi.isEmpty()) "-" else listHobi.joinToString(", ")

            // 4. Output dengan format rapi
            val hasil = """
                Nama      : $nama
                Kelamin   : $jenisKelamin
                Hobi      : $hobiStr
            """.trimIndent()

            tvHasil.text = hasil
        }
    }
}