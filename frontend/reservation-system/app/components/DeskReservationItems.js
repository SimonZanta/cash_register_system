import { useState, useEffect, useRef } from "react"
import { getCurrentDateTime } from "../utils"

export default function DeskReservationItems({onSelectItems}){
    const elementRef = useRef();   
    const [data, setData] = useState([])

    function handleSubmit(e){
        const selectedCheckboxes = elementRef.current.querySelectorAll('input[name=check]:checked')
        const result = []
        for(let i = 0; i < selectedCheckboxes.length; i++){
            result.push(selectedCheckboxes[i].value)
        }
        onSelectItems(result)
    }

    function filterDesk(resDesk, desk){
        const filteredReservationDesk = filterReservationDesk(resDesk)
    
        const filteredDesk = filteredReservationDesk.map(getDesk)

        const result = desk.filter((desk) => !filteredDesk.includes(desk.id))
    
        setData(result)
    
        function getDesk(item){
            return item.desk.id
        }
    }

    useEffect(() => {
      fetch('http://localhost:8080/ReservationDesk')
      .then(response => response.json())
      .then(resDesk => fetch('http://localhost:8080/Desk')
            .then(response => response.json())
            .then(desk => filterDesk(resDesk, desk)))
    }, [])

    return(
        <form onChange={handleSubmit} ref={elementRef} className="flex flex-col gap-5">
            {data.map(value => (
                <div key={value.id + "DeskReservationWrapp"} className="relative flex flex-row gap-5">
                    <span >{value.id}</span>
                    <span >{value.name}</span>
                    <input type="checkbox" name="check" value={value.id} readOnly></input>
                </div>
            ))}
        </form>
    )
}

function filterReservationDesk(data){
    return data.filter((xd) => xd.reservation.end_time >= getCurrentDateTime())
}