package com.example.ignetilabtest.utils

import android.content.Context
import android.content.SharedPreferences


class AppSettings(mcontext: Context?) {
    private var context: Context? = null
    var pref: SharedPreferences? = null

    fun getString(key: String?): String? {
        return if (pref == null) "" else pref!!.getString(key, "")
    }

    fun saveString(key: String?, `val`: String?) {
        if (pref == null) return
        val editor = pref!!.edit()
        editor.putString(key, `val`)
        editor.commit()
    }

    fun saveInt(key: String?, `val`: Int) {
        if (pref == null) return
        val editor = pref!!.edit()
        editor.putInt(key, `val`)
        editor.commit()
    }

    fun getInt(key: String?): Int {
        return if (pref == null) 0 else pref!!.getInt(key, 0)
    }

    fun getDate(key: String?): String? {
        return if (pref == null) "" else pref!!.getString(key, "")
    }

    fun getBoolean(key: String?): Boolean {
        return if (pref == null) false else pref!!.getBoolean(key, false)
    }

    fun saveBoolean(key: String?, `val`: Boolean) {
        if (pref == null) return
        val editor = pref!!.edit()
        editor.putBoolean(key, `val`)
        editor.commit()
    }

    fun removeString(key: String?) {
        if (pref == null) return
        val editor = pref!!.edit()
        editor.remove(key)
        editor.apply()
    }

    fun removeAllData() {
        if (pref == null) return
        val editor = pref!!.edit()
        editor.clear().commit()
    }

    companion object {
        private var sharedSettings: AppSettings? = null
        private val mutex = Any()

        const val IS_LOGIIN = "IS_LOGIN"
        const val PHONE_NUMBER = "PHONE_NUMBER"
        const val PASSWORD = "PHONE_NUMBER"
        const val USERNAME = "USERNAME"
        const val USEREMAIL = "USEREMAIL"

        fun sharedInstance(context: Context?): AppSettings? {
            if (sharedSettings == null) synchronized(mutex) {
                if (sharedSettings == null) {
                    sharedSettings = AppSettings(context)
                }
            }
            return sharedSettings
        }
    }

    init {
        try {
            context = mcontext
            pref = context!!.getSharedPreferences("IgniteLab", Context.MODE_PRIVATE)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}