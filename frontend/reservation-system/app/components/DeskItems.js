"use client"
import { useState, useEffect } from "react"

export default function DeskItems({}){
    const [data, setData] = useState([])

    useEffect(() => {
      fetch('http://localhost:8080/Desk')
      .then(response => response.json())
      .then(data => setData(data))
    }, [])
    return(
        <div className="flex flex-col gap-5">
            {data.map(value => (
                <div key={value.id + "DeskItemsWrapp"} className="relative flex flex-row gap-5">
                    <span>{value.id}</span>
                    <span>{value.name}</span>
                </div>
            ))}
        </div>
    )
}