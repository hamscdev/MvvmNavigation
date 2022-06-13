package com.devnight.navigations.ui.dashboard

import android.app.appsearch.AppSearchManager
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devnight.navigations.R
import com.devnight.navigations.adapters.DashboardAdapter
import com.devnight.navigations.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var  dashboardViewModel: DashboardViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        setHasOptionsMenu(true)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.createList()
        dashboardViewModel.modelList.observe(viewLifecycleOwner) {
            binding.recyclerproducts.layoutManager = LinearLayoutManager(context)
            binding.recyclerproducts.adapter = context?.let { it1 -> DashboardAdapter(it, it1) }
        }





        return root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val search  = menu.findItem(R.id.search_action)
        val searchView = search.actionView as androidx.appcompat.widget.SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText != null && newText.isNotEmpty()) {
                    dashboardViewModel.searchText(newText)
                }else{
                    dashboardViewModel.createList()
                }
                return false
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
