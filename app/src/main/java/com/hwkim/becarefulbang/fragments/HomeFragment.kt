package com.hwkim.becarefulbang.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.hwkim.becarefulbang.R
import com.hwkim.becarefulbang.contentsList.BookmarkRVAdapter
import com.hwkim.becarefulbang.contentsList.ContentModel
import com.hwkim.becarefulbang.databinding.FragmentHomeBinding
import com.hwkim.becarefulbang.utils.FBRef


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val TAG = HomeFragment::class.java.simpleName //태그 생성

    //북마크꺼 가져옴
    val bookmarkIdList = mutableListOf<String>()
    val items = ArrayList<ContentModel>()
    val itemKeyList = ArrayList<String>()

    lateinit var rvAdapter : BookmarkRVAdapter //어댑터 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("HomeFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.tipTap.setOnClickListener {
            Log.d("HomeFragment", "tipTap")
            //it.findNavController().navigate(R.id.action_homeFragment_to_tipFragment)
            it.findNavController().navigate(R.id.action_homeFragment3_to_tipFragment2)
        }

        binding.talkTap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment3_to_talkFragment2)

        }

        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment3_to_bookmarkFragment2)
        }



        rvAdapter = BookmarkRVAdapter(requireContext(), items, itemKeyList, bookmarkIdList)

        val rv : RecyclerView = binding.mainRV
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        getCategoryData()

        return binding.root
    }



    private fun getCategoryData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {

                    val item = dataModel.getValue(ContentModel::class.java)

                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())


                }
                rvAdapter.notifyDataSetChanged()

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)

    }


}