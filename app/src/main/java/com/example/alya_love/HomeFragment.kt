package com.example.alya_love

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.alya_love.pertemuan_3.CustomActivity
import com.example.alya_love.pertemuan_3.ThirdActivity
import com.example.alya_love.pertemuan_3.ThirdResultActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 🔹 Tombol Rumus → Pindah ke bangun_ruang
        view.findViewById<Button>(R.id.btnRumus).setOnClickListener {
            val intent = Intent(requireContext(), bangun_ruang::class.java)
            intent.putExtra("judul", "Mobileku")
            intent.putExtra("deskripsi", "Ini aplikasi punya Alya")
            startActivity(intent)
        }

        // 🔹 Tombol Custom 1 → Pindah ke ThirdResultActivity
        view.findViewById<Button>(R.id.btnCustom1).setOnClickListener {
            val intent = Intent(requireContext(), ThirdResultActivity::class.java)
            intent.putExtra("judul", "Mobileku")
            intent.putExtra("deskripsi", "Ini aplikasi punya Alya")
            startActivity(intent)
        }

        // 🔹 Tombol Start → Buka Website
        view.findViewById<Button>(R.id.btnStart).setOnClickListener {
            val url = "https://alya-project.alwaysdata.net/dashboard-guest"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        // 🔹 Tombol Logout → Kembali ke login
        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    // Clear shared preferences
                    val sharedPref = requireActivity().getSharedPreferences("LOGIN", android.content.Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    // Pindah ke halaman login
                    val intent = Intent(requireContext(), ThirdActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        return view
    }
}