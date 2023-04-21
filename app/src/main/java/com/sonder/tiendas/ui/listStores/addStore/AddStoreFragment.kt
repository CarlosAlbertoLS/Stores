package com.sonder.tiendas.ui.listStores.addStore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sonder.tiendas.R
import com.sonder.tiendas.databinding.FragmentAddStoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddStoreFragment : Fragment() {
    private var _binding: FragmentAddStoreBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddStoreBinding.inflate(inflater,container, false)
        return binding.root
    }
}