package com.example.ignetilabtest.fragments.homeFragment

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.ignetilabtest.R
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.database.UserDao
import com.example.ignetilabtest.databinding.FragmentHomeBinding
import com.example.ignetilabtest.models.TodoViewModel


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

            val id = if (todoRecord != null) todoRecord?.id else null
            val todoViewModel  = TodoViewModel(requireContext().applicationContext)
            val todo = TodoRecord(id = id, title = binding.etTodoTitle.text.toString(), content = binding.etTodoContent.text.toString())
            todoViewModel.saveTodo(todo)


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