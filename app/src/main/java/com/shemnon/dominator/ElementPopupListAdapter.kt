/**
 * Copyright 2010 Daniel Ferrin

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.shemnon.dominator

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

internal class ElementPopupListAdapter
internal constructor(activity: Activity, elements: Array<Elements?>) : ArrayAdapter<Elements>(activity, 0, elements) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = (context as Activity).layoutInflater.inflate(R.layout.element_popup, null)
        }

        val imageView = view!!.findViewById(R.id.element_image) as ImageView
        imageView.setImageResource(AnimalElements.imageForElement(getItem(position)))

        val textView = view.findViewById(R.id.element_text) as TextView
        val name: String
        val item = getItem(position)
        if (item == null) {
            name = "Empty"
        } else {
            name = item.name
        }
        textView.text = name
        return view
    }
}