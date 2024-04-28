import { useState, useEffect } from "react"

export default function MenuItems({}){
    const [data, setData] = useState([])

    console.log(data)

    useEffect(() => {
      fetch('http://localhost:8080/Menu')
      .then(response => response.json())
      .then(data => setData(data))
    }, [])
    return(
        <div className="flex flex-col gap-5">
            {data.map((value, index) => (
                <div key={value.id + "MenuItemsWrapp"} className="relative flex flex-row gap-5">
                    <span>{value.id}</span>
                    <span>{value.name}</span>
                    <div className="absolute right-1">
                        <span>{value.weight}g</span>
                        <span className="pl-4">{value.price},-</span>
                    </div>
                </div>
            ))}
        </div>
    )
}