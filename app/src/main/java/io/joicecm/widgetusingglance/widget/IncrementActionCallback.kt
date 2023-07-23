package io.joicecm.widgetusingglance.widget

import android.content.Context
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState

class IncrementActionCallback: ActionCallback {

    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(
            context = context,
            glanceId = glanceId,
            updateState = { prefs ->
                val currentCount = prefs[CounterWidget.countKey]
                if(currentCount != null) {
                    prefs[CounterWidget.countKey] = currentCount + 1
                } else {
                    prefs[CounterWidget.countKey] = 1
                }
            }
        )
        //Tell the widget to be updated
        CounterWidget.update(
            context = context,
            id = glanceId,
        )
    }
}