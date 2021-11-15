package com.tingli.autosizedemo

import android.app.Activity
import android.os.Bundle

class AAA : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_dp)
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var resultLength = s.length
        var curLength = 0
        if (resultLength >= 2) {
            resultLength = 0
            var startIndex = 0
            for (i in 0 until s.length) {
                val index: Int = s.indexOf(s[i], startIndex)
                if (index < i) {
                    resultLength = Math.max(resultLength, curLength)
                    startIndex = index + 1
                    curLength = i - startIndex + 1
                } else {
                    curLength++
                }
            }
        }
        return Math.max(curLength, resultLength)
    }


}