package com.example.mobileapplabworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileapplabworks.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateSummary()

        binding.btnAddTenant.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            findNavController().navigate(action)
        }

        binding.btnViewTenants.setOnClickListener {
            val action = DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()
        updateSummary()
    }

    private fun updateSummary() {
        val count = TenantRepository.tenants.size
        val total = TenantRepository.totalRent()
        binding.tvTotalTenants.text = "Total Tenants: $count"
        binding.tvTotalRent.text = "Total Rent: KSh $total"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
