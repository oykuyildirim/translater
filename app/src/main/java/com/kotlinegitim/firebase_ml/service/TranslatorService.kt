package com.kotlinegitim.firebase_ml.service

import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.google.mlkit.common.model.RemoteModelManager
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.TranslateRemoteModel
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class TranslatorService {


    var value = 0
    fun Translator(wroten:String, translated:String, translatingText : String, result:TextView, progressBar:ProgressBar?){


        val options = TranslatorOptions.Builder()
            .setSourceLanguage(wroten)
            .setTargetLanguage(translated)
            .build()

        val englishGermanTranslator = Translation.getClient(options)
        englishGermanTranslator.downloadModelIfNeeded()
            .addOnSuccessListener {

                progressBar!!.setVisibility(View.VISIBLE)

                println("Success")
            }
            .addOnFailureListener { exception ->

                println("Failed")
            }



        englishGermanTranslator.translate(translatingText)
            .addOnSuccessListener { translatedText ->

                value =100
                result.text =translatedText.toString()
                progressBar!!.progress = 100
                progressBar!!.setVisibility(View.INVISIBLE)



            }
            .addOnFailureListener { exception ->
                // Error.
                // ...
            }



    }
}