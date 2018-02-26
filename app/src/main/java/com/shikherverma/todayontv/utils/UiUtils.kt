package com.shikherverma.todayontv.utils

import android.content.Context
import android.text.Html
import android.view.View

/** A singleton class containing function for UI and Animations */
object UiUtils {

    /**
     * Show Html in TextView
     */
    @JvmStatic
    fun setHtmlToTextView(html: String?): CharSequence {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            removeHtmlBottomPadding(Html.fromHtml(html ?: "", Html.FROM_HTML_MODE_LEGACY))
        } else {
            removeHtmlBottomPadding(Html.fromHtml(html ?: ""))
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
