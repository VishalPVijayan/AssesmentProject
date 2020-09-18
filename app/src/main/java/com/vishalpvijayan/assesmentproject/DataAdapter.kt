package com.vishalpvijayan.assesmentproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vishalpvijayan.assesmentproject.databinding.RecyclerviewRowBinding
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class DataAdapter (
    private val data_: List<DataResponse>
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>(){

    override fun getItemCount() = data_.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_row,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.recyclerviewDataBinding.dataApi = data_[position]

        val itemHolder = data_[position]

        holder.itemView.txtHeight.text =itemHolder.height.toString()
        holder.itemView.txtWidth.text =itemHolder.width.toString()
        holder.itemView.txtDescription.text =itemHolder.id.toString()


    }


    inner class DataViewHolder(
        val recyclerviewDataBinding:  RecyclerviewRowBinding
    ) : RecyclerView.ViewHolder(recyclerviewDataBinding.root)

}