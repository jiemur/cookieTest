package com.wzn.service;


import com.wzn.dao.IProductDao;
import com.wzn.dao.ProductDaoImpl;
import com.wzn.pojo.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductDao dao = new ProductDaoImpl();
    @Override
    public List<Product> getLists() {
        return dao.getLists();
    }

    @Override
    public int add(Product product) {
        return dao.add(product);
    }

    @Override
    public int dele(int id) {
        return dao.dele(id);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int amend(Product product) {
        return dao.amend(product);
    }
}
