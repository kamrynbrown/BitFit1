package com.example.bitfit2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit2.Data.FoodDAO
import com.example.bitfit2.Data.FoodDatabase


class DashboardFragment : Fragment() {
    lateinit var r: RecyclerView
    private lateinit var dao: FoodDAO;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.dashboard_fragment, container, false)
        r = view.findViewById(R.id.NutritionTracker)
        dao = FoodDatabase.getDatabase(requireContext()).foodDAO();
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        r.layoutManager = LinearLayoutManager(requireActivity())
        dao.getAll().asLiveData().observe(requireActivity(), Observer { food ->
            r.adapter = FoodAdapter(food)
        })
    }
}