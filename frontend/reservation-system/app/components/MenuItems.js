import { useState, useEffect } from "react"

export default function MenuItems({}){
    const [data, setData] = useState([])

    useEffect(() => {
      fetch('http://localhost:8080/Menu')
      .then(response => response.json())
      .then(data => setData(data))
    }, [])
    return(
        <div className="flex flex-col gap-5">
            {data.map(value => (
                <div key={value.id + "MenuItemsWrapp"} className="relative flex flex-row gap-5">
                    <span>{value.id}</span>
                    <span>{value.name}</span>
                    <span className="absolute right-5">{value.weight}g</span>
                </div>
            ))}
        </div>
    )
}