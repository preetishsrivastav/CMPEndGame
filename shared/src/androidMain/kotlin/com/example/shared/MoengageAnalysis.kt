package com.example.shared

import android.content.Context
import com.moengage.core.MoEngage
import com.moengage.core.Properties
import com.moengage.core.analytics.MoEAnalyticsHelper
import java.util.Date

class MoengageAnalysis(
    private val context: Context
): MoenegageService {
    override fun trackEvent(
        eventName: String,
        attributes: Map<String, Any>?
    ) {
        MoEAnalyticsHelper.setUniqueId(context, "user_unique_id_12345")

// Standard attributes
        MoEAnalyticsHelper.setUserName(context, "Emilys")
        MoEAnalyticsHelper.setEmailId(context, "saanvi.roy@example.com")
        MoEAnalyticsHelper.setMobileNumber(context, "7302598247")

// Custom attributes for segmentation
        MoEAnalyticsHelper.setUserAttribute(context, "subscription_plan", "premium")
        MoEAnalyticsHelper.setUserAttribute(context, "last_seen", Date())

        val eventProperties = Properties()

        // 2. Loop through the input map (if it's not null) and add each item
        attributes?.forEach { (key, value) ->
            eventProperties.addAttribute(key, value)
        }


        MoEAnalyticsHelper.trackEvent(context, eventName, eventProperties)
    }
}