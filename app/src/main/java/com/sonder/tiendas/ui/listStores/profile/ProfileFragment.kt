package com.sonder.tiendas.ui.listStores.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sonder.tiendas.R
import com.sonder.tiendas.data.network.utils.SessionManager
import com.sonder.tiendas.databinding.FragmentProfileBinding
import com.sonder.tiendas.ui.login.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener { logout() }
    }

    private fun logout() {
        SessionManager.clearData(requireContext())
        startActivity(MainActivity.createMin(requireContext()))
    }
}