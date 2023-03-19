package com.example.ignetilabtest.adaptors

import android.content.Context
import android.graphics.Color
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.databinding.TodoItemBinding
import com.example.ignetilabtest.models.TodoViewModel

class TodoListAdapter(var context: Context, val list: List<TodoRecord>) :
    RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    val todoViewModel = TodoViewModel(context)

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
        holder.binding.ivItemChecked.isChecked = list[position].status


        if (list[position].status) {
            holder.binding.ivItemChecked.isChecked = true
        }

        holder.binding.ivItemChecked.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                val todo = TodoRecord(
                    id = list[position].id,
                    title = list[position].title,
                    content = list[position].content,
                    status = true
                )
                todoViewModel.updateTodo(todo)

                Toast.makeText(
                    context,
                    list[position].title + " Task Completed",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val todo = TodoRecord(
                    id = list[position].id,
                    title = list[position].title,
                    content = list[position].content,
                    status = false
                )
                todoViewModel.updateTodo(todo)
            }
        }

        holder.binding.ivItemDelete.setOnClickListener {

            val todo = TodoRecord(
                id = list[position].id,
                title = list[position].title,
                content = list[position].content,
                status = false
            )
            todoViewModel.deleteTodo(todo)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}