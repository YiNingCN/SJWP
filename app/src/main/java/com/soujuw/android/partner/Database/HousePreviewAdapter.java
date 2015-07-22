/*
 *    Copyright (C) 2015 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.soujuw.android.partner.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.soujuw.android.partner.Dao.DaoMaster;
import com.soujuw.android.partner.Dao.DaoSession;
import com.soujuw.android.partner.Dao.UsedHouse;
import com.soujuw.android.partner.Dao.UsedHouseDao;
import com.soujuw.android.partner.R;

import java.util.Calendar;
import java.util.Random;

public class HousePreviewAdapter extends AbstractExpandableItemAdapter<HousePreviewGVH, HousePreviewCVH> {
    private static final String TAG = "HousePreviewAdapter";
    DisplayImageOptions options;
    String[] columns;
    ImageViewAware imageAware = null; //UIL使用的显示参数。比如图片的宽、高等信息。一次创建避免重复开销
    DisplayImageOptions imageDispOptions;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private UsedHouseDao dao;
    private Cursor cursor;
    public HousePreviewAdapter(Context context) {
        setHasStableIds(true);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "sjw_used_house", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        dao = daoSession.getUsedHouseDao();
        columns = dao.getAllColumns();


        //模拟数据库
//        cursor = db.query(dao.getTablename(), columns, null, null, null, null, null);
//        for(int i = 0; i < 300; i++) {
//            cursor = db.query(dao.getTablename(), columns, null, null, null, null, null);
//            simulateRefresh();
//        }
        cursor = db.query(dao.getTablename(), columns, null, null, null, null, null);
        cursor.moveToFirst();

        //清理缓存测试效果
        ImageLoader.getInstance().clearDiskCache();
        ImageLoader.getInstance().clearMemoryCache();

        //from[]指定字段列表 to[] 指定控件id列表。直接生成对应的LIST ADAPTER。。这太方便了！
//        String[] from = { textColumn, NoteDao.Properties.Comment.columnName };
//        int[] to = { android.R.id.text1, android.R.id.text2 };
//
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
//                to);
//        setListAdapter(adapter);

        //----------------------
        //添加一个记录
//        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
//        String comment = "Added on " + df.format(new Date());
//        Note note = new Note(null, noteText, comment, new Date());
//        noteDao.insert(note);
//        Log.d("DaoExample", "Inserted new note, ID: " + note.getId());
//        cursor.requery();
    }

    void simulateRefresh() {
        Random random = new Random();
        String url = new String();
        switch (cursor.getCount() % 5) {
            case 0:
                url = "http://b.pic1.ajkimg.com/display/anjuke/d734a6-%E6%88%91%E7%88%B1%E6%88%91%E5%AE%B6/99289703b5ab6f7c0e5f2b08f5010e63-600x450.jpg";
                break;
            case 1:
                url = "http://c.pic1.ajkimg.com/display/anjuke/9faf6a-%E6%88%91%E7%88%B1%E6%88%91%E5%AE%B6/b0c6eacebfccdbe5600eabc64499f6bd-600x450.jpg";
                break;
            case 2:
                url = "http://b.pic1.ajkimg.com/display/anjuke/b0ef98-%E6%88%91%E7%88%B1%E6%88%91%E5%AE%B6/1b2db3adc914e5331697f87e8bf22c41-600x450.jpg";
                break;
            case 3:
                url = "http://b.pic1.ajkimg.com/display/anjuke/998582-%E6%88%91%E7%88%B1%E6%88%91%E5%AE%B6/e62345b6e8427c5e860fe8b5bef1a2d3-600x450.jpg";
                break;
            case 4:
                url = "http://d.pic1.ajkimg.com/display/anjuke/77999c-%E6%88%91%E7%88%B1%E6%88%91%E5%AE%B6/30dad58ad3aedb6bdec8e95471be552b-600x450.jpg";
                break;
        }
        Integer bedrooms = random.nextInt(5) + 1;
        Integer nmaxfloor = random.nextInt(35) + 1;
        UsedHouse house = new UsedHouse(
                random.nextLong(),
                (Integer) random.nextInt(),
                url,
                String.format("测试标题%d", random.nextInt(1000)),
                (Integer) bedrooms,
                (Integer) random.nextInt(2) + 1,
                "精装",
                (Integer) (random.nextInt(1970000) + 30000),
                random.nextInt(2) == 1 ? "立山区" : "高新区",
                (Integer) random.nextInt(2) == 1 ? "明达新世纪花园" : "千龙户",
                (float) (random.nextInt(20000) + 5000) / 10,
                (Integer) random.nextInt(20),
                (Integer) random.nextInt(nmaxfloor) + 1,
                (Integer) nmaxfloor,
                random.nextInt(8),
                random.nextInt(35) + 1980, Calendar.getInstance().getTime(), 1, Calendar.getInstance().getTime(),
                "标签1", "标签2", "标签3", "标签4"
        );
        dao.insert(house);
    }

    //TODO
    public void syncDataWithServer() {

    }


    /**
     * Gets the number of groups.
     *
     * @return the number of groups
     */
    @Override
    public int getGroupCount() {
        return cursor.getCount();
    }

    /**
     * Gets the number of children in a specified group.
     *
     * @param groupPosition the position of the group for which the children count should be returned
     * @return the number of children
     */
    @Override
    public int getChildCount(int groupPosition) {
        return 1;
    }

    /**
     * Gets the ID for the group at the given position. This group ID must be unique across groups.
     * <p/>
     * The combined ID (see {@link RecyclerViewExpandableItemManager#getCombinedGroupId(long)})
     * must be unique across ALL items (groups and all children).
     *
     * @param groupPosition the position of the group for which the ID is wanted
     * @return the ID associated with the group
     */
    @Override
    public long getGroupId(int groupPosition) {
        cursor.moveToPosition(groupPosition);
        UsedHouse house = dao.readEntity(cursor, 0);
        return house.getId();
        //return dao.readKey(cursor, groupPosition);
    }

    /**
     * Gets the ID for the given child within the given group.
     * <p/>
     * This ID must be unique across all children within the group.
     * The combined ID (see {@link RecyclerViewExpandableItemManager#getCombinedChildId(long, long)})
     * must be unique across ALL items (groups and all children).
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which the ID is wanted
     * @return the ID associated with the child
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        cursor.moveToPosition(groupPosition);
        UsedHouse house = dao.readEntity(cursor, 0);
        return (long) -house.getId();

    }

    /**
     * Gets the view type of the specified group.
     *
     * @param groupPosition the position of the group for which the view type is wanted
     * @return integer value identifying the type of the view needed to represent the group item at position. Type codes need positive number but not be contiguous.
     */
    @Override
    public int getGroupItemViewType(int groupPosition) {
        return 0;//创建GVH时候会传入函数用于辨别类型创建相应的VIEW
    }

    /**
     * Gets the view type of the specified child.
     *
     * @param groupPosition the position of the group that contains the child
     * @param childPosition the position of the child within the group for which the view type is wanted
     * @return integer value identifying the type of the view needed to represent the group item at position. Type codes need positive number but not be contiguous.
     */
    @Override
    public int getChildItemViewType(int groupPosition, int childPosition) {
        return 0;//创建CVH时候会传入函数用于辨别类型创建相应的VIEW
    }

    /**
     * Called when RecyclerView needs a new {@link HousePreviewGVH} of the given type to represent a group item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType The view type of the new View
     * @return A new group ViewHolder that holds a View of the given view type
     */
    @Override
    public HousePreviewGVH onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.item_house_preview, parent, false);
        return new HousePreviewGVH(v);
    }

    /**
     * Called when RecyclerView needs a new {@link HousePreviewCVH} of the given type to represent a child item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType The view type of the new View
     * @return A new child ViewHolder that holds a View of the given view type
     */
    @Override
    public HousePreviewCVH onCreateChildViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View v = inflater.inflate(R.layout.item_house_expand, parent, false);
        return new HousePreviewCVH(v);
    }

    /**
     * Called by RecyclerView to display the group data at the specified position.
     * This method should update the contents of the {@link android.support.v7.widget.RecyclerView.ViewHolder#itemView}
     * to reflect the item at the given position.
     *
     * @param holder        The ViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param groupPosition The position of the group item within the adapter's data set
     * @param viewType      The view type code
     */
    @Override
    public void onBindGroupViewHolder(HousePreviewGVH holder, int groupPosition, int viewType) {
        cursor.moveToPosition(groupPosition);
        UsedHouse house = dao.readEntity(cursor, 0);

        holder.vTitle.setText(
                String.format("%s %d室%d厅 %s %.2f㎡",
                        house.getDistrict(),
                        house.getBedRooms(),
                        house.getLivingRooms(),
                        house.getDecoration(),
                        house.getGrossArea()
                ));
        //TODO 计算距离
        holder.vDistance.setText("1.1km");
        holder.vLoacation.setText(house.getRQName());
        holder.vCard.setCardElevation(0);
        holder.vPrice.setText(String.format("%.1f万", (float) house.getPrice() / 10000));
        holder.vSubPrice.setText(String.format("%d/㎡", (int) (house.getPrice() / house.getGrossArea())));
        int imageCount = house.getPhotoCount();
        if (imageCount > 1) {
            holder.vImageCount.setText(String.format("x%d", imageCount));
            holder.vImageCount.setVisibility(View.VISIBLE);
        } else
            holder.vImageCount.setVisibility(View.INVISIBLE);

        //if(imageAware == null)
        //第二个参数是是否检查控件实际尺寸.在这种控件尺寸固定的模式下不用
        imageAware = new ImageViewAware(holder.vImage);
        ImageLoader.getInstance().displayImage(house.getImageUrl(), holder.vImage, null, null, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String s, View view, int i, int i1) {

            }
        });
    }

    /**
     * Called by RecyclerView to display the child data at the specified position.
     * This method should update the contents of the {@link android.support.v7.widget.RecyclerView.ViewHolder#itemView}
     * to reflect the item at the given position.
     *
     * @param holder        The ViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param groupPosition The position of the group item within the adapter's data set
     * @param childPosition The position of the child item within the group
     * @param viewType      The view type code
     */
    @Override
    public void onBindChildViewHolder(HousePreviewCVH holder, int groupPosition, int childPosition, int viewType) {
        holder.vText.setText("展开拉");
    }

    /**
     * Called when a user attempt to expand/collapse a group item by tapping.
     *
     * @param holder        The ViewHolder which is associated to group item user is attempt to expand/collapse
     * @param groupPosition Group position
     * @param x             Touched X position. Relative from the itemView's top-left
     * @param y             Touched Y position. Relative from the itemView's top-left
     * @param expand        true: expand, false: collapse
     * @return Whether to perform expand/collapse operation.
     */
    @Override
    public boolean onCheckCanExpandOrCollapseGroup(HousePreviewGVH holder, int groupPosition, int x, int y, boolean expand) {
        return true;
    }
}