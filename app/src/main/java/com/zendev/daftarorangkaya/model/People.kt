package com.zendev.daftarorangkaya.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class People(
    var name: String? = null,
    var founder: String? = null,
    var description: String? = null,
    var photo: String? = null
) : Parcelable