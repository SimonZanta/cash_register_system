"use client"
import { useState, useEffect } from "react"

export default function ScrollableBlock({blockName = "blockName", isCenter = false}){
    const [data, setData] = useState([])

    useEffect(() => {
    //   fetch('http://localhost:8080/api/get')
    //   .then(response => response.json())
    //   .then(data => setData(data))
        const exampleData = []
        for(let i = 0; i<100;i++){
            exampleData[i] = "fsdfa"
        }
        setData(exampleData)
    }, [])

    return( 
        <div className={"px-5 " + (isCenter ? 'h-[100vh]' : 'h-[50vh]')}>
            <div className="text-center uppercase sticky top-0 p-5">
                {blockName}
            </div>
            <div className={"overflow-auto px-7 pt-3 bg-[#121212] " + (isCenter ? 'h-[87.6%]' : 'h-[75%]')}>
                <div className="flex flex-col">
                {data.map(value => (
                    <span>{value}</span>
                ))}
                </div>
            </div>
        </div>
    )
  
}