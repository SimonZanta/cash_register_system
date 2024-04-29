"use client"
import ScrollableBlock from "./components/UI/scrollableBlock";
import MenuItems from "./components/MenuItems";
import DeskItems from "./components/DeskItems";
import DeskReservationItems from "./components/DeskReservationItems";
import { useState } from "react";
import ReservationDetails from "./components/ReservationDetails";
import PaymentDetails from "./components/paymentDetails";

export default function Home() {

  const [selectedTables, setSelectedTables] = useState("")

  return (
    <main className="text-base">
    <div className="grid grid-cols-3 grid-rows-1 ">

      <div className="col-start-1 ">
        <ScrollableBlock blockName="table orders"><DeskItems /></ScrollableBlock>
      </div>

      <div className="col-start-2 row-span-2">
        <ScrollableBlock isCenter={true} blockName="menu"><MenuItems/></ScrollableBlock>
      </div>

      <div className="col-start-3">
        <ScrollableBlock blockName="table reservation"><DeskReservationItems onSelectItems={setSelectedTables}/></ScrollableBlock>
      </div>

      <div className="col-start-1 row-start-2">
        <ScrollableBlock blockName="payments"><PaymentDetails/></ScrollableBlock>
      </div>
      <div className="col-start-3 row-start-2">
        <ScrollableBlock blockName="reservation details"><ReservationDetails desk={selectedTables}/></ScrollableBlock>
      </div>
    </div>
    </main>
  );
}
