package com.example.administrator.listviewpull;

import java.util.List;

/**
 * Created by Administrator on 2019/11/6.
 */

public class GoodsListModel {
    private String status;
    private String order_id;
    private String sub_ordernum;
    private String ntotal_price;
    private String shop_name;
    private String logo;
    private List<GoodInfo> goodinfo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSub_ordernum() {
        return sub_ordernum;
    }

    public void setSub_ordernum(String sub_ordernum) {
        this.sub_ordernum = sub_ordernum;
    }

    public String getNtotal_price() {
        return ntotal_price;
    }

    public void setNtotal_price(String ntotal_price) {
        this.ntotal_price = ntotal_price;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<GoodInfo> getGoodinfo() {
        return goodinfo;
    }

    public void setGoodinfo(List<GoodInfo> goodinfo) {
        this.goodinfo = goodinfo;
    }

    public class GoodInfo{

        private String nprice;
        private String num;
        private String photo;
        private String title;
        private String goods_attr;

        public String getNprice() {
            return nprice;
        }

        public void setNprice(String nprice) {
            this.nprice = nprice;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGoods_attr() {
            return goods_attr;
        }

        public void setGoods_attr(String goods_attr) {
            this.goods_attr = goods_attr;
        }
    }


}
