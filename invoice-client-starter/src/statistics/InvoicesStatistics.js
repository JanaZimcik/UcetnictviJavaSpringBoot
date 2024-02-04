import React, {useEffect, useState} from "react";

import {apiDelete, apiGet} from "../utils/api";

const InvoicesStatistics = () => {
    const [statistic, setStatistic] = useState({});

    useEffect(() => {
        apiGet("/api/invoices/statistics").then((data) => setStatistic(data));
    }, []);

    return (
        <>
            <div>
                <h3>Obecné statistiky</h3>
                <hr/>
                <p>
                    <strong>Celková částka za rok: </strong>
                    {statistic.currentYearSum}
                </p>
                <p>
                    <strong>Celková částka za celé období: </strong>
                    {statistic.allTimeSum}
                </p>
                <p>
                    <strong>Počet faktur: </strong>
                    {statistic.invoicesCount}
                </p>
            </div>
        </>
    );
    
};
export default InvoicesStatistics;