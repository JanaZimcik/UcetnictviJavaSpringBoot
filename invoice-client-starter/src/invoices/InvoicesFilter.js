import React from 'react';
import InputSelect from '../components/InputSelect';
import InputField from '../components/InputField';

const InvoicesFilter = (props) => {

    const handleChange = (e) => {
        props.handleChange(e);
    };

    const handleSubmit = (e) => {
        props.handleSubmit(e);
    };

    const filter = props.filter;

    return (
        <form onSubmit={handleSubmit}>
                <div className="col">
                    <InputSelect
                        name="buyerId"
                        items={props.buyerList}
                        handleChange={handleChange}
                        label="Odběratel"
                        prompt="nevybrán"
                        value={filter.buyerId}
                    />
                </div>
                <div className="col">
                    <InputSelect
                        name="sellerId"
                        items={props.sellerList}
                        handleChange={handleChange}
                        label="Dodavatel"
                        prompt="nevybrán"
                        value={filter.sellerId}
                    />
                </div>
                <div className="col">
                    <InputSelect
                        name="product"
                        items={props.productList}
                        handleChange={handleChange}
                        label="Produkt"
                        prompt="nevybrán"
                        value={filter.product}
                        enum={true}
                    />
                </div>
                <div className="col">
                    <InputField
                        type="number"
                        min="0"
                        name="minPrice"
                        handleChange={handleChange}
                        label="Cena od"
                        prompt="neuveden"
                        value={filter.minPrice ? filter.minPrice : ''}
                    />
                </div>
    
                <div className="col">
                    <InputField
                        type="number"
                        min="0"
                        name="maxPrice"
                        handleChange={handleChange}
                        label="Cena do"
                        prompt="neuveden"
                        value={filter.maxPrice ? filter.maxPrice : ''}
                    />
                </div>
    
                <div className="col">
                    <InputField
                        type="number"
                        min="1"
                        name="limit"
                        handleChange={handleChange}
                        label="Limit počtu faktur"
                        prompt="neuveden"
                        value={filter.limit ? filter.limit : ''}
                    />
                </div>
    
            <div className="row">
                <div className="col">
                    <input
                        type="submit"
                        className="btn btn-secondary float-right mt-2"
                        value={props.confirm}
                    />
                </div>
            </div>
        </form>
    );
};

export default InvoicesFilter;