package com.example.jerusalemiugtwo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jerusalemiugtwo.Adapters.homeAdapter
import com.example.jerusalemiugtwo.MainActivity
import com.example.jerusalemiugtwo.R
import com.example.jerusalemiugtwo.model.NewsItem
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.StringReader


class HomeFragment : Fragment() {

    lateinit var root : View
    var URL : String = "https://www.alhayatp.net/?app=article.rss"
    var queue: RequestQueue? = null
    lateinit var news :ArrayList<NewsItem>
    lateinit var adapter : homeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_home, container, false)

        init()

        return root
    }

    fun  init(){
        queue = Volley.newRequestQueue(activity!!)
        news = ArrayList()
        adapter = homeAdapter(activity!!,news)
        root.fr_home_recycler.layoutManager = LinearLayoutManager(activity!!)
        root.fr_home_recycler.adapter = adapter
        getdata()
    }

    fun getdata(){
        val request = StringRequest(
            Request.Method.GET, URL,
            Response.Listener { response ->
                try {
                    val factory = XmlPullParserFactory.newInstance()
                    factory.isNamespaceAware = true
                    val parser = factory.newPullParser()
                    parser.setInput(StringReader(response))
                    var eventType = parser.eventType
                    var item: NewsItem? = null
                    var text: String? = null
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        if (eventType == XmlPullParser.START_TAG) {
                            val tagName = parser.name
                            if (tagName.equals("item", ignoreCase = true)) {
                                item = NewsItem()
                            } else if (tagName.equals("enclosure", ignoreCase = true) && item != null) {
                                val url = parser.getAttributeValue(null, "url")
                                item.img = url
                            }
                        } else if (eventType == XmlPullParser.TEXT) {
                            text = parser.text
                        } else if (eventType == XmlPullParser.END_TAG) {
                            if (item != null) {
                                val tagName = parser.name
                                if (tagName.equals("title", ignoreCase = true)) {
                                    item.title = text!!
                                } else if (tagName.equals("link", ignoreCase = true)) {
                                    item.link = text!!
                                } else if (tagName.equals("description", ignoreCase = true)) {
                                    item.desc = text!!
                                }else if (tagName.equals("content", ignoreCase = true)) {
                                    item.details = text!!
                                }else if (tagName.equals("pubDate", ignoreCase = true)) {
                                    item.date = text!!
                                } else if (tagName.equals("item", ignoreCase = true)) {
                                    news.add(item)
                                    item = null
                                }
                            }
                        }
                        eventType = parser.next()
                    }
                  adapter.notifyDataSetChanged()
                } catch (e: XmlPullParserException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { e->
                Toast.makeText(activity!!.baseContext, "Unable to handle request", Toast.LENGTH_LONG).show()
                Log.e("osm",e.toString())
            })

        queue!!.add(request)

    }

}