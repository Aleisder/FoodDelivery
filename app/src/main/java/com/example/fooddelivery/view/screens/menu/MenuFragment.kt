package com.example.fooddelivery.view.screens.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.viewmodel.BurgersApiState
import com.example.fooddelivery.viewmodel.BurgersViewModel

class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null
    private lateinit var viewModel: BurgersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[BurgersViewModel::class.java]

        viewModel.state.observe(viewLifecycleOwner) {
            binding!!.pbLoading.visibility = when(it) {
                    BurgersApiState.LOADING -> View.VISIBLE
                    BurgersApiState.DONE -> View.GONE
                    else -> View.GONE
            }
        }

        viewModel.burgers.observe(viewLifecycleOwner) {
            when(it) {
                null -> binding!!.pbLoading.visibility = View.VISIBLE
                else -> {
                    binding!!.rvBurgersList.apply {
                        adapter = BurgerAdapter(it)
                        layoutManager = LinearLayoutManager(requireContext())
                        setHasFixedSize(true)
                    }
                }
            }
        }
/*

*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}