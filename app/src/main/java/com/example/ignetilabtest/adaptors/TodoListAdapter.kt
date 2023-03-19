package com.example.ignetilabtest.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.databinding.TodoItemBinding
import com.example.ignetilabtest.models.TodoViewModel

class TodoListAdapter(var context: Context, val list: List<TodoRecord>) :
    RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    // Holds the TextView that will add each item to
    class TodoViewHolder(val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding =
            TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.tvItemTitle.setText("" + list[position].title)
        holder.binding.tvItemContent.setText("" + list[position].content)


        holder.binding.ivItemDelete.setOnClickListener {
            val todoViewModel = TodoViewModel(context)
            val todo = TodoRecord(
                id = list[position].id,
                title = list[position].title,
                content = list[position].content
            )
            todoViewModel.deleteTodo(todo)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}