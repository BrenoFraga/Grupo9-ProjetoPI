import { AutoComplete } from 'primereact/autocomplete';
import { useEffect, useState } from 'react';
import { AutoCompleteService } from './findr-autocomplete-service';
const countryservice = new AutoCompleteService();

function FindrAutocomplete() {
    const [countries, setCountries] = useState([]);
    const [selectedCountry1, setSelectedCountry1] = useState([]);
    const [filteredCountries, setFilteredCountries] = useState([]);

    useEffect(() => {
        countryservice.getCountries().then(data => setCountries(data));
        console.log("data,", countries);
    }, []); 

    const searchCountry = (event) => {
        setTimeout(() => {
            let _filteredCountries;
            if (!event.query.trim().length) {
                _filteredCountries = [...countries];
            }
            else {
                _filteredCountries = countries.filter((country) => {
                    console.log("prova", country.name)
                    return country.name.toLowerCase().startsWith(event.query.toLowerCase());
                });
            }

            setFilteredCountries(_filteredCountries);
        }, 250);
    }

    return (
    <>
    <AutoComplete value={selectedCountry1} suggestions={filteredCountries} completeMethod={searchCountry} field="name" onChange={(e) => setSelectedCountry1(e.value)} aria-label="Countries" />
    </>  
    );

}

export default FindrAutocomplete;