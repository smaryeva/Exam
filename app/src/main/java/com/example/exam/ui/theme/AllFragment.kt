package com.example.exam.ui.theme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.R


class AllFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ClientAdapter
    private lateinit var allButton: Button
    private lateinit var activeButton: Button
    private lateinit var deactiveButton: Button




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_all, container, false)


        recyclerView = view.findViewById(R.id.customerRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ClientAdapter()
        recyclerView.adapter = adapter
         allButton = view.findViewById(R.id.allButton)
         activeButton = view.findViewById(R.id.activeButton)
         deactiveButton = view.findViewById(R.id.deactiveButton)

        val customerList = getProductsData()
        adapter.submitList(customerList)
        allButton.setOnClickListener { filterListByIsActive(null) }
        activeButton.setOnClickListener { filterListByIsActive(true) }
        deactiveButton.setOnClickListener { filterListByIsActive(false) }








        return view
    }



    fun getProductsData(): List<Client> {

        val customerList = arrayListOf(

            Client(

                id = 1,

                name = "Orkhan",

                address = "Azerbaijan/Baku/Yasamal",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = true

            ),

            Client(

                id = 2,

                name = "Lisa",

                address = "Poland/Warsaw",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = true

            ),

            Client(

                id = 3,

                name = "Alex",

                address = "England/London",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = false

            ),

            Client(

                id = 4,

                name = "Ahmad",

                address = "Azerbaijan/Guba",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = true

            ),

            Client(

                id = 5,

                name = "Mariana",

                address = "Ukraine/Kiev",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = false

            ),

            Client(

                id = 6,

                name = "Alex",

                address = "England/London",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = true

            ),

            Client(

                id = 7,

                name = "Ahmad",

                address = "Azerbaijan/Guba",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = false

            ),

            Client(

                id = 8,

                name = "Susan",

                address = "USA/New York",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = true

            ),

            Client(

                id = 9,

                name = "Mustafa",

                address = "Turkey/Ankara",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = false

            ),

            )
        return customerList
    }
    private fun filterListByIsActive(isActive: Boolean?) {
        val filteredList = when (isActive) {
            true -> {
                // isActive true olan müştərilər
                getProductsData().filter { it.isActive }
            }
            false -> {
                // isActive false olan müştərilər
                getProductsData().filter { !it.isActive }
            }
            else -> {
                // Bütün müştərilər
                getProductsData()
            }
        }
        adapter.submitList(filteredList)
    }



}