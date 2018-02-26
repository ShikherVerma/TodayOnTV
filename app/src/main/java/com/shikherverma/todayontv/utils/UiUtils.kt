package com.shikherverma.todayontv.utils

import android.text.Html
import android.widget.TextView

/** A singleton class containing function for UI and Animations */
object UiUtils {

    /**
     * Show Html in TextView
     */
    fun setHtmlToTextView(textView: TextView, html: String?) {
        textView.text = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
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
    private fun removeHtmlBottomPadding(text: CharSequence?): CharSequence? {
        var charSequence: CharSequence? = text ?: return null

        while (charSequence!!.isNotEmpty() && charSequence[charSequence.length - 1] == '\n') {
            charSequence = charSequence.subSequence(0, charSequence.length - 1)
        }
        return charSequence
    }
}
