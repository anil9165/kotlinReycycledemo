package co.anilplantix


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import co.anilplantix.Adapter.MovieAdapter
import co.anilplantix.Interface.CommonResponseListener
import co.anilplantix.Model.MovieModel
import co.anilplantix.Network.NetworkAccessor
import co.anilplantix.Network.WebUrls
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(),CommonResponseListener
{
    private lateinit var rows:Array<MovieModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMoviesData()
    }
    private fun getMoviesData() {
        var networkAccessor= NetworkAccessor()
         var jsoPayload = JSONObject()
         networkAccessor.commonNetworkCall(this@MainActivity,jsoPayload,this@MainActivity,WebUrls.BASE_URL,WebUrls.GET_MOVIES)
    }

    override fun onSuccessResponse(result: String, from: String, code: Int)
    {

            var gson = Gson()
            val movieModel = gson.fromJson(result, Array<MovieModel>::class.java)
             rows = movieModel
            if (rows.isNotEmpty()) {
                setDataToAdapter()
            }

    }
    override fun onError(msg: String, fromUrl: String) {
        println("Error Message:-$msg")
    }
    private fun setDataToAdapter()
    {
        var linearLayoutManager = LinearLayoutManager(this)
        var adapter = MovieAdapter(rows)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }
}
