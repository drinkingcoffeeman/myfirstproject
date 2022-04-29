package com.hwkim.becarefulbang.utils

import com.google.firebase.auth.FirebaseAuth
import java.text.SimpleDateFormat
import java.util.*

class FBAuth {

    /*
    companion object {

        private lateinit var auth: FirebaseAuth

        fun getUid() : String { //uid 리턴하는거

            auth = FirebaseAuth.getInstance()

            return auth.currentUser?.uid.toString() //현재유저 uid를 리턴해줌

        }

    }

     */

    companion object {

        private lateinit var auth: FirebaseAuth

        fun getUid() : String {

            auth = FirebaseAuth.getInstance()

            return auth.currentUser?.uid.toString()

        }

        fun getTime() : String {

            val currentDateTime = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime)

            return dateFormat

        }

    }


}