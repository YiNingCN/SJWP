package com.soujuw.android.partner.Database;

/**
 * 房产信息提供接口。
 */
public interface HousePreviewDataProvider {

    /**
     * @return 房产的主显示格标题文本(第一行)
     */
    public CharSequence dataPreviewTitle();

    /**
     * @return 地理距离的文本。如1.1KM / 680米..
     */
    public CharSequence dataDistanceText();

    /**
     * @return 显示在地理距离之后的文本信息.一般是小区名称
     */
    public CharSequence dataTextAfterDistance();

    /**
     * @return 房子信息的 主要价格
     * 二手房源的主要价格是总价.
     * 出租房源的主要价格是月租
     */
    public int dataMainPrice();

    /**
     * @return 房子信息的 次要价格
     * 二手房源的次要价格是平方单价.
     * 出租房源的次要价格是押金
     */
    public int dataSubPrice();


    /**
     * @return 主要缩略图的URI。
     */
    public String dataPreviewPictureUri();

    /**
     * @return 房产信息的图片总数. 用于在缩略图上显示图片总数。
     */
    public int dataPictureCount();

    /**
     * @return id
     */
    public int dataID();
}
