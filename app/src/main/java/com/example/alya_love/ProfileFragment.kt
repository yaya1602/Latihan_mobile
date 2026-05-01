package com.example.alya_love

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

class ProfileFragment : Fragment() {

    // 🔗 GANTI DENGAN LINK SOSMED KAMU
    private val LINK_LINKEDIN = "https://www.linkedin.com/in/alya-deka-danisha-9b689a387?utm_source=share_via&utm_content=profile&utm_medium=member_android"
    private val LINK_GITHUB = "https://github.com/yaya1602/Latihan_mobile"
    private val LINK_INSTAGRAM = "https://www.instagram.com/alya_dkd?igsh=MWF0Mm9hdDEzczJtNA=="

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 LinkedIn Click
        view.findViewById<ImageView>(R.id.btn_linkedin).setOnClickListener {
            openUrl(LINK_LINKEDIN, "LinkedIn")
        }

        // 🔹 GitHub Click
        view.findViewById<ImageView>(R.id.btn_github).setOnClickListener {
            openUrl(LINK_GITHUB, "GitHub")
        }

        // 🔹 Instagram Click
        view.findViewById<ImageView>(R.id.btn_instagram).setOnClickListener {
            openUrl(LINK_INSTAGRAM, "Instagram")
        }
    }

    // Fungsi helper untuk buka URL
    private fun openUrl(url: String, appName: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Tidak bisa membuka $appName", Toast.LENGTH_SHORT).show()
        }
    }
}