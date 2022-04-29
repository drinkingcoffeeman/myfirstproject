package com.hwkim.becarefulbang.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {

    companion object {

        private val database = Firebase.database

        val category1 = database.getReference("contents")
        val category2 = database.getReference("contents2")

        val bookmarkRef = database.getReference("bookmark_list")

////////////게시판 관련 추가됨
        val boardRef = database.getReference("board")
////////////추가됨


        //////코맨트 관련 추가됨//////////
        val commentRef = database.getReference("comment")
/////////////////////


    }

}