package com.mindorks.framework.mvp.util


/**
 * Created by jyotidubey on 05/01/18.
 */
object AppConstants {

    internal val PREF_NAME = "mindorks_pref"
    internal val SEED_DATABASE_QUESTIONS = "seed/questions.json"
    internal val SEED_DATABASE_OPTIONS = "seed/options.json"
    internal val EMPTY_EMAIL_ERROR = 1001
    internal val INVALID_EMAIL_ERROR = 1002
    internal val EMPTY_PASSWORD_ERROR = 1003
    internal val LOGIN_FAILURE = 1004
    internal val NULL_INDEX = -1L
    internal val API_KEY = "6cfabd0caf0d7b1a05360cc41a7b4c3b"
    internal val BASE_URL = "https://api.themoviedb.org/3/"
    internal val LANGUAGE = "en-US"
    internal val IMAGE = "https://image.tmdb.org/t/p/original"

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}