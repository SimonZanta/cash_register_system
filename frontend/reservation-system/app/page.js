"use client"
import ScrollableBlock from "./components/UI/scrollableBlock";
import MenuItems from "./components/MenuItems";
import DeskItems from "./components/DeskItems";
import DeskReservationItems from "./components/DeskReservationItems";
import { useState } from "react";
import ReservationDetails from "./components/ReservationDetails";

export default function Home() {

  const [selectedItems, setSelectedItems] = useState("")

  console.log()

  return (
    <main>
    <div className="grid grid-cols-3 grid-rows-1 ">

      <div className="col-start-1 ">
        <ScrollableBlock><DeskItems /></ScrollableBlock>
      </div>

      <div className="col-start-2 row-span-2">
        <ScrollableBlock isCenter={true}><MenuItems/></ScrollableBlock>
      </div>

      <div className="col-start-3">
        <ScrollableBlock><DeskReservationItems onSelectItems={setSelectedItems}/></ScrollableBlock>
      </div>

      <div className="col-start-1 row-start-2">
        <ScrollableBlock></ScrollableBlock>
      </div>
      <div className="col-start-3 row-start-2">
        <ScrollableBlock><ReservationDetails desk={selectedItems}/></ScrollableBlock>
      </div>
    </div>
    </main>
  );
}
