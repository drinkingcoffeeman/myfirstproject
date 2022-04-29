package com.hwkim.becarefulbang.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.hwkim.becarefulbang.R
import com.hwkim.becarefulbang.contentsList.ContentListActivity
import com.hwkim.becarefulbang.databinding.FragmentTipBinding

class TipFragment : Fragment() {

    private lateinit var binding : FragmentTipBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tip, container, false)


        binding.category2.setOnClickListener {
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category2")
            startActivity(intent)
        }

        binding.category3.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category3") //카테고리 정보도 같이 넘겨준다
            startActivity(intent)

        }

        binding.category4.setOnClickListener {
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category4")
            startActivity(intent)
        }

        binding.category5.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category5") //카테고리 정보도 같이 넘겨준다
            startActivity(intent)

        }

        binding.category6.setOnClickListener {
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category6")
            startActivity(intent)
        }

        binding.category7.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category7") //카테고리 정보도 같이 넘겨준다
            startActivity(intent)

        }
        binding.category8.setOnClickListener{
            val intent = Intent(context, ContentListActivity::class.java)
            intent.putExtra("category", "category8") //카테고리 정보도 같이 넘겨준다
            startActivity(intent)

        }



        return binding.root
    }


}