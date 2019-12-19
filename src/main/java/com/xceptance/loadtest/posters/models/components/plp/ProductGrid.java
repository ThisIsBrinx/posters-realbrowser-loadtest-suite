package com.xceptance.loadtest.posters.models.components.plp;

import com.xceptance.loadtest.api.hpu.LookUpResult;
import com.xceptance.loadtest.api.models.components.Component;
import com.xceptance.loadtest.api.models.pages.Page;

public class ProductGrid implements Component
{
    public static final ProductGrid instance = new ProductGrid();

    public ProductTile productTile = ProductTile.instance;

    @Override
    public LookUpResult locate()
    {
        return Page.find().byId("main").byCss("#productOverview");
    }

    @Override
    public boolean exists()
    {
        return locate().exists();
    }

    public LookUpResult getProducts()
    {
        return productTile.locate();
    }

    public int getDisplayedProductCount()
    {
        return productTile.locate().count();
    }

    public LookUpResult getFooter()
    {
        return locate().byCss(".grid-footer");
    }

    public LookUpResult getMoreButton()
    {
        return getFooter().byCss(".show-more button");
    }
}