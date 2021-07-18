package co.anilplantix.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.anilplantix.Model.MovieModel
import co.anilplantix.R

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.singlerow_layout_movie_details.view.*

class MovieAdapter(private val rows: Array<MovieModel>) : RecyclerView.Adapter<CustomViewHolder>()
{

    override fun getItemCount()=rows.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val cellRow=layoutInflater.inflate(R.layout.singlerow_layout_movie_details,parent,false)
        return CustomViewHolder(cellRow)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int)
    {
            holder.bindItems(rows[position])
    }
}
class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)
{
    fun bindItems(movieModel: MovieModel)
    {
        try {

            itemView.textView_title.text = "Title: "+movieModel.title
            Picasso.get().load(movieModel.imageHref).into(itemView.imageView_movie)


            itemView.setOnClickListener({
                Toast.makeText(itemView.context, "Clicked Position $position", Toast.LENGTH_SHORT).show()
            })


        }catch (e:Exception){
            println(e.message)
        }
    }

}