package com.weidu.mall.platform.entity;

import java.util.List;

public class ProductBean {

    public String message;
    public String status;
    public Product result;

    public static class Product{
        public List<ProductItemBean> rxxp;
        public List<ProductItemBean> pzsh;
        public List<ProductItemBean> mlss;
    }

    public class ProductItemBean {
        public String id;
        public String name;
        public List<ProductItem>  commodityList;

        public  class  ProductItem{
            public String commodityId;
            public String commodityName;
            public String masterPic;
            public String price;
            public String saleNum;
        }
    }


}
