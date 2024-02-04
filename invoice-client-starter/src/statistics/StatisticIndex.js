import React, {useEffect, useState} from "react";

import {apiDelete, apiGet} from "../utils/api";
import InvoicesStatistics from "./InvoicesStatistics";
import PersonsStatistics from "./PersonsStatistics";


const StatisticIndex = () => {
    const [person, setPersons] = useState({});

    useEffect(() => {
        apiGet("/api/persons").then((data) => setPersons(data));
    }, []);

    return (
        <div>
        <h1>Statistiky</h1>
        <div><InvoicesStatistics/></div>
        <div><PersonsStatistics/></div>
    </div>
);
};
export default StatisticIndex;
