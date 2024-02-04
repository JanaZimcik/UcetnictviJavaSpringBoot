import React, {useEffect, useState} from "react";

import {apiDelete, apiGet} from "../utils/api";

const PersonsStatistics = () => {
    const [statistics, setStatistics] = useState([]);

    useEffect(() => {
        apiGet("/api/persons/statistics").then((data) => setStatistics(data));
    }, []);

    return (
        <>
            <div>
                <h3>Statistiky pro jednotlivé společnosti</h3>
                <hr/>
                <table className="table table-bordered">
                <thead>
                <tr>
                    <th>Jméno</th>
                    <th>Příjmy</th>
                </tr>
                </thead>
                <tbody>
                {statistics.map((personStatistic) => (
                    <tr>
                        <td>{personStatistic.personName}</td>
                        <td>{personStatistic.revenue}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            </div>
        </>
    );
    
};
export default PersonsStatistics;