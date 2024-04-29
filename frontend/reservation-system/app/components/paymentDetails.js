'use client'
export default function PaymentDetails(){

    const handleClosing = async () => {
        await fetch("https://localhost:8080/Closure")
        .then(window.location.reload())
    }

    return(
        <button className="border-2 border-mainText rounded-md w-max mx-auto p-2 uppercase" type="button" onClick={handleClosing}>close all reservations</button>
    )
}