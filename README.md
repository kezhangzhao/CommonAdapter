# CommonAdapter
ListView和RecyclerView的封装adapter。RecyclerView的分割线
# 依赖方式
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  	dependencies {
	        implementation 'com.github.kezhangzhao:CommonAdapter:1.0.0'
	}
# 使用方法 
    private void setAdapter() {
        listView.setAdapter(new CommonLvAdapter<String>(this, R.layout.item_acitivity_main, data) {
            @Override
            protected void convert(ViewHolderLv viewHolder, String item, int position) {
                //item：数据datas列表中的bean类
                viewHolder.setText(R.id.tv_item, item);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加分割线
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this, 0.5f));
        recyclerView.setAdapter(new CommonRvAdapter<String>(this, R.layout.item_acitivity_main, data) {

            @Override
            public void convert(ViewHolderRv holder, String item, int position) {
                //item：数据datas列表中的bean类
                holder.setText(R.id.tv_item, item);
            }
        });
    }
 
