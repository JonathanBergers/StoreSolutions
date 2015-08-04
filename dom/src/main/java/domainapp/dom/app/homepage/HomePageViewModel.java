/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.dom.app.homepage;

import java.math.BigDecimal;
import java.util.List;

import domainapp.dom.modules.rozenkwekerij.Rose;
import domainapp.dom.modules.rozenkwekerij.RoseStrain;
import domainapp.dom.modules.rozenkwekerij.Roses;
import domainapp.dom.modules.stockpilemanagement.product.Product;
import domainapp.dom.modules.stockpilemanagement.product.Products;
import domainapp.dom.modules.stockpilemanagement.stock.Stock;
import domainapp.dom.modules.stockpilemanagement.stock.Stocks;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.*;


import javax.inject.Inject;

@ViewModel
@ViewModelLayout(paged = 5)
public class HomePageViewModel{

    //region > title
    public String title() {
        return "Welkom " + container.getUser().getName();
    }
    //endregion

    //region > object (collection)
    @MemberOrder(name = "Producten", sequence = "1")
    @CollectionLayout(render = RenderType.EAGERLY, named = "Producten")
    public List<Product> getProducts(){

        return products.listAll();
    }
    //endregion

    @MemberOrder(sequence = "2", name = "Producten")
    @Action
    @ActionLayout(named = "Voeg roos toe")
    public Rose createRose(@ParameterLayout(named = "Soort")final RoseStrain strain,
                           @ParameterLayout(named = "Titel")final String title,
                           @ParameterLayout(named = "Beschrijving")final String description,
                           @ParameterLayout(named = "Inkoopprijs")final BigDecimal costPrice,
                           @ParameterLayout(named = "Verkoopprijs")final BigDecimal sellingPrice
                           ) {
        return roses.createRose(title, description, costPrice,sellingPrice, strain);

    }




    //region > object (collection)
    @MemberOrder(name = "Voorraad", sequence = "1")
    @CollectionLayout(render = RenderType.EAGERLY, named = "Voorraden")
    public List<Stock> getStock(){

        return stocks.listAll();
    }
    //endregion


    @Inject
    DomainObjectContainer container;

    @Inject
    Products products;

    @Inject
    Stocks stocks;

    @Inject
    Roses roses;

    //endregion
}
