package abika.sinau.mygofoodclone.shared

import android.content.Context
import android.content.SharedPreferences

class PrefSession(val context: Context) {
    companion object {
        private const val PREF_NAME_SESSION = "PREF_NAME_SESSION"
        const val PREF_FLAG_LOGIN = "PREF_FLAG_LOGIN"
    }

    private var prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME_SESSION, Context.MODE_PRIVATE)

    var hasLogin: Boolean
        get() = prefs.getBoolean(PREF_FLAG_LOGIN, false)
        set(value) {
            prefs.edit().putBoolean(PREF_FLAG_LOGIN, value).apply()
        }
}