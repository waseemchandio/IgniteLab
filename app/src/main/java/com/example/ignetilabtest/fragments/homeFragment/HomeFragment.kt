package com.example.ignetilabtest.fragments.homeFragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.ignetilabtest.R
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    var todoRecord: TodoRecord? = null
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        binding.btnSave.setOnClickListener {
            saveTodo()
        }

        val view = binding.root
        return view
    }



    private fun saveTodo() {
        if (validateFields()) {


        }
    }

    private fun validateFields(): Boolean {
        if (binding.etTodoTitle.text.isEmpty()) {
            binding.tilTodoTitle.error = getString(R.string.pleaseEnterTitle)
            binding.etTodoTitle.requestFocus()
            return false
        }
        if (binding.etTodoContent.text.isEmpty()) {
            binding.tilTodoContent.error = getString(R.string.pleaseEnterContent)
            binding.etTodoContent.requestFocus()
            return false
        }
        return true
    }

}