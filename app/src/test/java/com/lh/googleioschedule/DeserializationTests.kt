package com.lh.googleioschedule

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.test.platform.app.InstrumentationRegistry
import com.lh.googleioschedule.data.Codelab
import com.lh.googleioschedule.data.ConferencePayload
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.Test

class DeserializationTests {

    @Test
    fun CodelabDeserializationTest() {
        val text = "{\"id\": \"0c9e7540-0276-4165-8c57-6067584e71f8\",\"priority\": 0,\"title\": \"Recognize text, facial features, and objects in images with ML Kit for Firebase\",\"description\": \"In this codelab, you’ll build an Android app with ML Kit for Firebase that uses on-device and cloud Machine Learning to recognize text, facial features, and objects in images.\",\"duration\": \"40\",\"icon\": \"https://firebasestorage.googleapis.com/v0/b/io2019-festivus/o/images%2Fcodelabs%2Ffirebase.png?alt=media&token=bf4bb3a1-630d-45e3-857b-de0554b1ade7\",\"link\": \"https://codelabs.developers.google.com/codelabs/mlkit-android/\",\"tagNames\": [\"topic_firebase\",\"type_codelabs\"]}"
        val obj = Json.decodeFromString<Codelab>(text)
        assert(obj != null)
    }
}