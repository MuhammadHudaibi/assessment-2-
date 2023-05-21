package org.d3if3010.assessment_2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.d3if3010.assessment_2.R
import org.d3if3010.assessment_2.databinding.FragmentSaranBinding
import org.d3if3010.assessment_2.model.Kategori

class SaranFragment : Fragment() {
    private lateinit var binding: FragmentSaranBinding
    private val args: SaranFragmentArgs by navArgs()

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private fun updateUI (kategori: Kategori) {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        when (kategori) {
            Kategori.C -> {
                actionBar?.title = getString(R.string.judul_C)
                binding.textView.text = getString(R.string.saran_C)
            }
            Kategori.A -> {
                actionBar?.title = getString(R.string.judul_A)
                binding.textView.text = getString(R.string.saran_A)
            }
            Kategori.B -> {
                actionBar?.title = getString(R.string.judul_B)
                binding.textView.text = getString(R.string.saran_B)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateUI(args.kategori)
    }
}