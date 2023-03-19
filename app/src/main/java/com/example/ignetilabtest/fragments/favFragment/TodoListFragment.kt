package com.example.ignetilabtest.fragments.favFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ignetilabtest.R
import com.example.ignetilabtest.adaptors.TodoListAdapter
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.databinding.FragmentFavouriteBinding
import com.example.ignetilabtest.databinding.FragmentHomeBinding
import com.example.ignetilabtest.models.TodoViewModel

class TodoListFragment : Fragment() {
    lateinit var binding: FragmentFavouriteBinding
    lateinit var recyViewTodoLayoutManager: LinearLayoutManager
    lateinit var todoListAdapter: TodoListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        initView()
        getTodoList()
        val view = binding.root
        return view
    }

    private fun initView() {

        recyViewTodoLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvTodoList.layoutManager = recyViewTodoLayoutManager

    }

    private fun getTodoList() {
        val todoViewModel = TodoViewModel(requireContext().applicationContext)
        todoViewModel.getAllTodoList().observe(viewLifecycleOwner, Observer {
            todoListAdapter = TodoListAdapter(requireContext(), it)
            binding.rvTodoList.adapter = todoListAdapter
        })

    }
}