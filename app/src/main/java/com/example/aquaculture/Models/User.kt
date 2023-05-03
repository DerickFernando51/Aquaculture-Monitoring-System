package com.example.aquaculture.Models

data class User(var Temperature: String ?= null,var TDS: String ?= null,var pH: String ?= null) //@get:Exclude var isDeleted: Boolean = false )
//
//    override fun equals(other: Any?): Boolean{
//        return if(other is User){
//            other.ItemDesc == ItemDesc
//        }else false
//    }
//
//    override fun hashCode(): Int {
//        var result = ItemDesc?.hashCode() ?: 0
//        result = 31 * result + (Price?.hashCode() ?: 0)
//        result = 31 * result + (Weight?.hashCode() ?: 0)
//        result = 31 * result + (timestamp?.hashCode() ?: 0)
//        result = 31 * result + isDeleted.hashCode()
//        return result
//    }
//
//}

