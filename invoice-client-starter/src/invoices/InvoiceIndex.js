import React, {useEffect, useState} from "react";

import {apiDelete, apiGet} from "../utils/api";

import InvoiceTable from "./InvoiceTable";
import InvoicesFilter from "./InvoicesFilter";

const InvoiceIndex = () => {
    const [invoices, setInvoices] = useState([]);
    const [buyerListState, setBuyerList] = useState([]);
    const [sellerListState, setSellerList] = useState([]);
    const [productsListState, setProductsList] = useState([]);
    const [filterState, setFilter] = useState({
        buyerId: undefined,
        sellerId: undefined,
        product: undefined,
        minPrice: undefined,
        maxPrice: undefined,
        limit: undefined,
        });

    const deleteInvoice = async (id) => {
        try {
            await apiDelete("/api/invoices/" + id);
            setInvoices(invoices.filter((item) => item._id !== id));
        } catch (error) {
            console.log(error.message);
            alert(error.message)
        }
        
    };

    const handleChange = (e) => {
        if (e.target.value === "false" || e.target.value === "true" || e.target.value === '') {
            setFilter(prevState => {
                return {...prevState, [e.target.name]: undefined}
            });
        } else {
            setFilter(prevState => {
                return { ...prevState, [e.target.name]: e.target.value}
            });
        }
    };
    
    const handleSubmit = async (e) => {
        e.preventDefault();
        const params = filterState;
    
        const data = await apiGet("/api/invoices", params);
        setInvoices(data);
    };

    useEffect(() => {
        apiGet("/api/invoices").then((data) => setInvoices(data));
        apiGet('/api/persons').then((data) => {
            setBuyerList(data);
            setSellerList(data);
        });
        apiGet("/api/products").then((data) => setProductsList(data));
        }, []);

    return (
        <div class="container-fluid">
            <div class="row">
                <div class="col-10">
                    <h1>Seznam faktur</h1>
                    <InvoiceTable
                        deleteInvoice={deleteInvoice}
                        items={invoices}
                        label="Počet faktur:"
                    />
                </div>
                <div class="col-2">
                    <br/>
                    <br/>
                    <br/>
                    <InvoicesFilter
                        handleChange={handleChange}
                        handleSubmit={handleSubmit}
                        buyerList={buyerListState}
                        sellerList={sellerListState}
                        productList={productsListState}
                        filter={filterState}
                        confirm="Filtrovat faktury"
                    />
                </div>
            </div>
        </div>
    );
};
export default InvoiceIndex;
