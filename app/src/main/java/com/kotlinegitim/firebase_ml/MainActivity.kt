package com.kotlinegitim.firebase_ml

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.kotlinegitim.firebase_ml.service.TranslatorService


class MainActivity : AppCompatActivity(){

    val myArrayList = arrayListOf<String>()

    var from = ""
    var to = ""

    var progressBar: ProgressBar? = null

    lateinit var editText: EditText
    lateinit var trans: Button
    lateinit var translatedText : TextView
    lateinit var clip : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        translatedText = findViewById(R.id.translated)

        progressBar = findViewById(R.id.progressBar)

        clip = findViewById(R.id.copy)
        //indirilen diller türkçe, ingilizce, almanca


        val languages = resources.getStringArray(R.array.Languages)

        trans = findViewById(R.id.translate)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        editText = findViewById(R.id.inputText)



        spinnerLoader(spinner, languages)
        spinnerLoader(spinner2, languages)


        clip.setOnClickListener{

           copyClipboard()
        }

    }

    fun copyClipboard(){

        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", translatedText.text)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this, "TRANSLATION IS COPIED !",Toast.LENGTH_LONG).show()
    }

    fun spinnerLoader(spinner: Spinner, languages: Array<String>) {


        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, languages
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {


                    println(spinner.tag)
                    if (spinner.tag == "from"){

                        from = languages[position]
                    }
                    else{

                        to = languages[position]
                    }


                    println(from)
                    println(to)
                    trans.setOnClickListener {

                        //burada üyeyi al

                        var fromMember = enumValueOf<Languanges>(from)
                        var toMember = enumValueOf<Languanges>(to)


                        //enumMember.languange ile kodu al
                        TranslatorService().Translator(
                            fromMember.languange,
                            toMember.languange,
                            editText.text.toString(),
                            translatedText,
                            progressBar

                        )



                    }




                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        }




    }




}


