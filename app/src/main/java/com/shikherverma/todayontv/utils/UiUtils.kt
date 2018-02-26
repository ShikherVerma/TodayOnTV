package com.shikherverma.todayontv.utils

import android.content.Context
import android.text.Html
import android.util.Log
import android.view.View
import java.util.*

/** A singleton class containing function for UI and Animations */
object UiUtils {

    /**
     * Show Html in TextView
     */
    @JvmStatic
    fun setHtmlToTextView(html: String?): CharSequence {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            removeHtmlBottomPadding(Html.fromHtml(html ?: "Summary not available!", Html.FROM_HTML_MODE_LEGACY))
        } else {
            removeHtmlBottomPadding(Html.fromHtml(html ?: "Summary not available!"))
        }
    }

    /**
     * Html.fromHtml sometimes adds extra space at the bottom.
     * This methods removes this space again.
     * See https://github.com/SufficientlySecure/html-textview/issues/19
     */
    @JvmStatic
    private fun removeHtmlBottomPadding(text: CharSequence?): CharSequence {
        var charSequence: CharSequence = text ?: return ""
        while (charSequence.isNotEmpty() && charSequence[charSequence.length - 1] == '\n') {
            charSequence = charSequence.subSequence(0, charSequence.length - 1)
        }
        return charSequence
    }

    /**
     * Calculate time difference from current time.
     *
     * @param airstamp timestamp for which relative time has to be calculated
     */
    @JvmStatic
    fun timeDiff(airstamp: Date): String {
        val current: Date = Date()
        Log.wtf("tag", current.toString())
        return if ( current >= airstamp) {
            "Aired already :("
        } else {
            var hrs: Int = airstamp.hours - current.hours
            if (hrs < 0) hrs += 24
            var min: Int = airstamp.minutes - current.minutes
            if (min < 0) {
                min += 60
                hrs -= 1
            }
            "Starts in $hrs hr $min min"
        }
    }

    /**
     * Animate switching visibility of views.
     *
     * @param context Activity context
     * @param fadeIn View to be shown
     * @param fadeOut1 View to be hidden
     * @param fadeOut2 View to be hidden
     */
    fun fadeSwitch(context: Context, fadeIn: View, fadeOut1: View, fadeOut2: View) {
        fadeOut1.startAnimation(
                android.view.animation.AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
        fadeOut2.startAnimation(
                android.view.animation.AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
        fadeIn.startAnimation(
                android.view.animation.AnimationUtils.loadAnimation(context, android.R.anim.fade_in))
        fadeOut1.visibility = View.GONE
        fadeOut2.visibility = View.GONE
        fadeIn.visibility = View.VISIBLE
    }

}
