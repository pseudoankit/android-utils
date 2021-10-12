package com.android.lostankit7.util

/*
class RvTaskEntriesAdapter(private val mList : ArrayList<TaskEntryModel>) : RecyclerView.Adapter<RvTaskEntriesAdapter.ViewHolder>() {

    private lateinit var headerBinding : ItemRvHeaderBinding
    private lateinit var taskBinding: ItemRvEntryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if(viewType == R.layout.item_rv_header){
            headerBinding = ItemRvHeaderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ViewHolder(headerBinding.root)
        } else {
            taskBinding = ItemRvEntryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return  ViewHolder(taskBinding.root)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        when(item) {
            is TaskEntryModel.Header -> {

            }
            is TaskEntryModel.Task -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(mList[position]){
            is TaskEntryModel.Task -> R.layout.item_rv_entry
            is TaskEntryModel.Header -> R.layout.item_rv_header
        }
    }

    override fun getItemCount()= mList.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}

*Model class
sealed class TaskEntryModel(){
    class Header(val category: String) : TaskEntryModel()
    class Task(val icon: String, val iconName: String) : TaskEntryModel()
}

*setting adapter to recycler view
private fun setUpRecyclerView(){
        val list = ArrayList<TaskEntryModel>()
        list.add(TaskEntryModel.Header("Ankit"))
        list.add(TaskEntryModel.Task("ok","test"))
        list.add(TaskEntryModel.Task("ok","test"))
        list.add(TaskEntryModel.Header("Ankit"))

        val mAdapter = RvTaskEntriesAdapter(list)
        val mLayoutManager = GridLayoutManager(requireContext(), gridCount)
        binding.rvMoodDetail.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
        }

        *overriding spansizelookup so that if header comes then it will be counted as grid count(curr - 5) else 1
        mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when(mAdapter.getItemViewType(position)){
                    R.layout.item_rv_header -> gridCount
                    else -> 1
                }
            }
        }
    }

 */