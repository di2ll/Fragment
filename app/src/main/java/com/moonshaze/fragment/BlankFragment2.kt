package com.moonshaze.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.moonshaze.fragment.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {
    val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button3.setOnClickListener {
            dataModel.message.value = "Hello from fragment 2"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}