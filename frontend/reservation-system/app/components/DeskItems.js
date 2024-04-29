"use client"
import { useState, useEffect } from "react"

export default function DeskItems({}){
    const [data, setData] = useState([])

    useEffect(() => {
      fetch('http://localhost:8080/today')
      .then(response => response.json())
      .then(data => setData(data))
    }, [])
    
    // potrebuji vedet jak bych mohl ukladat itemy z menu k prislusne objednavce - napr aby objednavka na stul 1 mohla objednat itemy z menu 2 a 3
    // staci mi vedet kam posilat post toho aktualne selected stolu
    
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