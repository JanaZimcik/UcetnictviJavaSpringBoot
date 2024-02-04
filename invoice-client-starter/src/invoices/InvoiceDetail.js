import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";

import {apiGet} from "../utils/api";

const InvoiceDetail = () => {
    const {id} = useParams();
    const [invoice, setInvoice] = useState({});
    const [seller, setSeller] = useState({});
    const [buyer, setBuyer] = useState({});

    useEffect(() => {
        apiGet("/api/invoices/" + id).then((data) => setInvoice(data));
    }, [id]);

    useEffect(() => {
        apiGet("/api/persons/" + (invoice.seller ? invoice.seller._id : "")).then((data) => setSeller(data));
    }, [invoice.seller]);

    useEffect(() => {
        apiGet("/api/persons/" + (invoice.buyer ? invoice.buyer._id : "")).then((data) => setBuyer(data));
    }, [invoice.buyer]);

    return (
        <>
            <div>
                <h1>Detail faktury</h1>
                <hr/>
                <h3>{invoice.invoiceNumber}</h3>
                
                <div className="container">
                    <div class="row">
                        <div class="col-6">
                            <p>
                                <strong>Dodavatel:</strong>
                                <br/>
                                Jméno: <Link to={"/persons/show/" + seller._id}>
                                {invoice.seller ? invoice.seller.name : ""},
                            </Link><br/>
                                Adresa: {invoice.seller ? invoice.seller.street : ""}, <br/>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; {invoice.seller ? invoice.seller.zip : ""}, {invoice.seller ? invoice.seller.city : ""}, <br/>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; {invoice.seller ? invoice.seller.country : ""}, <br/>
                                <br/>
                                IČO: {invoice.seller ? invoice.seller.identificationNumber : ""}, <br/>
                                DIČ: {invoice.seller ? invoice.seller.taxNumber : ""}, <br/>
                                Banka: {invoice.seller ? invoice.seller.accountNumber : ""}/{invoice.seller ? invoice.seller.bankCode : ""}, IBAN: {invoice.seller ? invoice.seller.iban : ""} <br/>
                            </p>
                        </div>
                        <div class="col-6">
                            <p>
                                <strong>Odběratel:</strong>
                                <br/>
                                Jméno: <Link to={"/persons/show/" + buyer._id}>
                                {invoice.buyer ? invoice.buyer.name : ""},
                            </Link><br/>
                                Adresa: {invoice.buyer ? invoice.buyer.street : ""}, <br/>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; {invoice.buyer ? invoice.buyer.zip : ""}, {invoice.buyer ? invoice.buyer.city : ""}, <br/>
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; {invoice.buyer ? invoice.buyer.country : ""}, <br/>
                                <br/>
                                IČO: {invoice.buyer ? invoice.buyer.identificationNumber : ""}, <br/>
                                DIČ: {invoice.buyer ? invoice.buyer.taxNumber : ""}
                            </p>
                        </div>
                    </div>
                </div>

                <p>
                    <strong>Datum vystavení faktury:</strong>
                    <br/>
                    {invoice.issued}
                </p>
                <p>
                    <strong>Datum splatnosti faktury:</strong>
                    <br/>
                    {invoice.dueDate}
                </p>

                <div class="container">
                    <div class="row">
                        <div class="col-4">
                            <p>
                                <strong>Produkt:</strong>
                                <br/>
                                {invoice.product}
                            </p>
                        </div>
                        <div class="col-4">
                            <p>
                                <strong>Cena:</strong>
                                <br/>
                                {invoice.price}
                            </p>
                        </div>
                        <div class="col-4">
                            <p>
                                <strong>Daň:</strong>
                                <br/>
                                {invoice.vat}
                            </p>
                        </div>
                    </div>
                </div>
                
                <p>
                    <strong>Poznámka:</strong>
                    <br/>
                    {invoice.note}
                </p>
            </div>
        </>
    );
};

export default InvoiceDetail;