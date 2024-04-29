'use client'

import { deleteCookie } from "cookies-next"
import { useRouter } from "next/navigation"

export default function PaymentDetails(){
    const router = useRouter()

    const handleClosing = async () => {
        await fetch("https://localhost:8080/Closure")
        .then(window.location.reload())
    }

    const handleLogout = async () => {
        deleteCookie('loggedIn')
        router.push("/login")
    }

    const handleRegistration = async () => {
        router.push("/registration")
    }

    return(
        <div className="flex flex-col gap-5">
            <button className="border-2 border-mainText rounded-md w-2/3 mx-auto p-2 uppercase" type="button" onClick={handleLogout}>logout</button>
            <button className="border-2 border-mainText rounded-md w-2/3 mx-auto p-2 uppercase" type="button" onClick={handleRegistration}>register new user</button>
            <button className="border-2 border-mainText rounded-md w-2/3 mx-auto p-2 uppercase" type="button" onClick={handleClosing}>close all reservations</button>
        </div>
    )
}