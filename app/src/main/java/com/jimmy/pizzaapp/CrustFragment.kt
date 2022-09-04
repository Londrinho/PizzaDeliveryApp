package com.jimmy.pizzaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentCrustBinding
import com.jimmy.pizzaapp.model.OrderViewModel


class CrustFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()

    private lateinit var binding: FragmentCrustBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_crust, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding?.crustFragment = this

        binding?.apply {
            viewModel = sharedViewModel
            nextBtn.setOnClickListener { gotToPizzaScreen() }
            lifecycleOwner = viewLifecycleOwner
        }


    }

    fun gotToPizzaScreen(){
        if(sharedViewModel.hasNoCrust()){
            sharedViewModel.setCrust(getString(R.string.deep_pan))
        }
        findNavController().navigate(R.id.action_crustFragment_to_pizzaFragment)
    }


}