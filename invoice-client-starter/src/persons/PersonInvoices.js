import React, {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {apiGet} from "../utils/api";

const PersonInvoices = ({identificationNumber}) => {
    const {id} = useParams();
    const [issuedInvoices, setIssuedInvoices] = useState([]);
    const [acceptedInvoices, setAcceptedInvoices] = useState([]);

    useEffect(() => {
        apiGet("/api/identification/" + identificationNumber + "/sales").then((data) => setIssuedInvoices(data));
        apiGet("/api/identification/" + identificationNumber + "/purchases").then((data) => setAcceptedInvoices(data));
    }, [identificationNumber]); 

    return (
        <div>
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Vystavené faktury</th>
                </tr>
                </thead>
                <tbody>
                {issuedInvoices.map((invoice) => (
                    <tr>
                        <td>
                            <Link to={"/invoices/show/" + invoice._id} className="btn btn-info">
                                {invoice.invoiceNumber}
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Přijaté faktury</th>
                </tr>
                </thead>
                <tbody>
                {acceptedInvoices.map((invoice) => (
                    <tr>
                        <td>
                            <Link to={"/invoices/show/" + invoice._id} className="btn btn-info">
                                {invoice.invoiceNumber}
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default PersonInvoices;