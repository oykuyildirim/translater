package com.kotlinegitim.firebase_ml

import com.google.mlkit.nl.translate.TranslateLanguage


enum class Languanges(val languange: String) {

    ENGLISH(TranslateLanguage.ENGLISH),
    TURKISH(TranslateLanguage.TURKISH),
    GERMAN(TranslateLanguage.GERMAN),
    FRENCH(TranslateLanguage.FRENCH),
    ARABIC(TranslateLanguage.ARABIC),
    AFRIKAANS(TranslateLanguage.AFRIKAANS),
    ALBANIAN(TranslateLanguage.ALBANIAN),
    BELARUSIAN(TranslateLanguage.BELARUSIAN),
    BULGARIAN(TranslateLanguage.BULGARIAN),
    CHINESE(TranslateLanguage.CHINESE),
    DANISH(TranslateLanguage.DANISH),
    DUTCH(TranslateLanguage.DUTCH),
    ITALIAN(TranslateLanguage.ITALIAN),
    GREEK(TranslateLanguage.GREEK)

}