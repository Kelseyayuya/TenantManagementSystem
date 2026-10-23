package com.example.mobileapplabworks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobileapplabworks.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "TENANT_LIFECYCLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "DashboardFragment onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "DashboardFragment onCreateView")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "DashboardFragment onViewCreated")

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

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "DashboardFragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "DashboardFragment onResume")
        updateSummary()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "DashboardFragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "DashboardFragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "DashboardFragment onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "DashboardFragment onDestroy")
    }

    private fun updateSummary() {
        val count = TenantRepository.tenants.size
        val total = TenantRepository.totalRent()
        binding.tvTotalTenants.text = "Total Tenants: $count"
        binding.tvTotalRent.text = "Total Rent: KSh $total"
    }
}
