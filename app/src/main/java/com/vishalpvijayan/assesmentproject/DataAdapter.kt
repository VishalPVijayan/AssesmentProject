package com.vishalpvijayan.assesmentproject

import android.app.AlertDialog
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
        holder.itemView.txtTitle.text =itemHolder.id.toString()

        holder.recyclerviewDataBinding.root.setOnClickListener {
            holder.recyclerviewDataBinding.root.setOnClickListener {


                AlertDialog.Builder(it.context)
                    .setTitle("You Selected ")
                    .setMessage("\n Id : "+itemHolder.id +" \n Author Name : "+itemHolder.author+ "\n " +
                            "Height : "+itemHolder.height+ "\n Width : "+itemHolder.width +"\n Url : "+itemHolder.url)
                    .setCancelable(false)
                    .setPositiveButton("Okay"){ dialog, which -> dialog.dismiss() }
                    .create()
                    .show()
            }

        }


    }


    inner class DataViewHolder(
        val recyclerviewDataBinding:  RecyclerviewRowBinding
    ) : RecyclerView.ViewHolder(recyclerviewDataBinding.root)

}