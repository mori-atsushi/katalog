package jp.co.cyberagent.katalog.dsl

import android.app.Activity
import android.content.Context
import androidx.lifecycle.LifecycleOwner

public interface ViewDefinitionScope {
    public val context: Context
    public val activity: Activity
    public val lifecycleOwner: LifecycleOwner
}
