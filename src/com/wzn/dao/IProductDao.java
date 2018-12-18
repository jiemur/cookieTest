package com.wzn.dao;

import com.wzn.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getLists();   //查询
    public int add(Product product);   //添加
    public int dele(int id);  //删除
    public Product getOne(int id);  //查找一个
    public int amend(Product product);  //修改
}
