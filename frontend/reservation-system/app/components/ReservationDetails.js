import { useRef } from "react";
import { getCurrentDateTime } from "../utils";

export default function ReservationDetails({desk}){
    const elementRef = useRef();        
  
    async function handleSubmit(e){
      e.preventDefault();
  
      const fname = elementRef.current.querySelector("#fname").value
      const fstartTime = elementRef.current.querySelector("#fstartTime").value
      const fendTime = elementRef.current.querySelector("#fendTime").value
      // const fdesks = elementRef.current.querySelector("#fdesks")
      
      const formData = {
        name: fname,
        startTime: fstartTime,
        endTime: fendTime,
        deskIds: desk
      };
  
      try {
        const response = await fetch('http://localhost:8080/Reservation', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(formData)
        });
  
        if (response.ok) {
          console.log("jupiii")
          window.location.reload();
        } else {
          
        }
      } catch (error) {
          console.log(error)
      }
    }

    const currentTime = getCurrentDateTime();
    console.log(currentTime)

    return(
        <form className="flex flex-col" onSubmit={handleSubmit} ref={elementRef}>           
            <label htmlFor="fname">name</label>
            <input type="text" id="fname" name="fname" className="bg-mainBackground"></input>

            <label htmlFor="fstartTime">reservation start</label>
            <input type="datetime-local" id="fstartTime" name="fstartTime" min={currentTime} value={currentTime} className="bg-mainBackground"></input>

            <label htmlFor="fendTime">reservation end</label>
            <input type="datetime-local" id="fendTime" name="fendTime" value={getCurrentDateTime(1)} className="bg-mainBackground"></input>

            <label htmlFor="fdesks">desks</label>
            <input type="text" id="fdesks" name="fdesks" className="bg-mainBackground text-gray-400" value={desk} disabled readOnly={true}></input>
            
            <button type="submit" id="loadBtn">Load data</button>
        </form>
    )
}