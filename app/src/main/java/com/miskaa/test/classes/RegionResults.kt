package com.miskaa.test.classes

import Translations

data class
RegionResults (

        val name : String,
        val topLevelDomain : List<String>,
        val alpha2Code : String,
        val callingCodes : List<Int>,
        val capital : String,
        val altSpellings : List<String>,
        val region : String,
        val subregion : String,
        val population : Int,
        val latlng : List<Double>,
        val demonym : String,
        val area : Int,
        val gini : Double,
        val timezones : List<String>,
        val borders : List<String>,
        val nativeName : String,
        val numericCode : Int,
        val currencies : List<Currencies>,
        val languages : List<Languages>,
        val translations : Translations,
        val flag : String,
        val regionalBlocs : List<RegionalBlocs>,
        val cioc : String
)